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
import br.com.projetos.android.lista.AtividadeListFragment;
import br.com.projetos.android.modelos.Atividade;
import br.com.projetos.android.modelos.InformacaoConsultaAtividade;
import br.com.projetos.android.modelos.Modulo;
import br.com.projetos.android.modelos.TipoMensagem;
import br.com.projetos.android.service.AtividadeService;
import br.com.projetos.android.util.DialogMensagem;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author gilmario
 */
public class AtividadeConsultaActivity extends ServerActivity implements AdapterView.OnItemClickListener {

    private Modulo modulo;
    private AtividadeService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        service = new AtividadeService(getServidor());
        modulo = new Modulo();
        modulo.setId(getVariavelLong(AdminModuloActivity.MODULO_SELECIONADO_ID));
        modulo.setNome(getVariavelString(AdminModuloActivity.MODULO_SELECIONADO_NOME));
        this.setContentView(R.layout.atividade_consulta);
        listar();
    }

    private void novo() {
        startActivity(new Intent(this, ModuloActivity.class));
    }

    private void mostraLista(ArrayList<Atividade> atividades) {
        if (atividades.isEmpty()) {
            new DialogMensagem().mensagemDialogOK(this, "Nenhum resultado encontrado", "Atenção", "");
        } else {
            AtividadeListFragment fragment = (AtividadeListFragment) getFragmentManager().findFragmentByTag("lista");
            fragment.listar(atividades);
        }
    }

    public void listar() {
        new AsyncTask<Void, Void, InformacaoConsultaAtividade>() {

            @Override
            protected InformacaoConsultaAtividade doInBackground(Void... on) {
                try {
                    return service.listarAtividade(modulo.getProjeto());
                } catch (Exception e) {
                    Log.e("ERRO", "Erro ao Listar", e);
                    return new InformacaoConsultaAtividade(TipoMensagem.ERRO, "ERRO", e.toString());
                }
            }

            @Override
            protected void onPostExecute(InformacaoConsultaAtividade informacao) {
                if (TipoMensagem.SUCESSO.equals(informacao.getTipo())) {
                    mostraLista(informacao.getAtividades());
                } else {
                    new DialogMensagem().mensagemDialogOK(AtividadeConsultaActivity.this, informacao.getConteudo(), informacao.getTitulo(), "sucesso");
                }
            }
        }.execute();
    }

    public void onItemClick(AdapterView<?> adapter, View arg1, int arg2, long arg3) {
        final Map<String, Object> map = (Map<String, Object>) adapter.getAdapter().getItem(arg2);

        new DialogMensagem().mensagemDialogConfirmacao(this, "Selecionar esta Atividade?", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface arg0, int arg1) {
                if (arg1 == DialogInterface.BUTTON_POSITIVE) {
                    inicializaAtividade(map);
                }
            }

        });
    }

    private void inicializaAtividade(Map<String, Object> map) {
        Atividade atividade = new Atividade();
        atividade.setId((Long) map.get("id"));
        atividade.setDescricao((String) map.get("descricao"));
        atividade.setNome((String) map.get("nome"));
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
