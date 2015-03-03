package br.com.projetos.android;

import br.com.projetos.android.activity.projeto.ProjetoConsultaActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import br.com.projetos.android.modelos.InformacaoResponsavel;
import br.com.projetos.android.modelos.Responsavel;
import br.com.projetos.android.modelos.TipoMensagem;
import br.com.projetos.android.service.ResponsavelService;
import br.com.projetos.android.util.DialogMensagem;

public class MainActivity extends ServerActivity {

    public static final String RESPONSAVEL_ID = "responsavel";
    public static final String RESPONSAVEL_NOME = "responsavel_nome";
    public static final String RESPONSAVEL_LOGIN = "responsavel_login";
    /**
     *
     * @param savedInstanceState
     */
    private ResponsavelService service;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        service = new ResponsavelService(getServidor());
    }

    private void responsavel() {
        startActivity(new Intent(this, ResponsavelActivity.class));
    }

    public void login(View view) {
        login();
    }

    @Override
    protected void onResume() {
        super.onResume();
        service = new ResponsavelService(getServidor());
    }

    private void login() {
        new AsyncTask<Void, Void, InformacaoResponsavel>() {

            @Override
            protected InformacaoResponsavel doInBackground(Void... on) {
                try {
                    String login = ((EditText) findViewById(R.id.editLoginNome)).getText().toString();
                    String senha = ((EditText) findViewById(R.id.editLoginSenha)).getText().toString();
                    InformacaoResponsavel informacao = service.loginResponsavel(login, senha);
                    return informacao;
                } catch (Exception e) {
                    Log.e("ERROX", "Erro ao fazer login", e);
                    return new InformacaoResponsavel(TipoMensagem.ERRO, "ERRO", e.toString());
                }
            }

            @Override
            protected void onPostExecute(InformacaoResponsavel informacao) {
                if (informacao.getTipo().equals(TipoMensagem.SUCESSO)) {
                    iniciaAplicacaoPrincipal(informacao.getComplemento());
                } else {
                    new DialogMensagem().mensagemDialogOK(MainActivity.this, informacao.getConteudo(), informacao.getTitulo(), "atenção");
                }
            }

        }.execute();
    }

    private void preferencias() {
        startActivity(new Intent(this, ConfiguracoesActivity.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        if (item.getItemId() == R.id.menu_novo) {
            responsavel();
        } else if (item.getItemId() == R.id.menu_config) {
            preferencias();
        } else if (item.getItemId() == R.id.menu_sair) {
            finish();
        }
        return super.onMenuItemSelected(featureId, item);
    }

    private void iniciaAplicacaoPrincipal(Responsavel responsavel) {
        setVariavel(RESPONSAVEL_ID, responsavel.getId());
        setVariavel(RESPONSAVEL_NOME, responsavel.getNomeCompleto());
        setVariavel(RESPONSAVEL_LOGIN, responsavel.getLogin());
        startActivity(new Intent(this, ProjetoConsultaActivity.class));
    }

}
