package br.com.projetos.android.activity.projeto;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import br.com.projetos.android.R;
import br.com.projetos.android.ServerActivity;
import br.com.projetos.android.modelos.Informacao;
import br.com.projetos.android.modelos.InformacaoProjeto;
import br.com.projetos.android.modelos.Projeto;
import br.com.projetos.android.modelos.TipoMensagem;
import br.com.projetos.android.service.ExecutaService;
import br.com.projetos.android.service.ProjetoService;
import br.com.projetos.android.util.DialogMensagem;

/**
 *
 * @author gilmario
 */
public class ProjetoActivity extends ServerActivity {

    public static final String PROJETO_ID = "ERRO";
    private ProjetoService service;
    private Projeto projeto;
    private EditText edtNome;
    private EditText edtDescricao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        service = new ProjetoService(getServidor());
        setContentView(R.layout.projeto_novo);
        edtNome = (EditText) findViewById(R.id.edtNome);
        edtDescricao = (EditText) findViewById(R.id.edtDescricao);
        if (getIntent().getExtras() != null && getIntent().getExtras().containsKey(PROJETO_ID)) {
            projeto = (Projeto) getIntent().getSerializableExtra(PROJETO_ID);
            edtNome.setText(projeto.getNome());
            edtDescricao.setText(projeto.getDescricao());
        }
    }

    public void criarProjeto(View view) {
        if (projeto == null) {
            criar();
        } else {
            editar();
        }
    }

    private void criar() {
        new AsyncTask<Void, Void, InformacaoProjeto>() {

            @Override
            protected InformacaoProjeto doInBackground(Void... on) {
                try {
                    projeto = new Projeto();
                    projeto.setNome(((EditText) findViewById(R.id.edtNome)).getText().toString());
                    projeto.setDescricao(((EditText) findViewById(R.id.edtDescricao)).getText().toString());
                    return service.criarProjeto(projeto);
                } catch (Exception e) {
                    Log.e("ERROX", "Erro ao salvar", e);
                    return new InformacaoProjeto(TipoMensagem.ERRO, "ERRO", e.toString());
                }
            }

            @Override
            protected void onPostExecute(InformacaoProjeto informacao) {
                new DialogMensagem().mensagemDialogOK(ProjetoActivity.this, informacao.getConteudo(), informacao.getTitulo(), "sucesso");
                limpar();
            }
        }.execute();
    }

    private void editar() {
        new ExecutaService<InformacaoProjeto>(this) {

            @Override
            protected InformacaoProjeto doInBackground(Void... on) {
                try {
                    projeto.setNome(edtNome.getText().toString());
                    projeto.setDescricao(edtDescricao.getText().toString());
                    return service.editarProjeto(projeto);
                } catch (Exception e) {
                    Log.e("ERROX", "Erro ao editar", e);
                    return new InformacaoProjeto(TipoMensagem.ERRO, "ERRO", e.toString());
                }
            }

            @Override
            protected void onPostExecute(InformacaoProjeto informacao) {
                new DialogMensagem().mensagemDialogOK(ProjetoActivity.this, informacao.getConteudo(), informacao.getTitulo(), "sucesso");
                limpar();
            }
        }.execute();
    }

    private void limpar() {
        edtNome.setText("");
        edtDescricao.setText("");
        projeto = null;
    }

}
