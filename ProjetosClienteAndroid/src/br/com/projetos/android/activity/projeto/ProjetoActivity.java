package br.com.projetos.android.activity.projeto;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import br.com.projetos.android.R;
import br.com.projetos.android.ServerActivity;
import br.com.projetos.android.modelos.InformacaoProjeto;
import br.com.projetos.android.modelos.Projeto;
import br.com.projetos.android.modelos.TipoMensagem;
import br.com.projetos.android.service.ProjetoService;
import br.com.projetos.android.util.DialogMensagem;

/**
 *
 * @author gilmario
 */
public class ProjetoActivity extends ServerActivity {

    private ProjetoService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        service = new ProjetoService(getServidor());
        setContentView(R.layout.projeto_novo);
    }

    public void criarProjeto(View view) {
        criar();
    }

    private void criar() {
        new AsyncTask<Void, Void, InformacaoProjeto>() {

            @Override
            protected InformacaoProjeto doInBackground(Void... on) {
                try {
                    Projeto p = new Projeto();
                    p.setNome(((EditText) findViewById(R.id.edtNome)).getText().toString());
                    p.setDescricao(((EditText) findViewById(R.id.edtDescricao)).getText().toString());
                    return service.criarProjeto(p);
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

    private void limpar() {
        ((EditText) findViewById(R.id.edtNome)).setText("");
        ((EditText) findViewById(R.id.edtDescricao)).setText("");
    }

}
