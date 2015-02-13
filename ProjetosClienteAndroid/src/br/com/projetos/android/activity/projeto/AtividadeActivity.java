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
import br.com.projetos.android.modelos.InformacaoAtividade;
import br.com.projetos.android.modelos.Modulo;
import br.com.projetos.android.modelos.TipoMensagem;
import br.com.projetos.android.service.AtividadeService;
import br.com.projetos.android.util.DialogMensagem;

/**
 * @author gilmario
 */
public class AtividadeActivity extends ServerActivity {

    private AtividadeService service;
    private Modulo modulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        service = new AtividadeService(getServidor());
        setContentView(R.layout.atividade_novo);
        modulo = new Modulo();
        modulo.setId(getVariavelLong(AdminModuloActivity.MODULO_SELECIONADO_ID));
        modulo.setNome(getVariavelString(AdminModuloActivity.MODULO_SELECIONADO_NOME));
    }

    public void criarAtividade(View view) {
        criar();
    }

    private void criar() {
        new AsyncTask<Void, Void, InformacaoAtividade>() {

            @Override
            protected InformacaoAtividade doInBackground(Void... on) {
                try {
                    Atividade a = new Atividade();
                    a.setModulo(modulo);
                    a.setNome(((EditText) findViewById(R.id.edt_nome_atividade)).getText().toString());
                    a.setDescricao(((EditText) findViewById(R.id.edt_descricao_atividade)).getText().toString());
                    return service.criarAtividade(a);
                } catch (Exception e) {
                    Log.e("ERROX", "Erro ao salvar", e);
                    return new InformacaoAtividade(TipoMensagem.ERRO, "ERRO", e.toString());
                }
            }

            @Override
            protected void onPostExecute(InformacaoAtividade informacao) {
                new DialogMensagem().mensagemDialogOK(AtividadeActivity.this, informacao.getConteudo(), informacao.getTitulo(), "sucesso");
                limpar();
            }
        }.execute();
    }

    private void limpar() {
        ((EditText) findViewById(R.id.edt_nome_atividade)).setText("");
        ((EditText) findViewById(R.id.edt_descricao_atividade)).setText("");
    }

}
