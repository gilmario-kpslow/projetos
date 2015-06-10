package br.com.projetos.android;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import br.com.projetos.android.modelos.InformacaoResponsavel;
import br.com.projetos.android.modelos.Responsavel;
import br.com.projetos.android.modelos.TipoMensagem;
import br.com.projetos.android.service.ResponsavelService;
import br.com.projetos.android.util.DialogMensagem;

/**
 *
 * @author gilmario
 */
public class ResponsavelActivity extends ServerActivity {

    private ResponsavelService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        service = new ResponsavelService(getServidor());
        setContentView(R.layout.responsavel_cadastro);
    }

    public void cadastrar(View view) {
        cadastrar();
    }

    private void cadastrar() {
        new AsyncTask<Void, Void, InformacaoResponsavel>() {

            @Override
            protected InformacaoResponsavel doInBackground(Void... on) {
                return cadastrarResponsavel();
            }

            @Override
            protected void onPostExecute(InformacaoResponsavel informacao) {
                new DialogMensagem().mensagemDialogOK(ResponsavelActivity.this, informacao.getConteudo(), informacao.getTitulo(), "sucesso");
                if (informacao.getTipo().equals(TipoMensagem.SUCESSO)) {
                    setContentView(R.layout.login);
                }
            }
        }.execute();
    }

    private InformacaoResponsavel cadastrarResponsavel() {
        try {
            Responsavel responsavel = new Responsavel();
            responsavel.setAtivo(Boolean.TRUE);
            responsavel.setLogin(((EditText) findViewById(R.id.editLogin)).getText().toString());
            responsavel.setNomeCompleto(((EditText) findViewById(R.id.editNome)).getText().toString());
            responsavel.setSenha(((EditText) findViewById(R.id.editSenha)).getText().toString());
            InformacaoResponsavel informacao = service.registrarResponsavel(responsavel);
            return informacao;
        } catch (Exception e) {
            Log.e("ERROX", "Erro ao salvar", e);
            return new InformacaoResponsavel(TipoMensagem.ERRO, "ERRO", e.toString());
        }
    }

}
