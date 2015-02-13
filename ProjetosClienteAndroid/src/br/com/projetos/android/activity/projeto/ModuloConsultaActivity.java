package br.com.projetos.android.activity.projeto;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import br.com.projetos.android.R;
import br.com.projetos.android.ServerActivity;
import br.com.projetos.android.lista.ModuloListFragment;
import br.com.projetos.android.modelos.InformacaoConsultaModulo;
import br.com.projetos.android.modelos.Modulo;
import br.com.projetos.android.modelos.Projeto;
import br.com.projetos.android.modelos.TipoMensagem;
import br.com.projetos.android.service.ModuloService;
import br.com.projetos.android.util.DialogMensagem;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author gilmario
 */
public class ModuloConsultaActivity extends ServerActivity implements AdapterView.OnItemClickListener {

    private Projeto projeto;
    private ModuloService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        service = new ModuloService(getServidor());
        projeto = new Projeto();
        projeto.setId(getVariavelLong(AdminProjetoActivity.PROJETO_SELECIONADO_ID));
        projeto.setNome(getVariavelString(AdminProjetoActivity.PROJETO_SELECIONADO_NOME));
        this.setContentView(R.layout.modulo_consulta);
        listar(null);
    }

    private void novo() {
        startActivity(new Intent(this, ModuloActivity.class));
    }

    private void mostraLista(ArrayList<Modulo> modulos) {
        if (modulos.isEmpty()) {
            new DialogMensagem().mensagemDialogOK(this, "Nenhum resultado encontrado", "Atenção", "");
        } else {
            ModuloListFragment fragment = (ModuloListFragment) getFragmentManager().findFragmentByTag("lista");
            fragment.listar(modulos);
        }
    }

    public void listar(View view) {
        new AsyncTask<Void, Void, InformacaoConsultaModulo>() {

            @Override
            protected InformacaoConsultaModulo doInBackground(Void... on) {
                try {
                    return service.listarModulo(projeto);
                } catch (Exception e) {
                    Log.e("ERRO", "Erro ao Listar", e);
                    return new InformacaoConsultaModulo(TipoMensagem.ERRO, "ERRO", e.toString());
                }
            }

            @Override
            protected void onPostExecute(InformacaoConsultaModulo informacao) {
                if (TipoMensagem.SUCESSO.equals(informacao.getTipo())) {
                    mostraLista(informacao.getModulos());
                } else {
                    new DialogMensagem().mensagemDialogOK(ModuloConsultaActivity.this, informacao.getConteudo(), informacao.getTitulo(), "sucesso");
                }
            }
        }.execute();
    }

    public void onItemClick(AdapterView<?> adapter, View arg1, int arg2, long arg3) {
        final Map<String, Object> map = (Map<String, Object>) adapter.getAdapter().getItem(arg2);

        new DialogMensagem().mensagemDialogConfirmacao(this, "Selecionar este Módulo?", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface arg0, int arg1) {
                if (arg1 == DialogInterface.BUTTON_POSITIVE) {
                    inicializaModulo(map);
                }
            }

        });
    }

    private void inicializaModulo(Map<String, Object> map) {
        Modulo modulo = new Modulo();
        modulo.setId((Long) map.get("id"));
        modulo.setDescricao((String) map.get("descricao"));
        modulo.setNome((String) map.get("nome"));
        setVariavel(AdminModuloActivity.MODULO_SELECIONADO_NOME, modulo.getNome());
        setVariavel(AdminModuloActivity.MODULO_SELECIONADO_ID, modulo.getId());
        startActivity(new Intent(this, AdminModuloActivity.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.projeto_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        if (item.getItemId() == R.id.menu_novo_projeto) {
            novo();
        } else if (item.getItemId() == R.id.menu_sair) {
            finish();
        }
        return super.onMenuItemSelected(featureId, item);
    }

}
