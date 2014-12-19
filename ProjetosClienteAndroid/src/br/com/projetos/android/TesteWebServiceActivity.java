/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetos.android;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import br.com.projetos.android.modelos.InformacaoResponsavel;
import br.com.projetos.android.modelos.TipoMensagem;
import br.com.projetos.android.service.TesteService;
import br.com.projetos.android.util.DialogMensagem;

/**
 *
 * @author gilmario
 */
public class TesteWebServiceActivity extends ServerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teste);
    }

    public void testar2(View view) {
        new AsyncTask<Void, Void, String>() {

            @Override
            protected String doInBackground(Void... on) {

                InformacaoResponsavel resp = new InformacaoResponsavel("Erro ", "Aguardando o serviço");
                try {
                    TesteService service = new TesteService(getServidor());
                    resp = service.testar();
                } catch (Exception e) {
                    e.toString();
                    Log.e("ERRO", "erro", e);
                    resp.setTipo(TipoMensagem.ERRO);
                    resp.setConteudo(e.getMessage() + e.getLocalizedMessage() + e.toString());
                    resp.setTitulo("ERRO");
                }
                return resp.getConteudo();
            }

            @Override
            protected void onPostExecute(String result) {
                new DialogMensagem().mensagemDialogOK(TesteWebServiceActivity.this, result, null);
            }
        }.execute();
    }

}
