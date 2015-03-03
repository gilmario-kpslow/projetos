/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetos.android.activity.projeto;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import br.com.projetos.android.R;
import br.com.projetos.android.ServerActivity;
import br.com.projetos.android.modelos.Funcionalidade;
import br.com.projetos.android.modelos.InformacaoFuncionalidade;
import br.com.projetos.android.modelos.InformacaoRegraNegocio;
import br.com.projetos.android.modelos.RegraNegocio;
import br.com.projetos.android.modelos.TipoMensagem;
import br.com.projetos.android.service.RegraNegocioService;
import br.com.projetos.android.util.DialogMensagem;

/**
 * @author gilmario
 */
public class RegraNegocioActivity extends ServerActivity {

    private RegraNegocioService service;
    private Funcionalidade funcionalidade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        service = new RegraNegocioService(getServidor());
        setContentView(R.layout.regra_negocio_novo);
        funcionalidade = new Funcionalidade();
        funcionalidade.setId(getVariavelLong(AdminFuncionalidadeActivity.FUNCIONALIDADE_SELECIONADO_ID));
        funcionalidade.setNome(getVariavelString(AdminFuncionalidadeActivity.FUNCIONALIDADE_SELECIONADO_NOME));
    }

    public void criarFuncionalidade(View view) {
        criar();
    }

    private void criar() {
        new AsyncTask<Void, Void, InformacaoRegraNegocio>() {

            @Override
            protected InformacaoRegraNegocio doInBackground(Void... on) {
                try {
                    RegraNegocio a = new RegraNegocio();
                    a.setFuncionalidade(funcionalidade);
                    a.setCodigo(((EditText) findViewById(R.id.edt_codigo_regra_negocio)).getText().toString());
                    a.setNome(((EditText) findViewById(R.id.edt_nome_regra_negocio)).getText().toString());
                    a.setDescricao(((EditText) findViewById(R.id.edt_descricao_regra_negocio)).getText().toString());
                    return service.criarRegraNegocio(a);
                } catch (Exception e) {
                    Log.e("ERROX", "Erro ao salvar", e);
                    return new InformacaoRegraNegocio(TipoMensagem.ERRO, "ERRO", e.toString());
                }
            }

            @Override
            protected void onPostExecute(InformacaoRegraNegocio informacao) {
                new DialogMensagem().mensagemDialogOK(RegraNegocioActivity.this, informacao.getConteudo(), informacao.getTitulo(), "sucesso");
                limpar();
            }
        }.execute();
    }

    private void limpar() {
        ((EditText) findViewById(R.id.edt_codigo_regra_negocio)).setText("");
        ((EditText) findViewById(R.id.edt_nome_regra_negocio)).setText("");
        ((EditText) findViewById(R.id.edt_descricao_regra_negocio)).setText("");
    }

}
