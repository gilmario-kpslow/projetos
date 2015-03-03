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
import br.com.projetos.android.modelos.Atividade;
import br.com.projetos.android.modelos.Funcionalidade;
import br.com.projetos.android.modelos.InformacaoFuncionalidade;
import br.com.projetos.android.modelos.TipoMensagem;
import br.com.projetos.android.service.FuncionalidadeService;
import br.com.projetos.android.util.DialogMensagem;

/**
 * @author gilmario
 */
public class FuncionalidadeActivity extends ServerActivity {

    private FuncionalidadeService service;
    private Atividade atividade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        service = new FuncionalidadeService(getServidor());
        setContentView(R.layout.funcionalidade_novo);
        atividade = new Atividade();
        atividade.setId(getVariavelLong(AdminAtividadeActivity.ATIVIDADE_SELECIONADO_ID));
        atividade.setNome(getVariavelString(AdminAtividadeActivity.ATIVIDADE_SELECIONADO_NOME));
    }

    public void criarFuncionalidade(View view) {
        criar();
    }

    private void criar() {
        new AsyncTask<Void, Void, InformacaoFuncionalidade>() {

            @Override
            protected InformacaoFuncionalidade doInBackground(Void... on) {
                try {
                    Funcionalidade a = new Funcionalidade();
                    a.setAtividade(atividade);
                    a.setNome(((EditText) findViewById(R.id.edt_nome_funcionalidade)).getText().toString());
                    a.setDescricao(((EditText) findViewById(R.id.edt_descricao_funcionalidade)).getText().toString());
                    return service.criarFuncionalidade(a);
                } catch (Exception e) {
                    Log.e("ERROX", "Erro ao salvar", e);
                    return new InformacaoFuncionalidade(TipoMensagem.ERRO, "ERRO", e.toString());
                }
            }

            @Override
            protected void onPostExecute(InformacaoFuncionalidade informacao) {
                new DialogMensagem().mensagemDialogOK(FuncionalidadeActivity.this, informacao.getConteudo(), informacao.getTitulo(), "sucesso");
                limpar();
            }
        }.execute();
    }

    private void limpar() {
        ((EditText) findViewById(R.id.edt_nome_funcionalidade)).setText("");
        ((EditText) findViewById(R.id.edt_descricao_funcionalidade)).setText("");
    }

}
