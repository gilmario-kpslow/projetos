/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetos.android;

import android.content.Intent;
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

    public static final String FORM_LOGIN = "login";
    private ResponsavelService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        service = new ResponsavelService(getServidor());
        if (getIntent().getBooleanExtra(FORM_LOGIN, false)) {
            setContentView(R.layout.login);
        } else {
            setContentView(R.layout.responsavel_cadastro);
        }
    }

    public void cadastrar(View view) {
        cadastrar();
    }

    public void login(View view) {
        login();
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
                    new DialogMensagem().mensagemDialogOK(ResponsavelActivity.this, informacao.getConteudo(), informacao.getTitulo(), "atenção");
                }
            }

        }.execute();
    }

    private void iniciaAplicacaoPrincipal(Responsavel responsavel) {
        Intent i = new Intent(this, ProjetoActivity.class);
        i.putExtra(ProjetoActivity.RESPONSAVEL, responsavel);
        startActivity(i);
    }

}
