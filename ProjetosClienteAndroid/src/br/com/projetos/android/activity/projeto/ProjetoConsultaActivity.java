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
import android.widget.TextView;
import br.com.projetos.android.MainActivity;
import br.com.projetos.android.R;
import br.com.projetos.android.ServerActivity;
import br.com.projetos.android.lista.ProjetoListFragment;
import br.com.projetos.android.modelos.InformacaoConsultaProjeto;
import br.com.projetos.android.modelos.Projeto;
import br.com.projetos.android.modelos.Responsavel;
import br.com.projetos.android.modelos.TipoMensagem;
import br.com.projetos.android.service.ProjetoService;
import br.com.projetos.android.util.DialogMensagem;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author gilmario
 */
public class ProjetoConsultaActivity extends ServerActivity implements AdapterView.OnItemClickListener {

    public static final String RESPONSAVEL = "responsavel";
    private Responsavel reponsavel;
    private ProjetoService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        service = new ProjetoService(getServidor());
        this.reponsavel = new Responsavel();
        this.reponsavel.setNomeCompleto(getVariavelString(MainActivity.RESPONSAVEL_NOME));
        this.reponsavel.setId(getVariavelLong(MainActivity.RESPONSAVEL_ID));
        this.reponsavel.setLogin(getVariavelString(MainActivity.RESPONSAVEL_LOGIN));
        this.setContentView(R.layout.projeto_consulta);
        TextView text = (TextView) findViewById(R.id.usuario_nome);
        text.setText(reponsavel.getNomeCompleto());
    }

    private void novo() {
        startActivity(new Intent(this, ProjetoActivity.class));
    }

    public void consultar(View view) {
        setContentView(R.layout.projeto_consulta);
    }

    private void mostraLista(ArrayList<Projeto> projetos) {
        if (projetos.isEmpty()) {
            new DialogMensagem().mensagemDialogOK(this, "Nenhum resultado encontrado", "Atenção", "");
        } else {
            ProjetoListFragment fragment = (ProjetoListFragment) getFragmentManager().findFragmentByTag("lista");
            fragment.listar(projetos);
        }
    }

    public void listar(View view) {
        new AsyncTask<Void, Void, InformacaoConsultaProjeto>() {

            @Override
            protected InformacaoConsultaProjeto doInBackground(Void... on) {
                try {
                    return service.listarProjeto();
                } catch (Exception e) {
                    Log.e("ERROX", "Erro ao Listar", e);
                    return new InformacaoConsultaProjeto(TipoMensagem.ERRO, "ERRO", e.toString());
                }
            }

            @Override
            protected void onPostExecute(InformacaoConsultaProjeto informacao) {
                if (TipoMensagem.SUCESSO.equals(informacao.getTipo())) {
                    mostraLista(informacao.getProjetos());
                } else {
                    new DialogMensagem().mensagemDialogOK(ProjetoConsultaActivity.this, informacao.getConteudo(), informacao.getTitulo(), "sucesso");
                }
            }
        }.execute();
    }

    public void onItemClick(AdapterView<?> adapter, View arg1, int arg2, long arg3) {
        final Map<String, Object> map = (Map<String, Object>) adapter.getAdapter().getItem(arg2);

        new DialogMensagem().mensagemDialogConfirmacao(this, "Selecionar esse Projeto?", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface arg0, int arg1) {
                if (arg1 == DialogInterface.BUTTON_POSITIVE) {
                    inicializaModulo(map);
                }
            }

        });
    }

    private void inicializaModulo(Map<String, Object> map) {
        Projeto projeto = new Projeto();
        projeto.setId((Long) map.get("id"));
        projeto.setDescricao((String) map.get("descricao"));
        projeto.setNome((String) map.get("nome"));
        setVariavel(AdminProjetoActivity.PROJETO_SELECIONADO_NOME, projeto.getNome());
        setVariavel(AdminProjetoActivity.PROJETO_SELECIONADO_ID, projeto.getId());
        startActivity(new Intent(this, AdminProjetoActivity.class));
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
