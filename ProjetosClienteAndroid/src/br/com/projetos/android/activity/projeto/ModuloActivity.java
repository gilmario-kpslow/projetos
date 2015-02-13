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
import br.com.projetos.android.modelos.InformacaoModulo;
import br.com.projetos.android.modelos.Modulo;
import br.com.projetos.android.modelos.Projeto;
import br.com.projetos.android.modelos.TipoMensagem;
import br.com.projetos.android.service.ModuloService;
import br.com.projetos.android.util.DialogMensagem;

/**
 * @author gilmario
 */
public class ModuloActivity extends ServerActivity {

    private ModuloService service;
    private Projeto projeto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        service = new ModuloService(getServidor());
        setContentView(R.layout.modulo_novo);
        projeto = new Projeto();
        projeto.setId(getVariavelLong(AdminProjetoActivity.PROJETO_SELECIONADO_ID));
        projeto.setNome(getVariavelString(AdminProjetoActivity.PROJETO_SELECIONADO_NOME));
    }

    public void criarModulo(View view) {
        criar();
    }

    private void criar() {
        new AsyncTask<Void, Void, InformacaoModulo>() {

            @Override
            protected InformacaoModulo doInBackground(Void... on) {
                try {
                    Modulo m = new Modulo();
                    m.setProjeto(projeto);
                    m.setNome(((EditText) findViewById(R.id.edt_nome_modulo)).getText().toString());
                    m.setDescricao(((EditText) findViewById(R.id.edt_descricao_modulo)).getText().toString());
                    return service.criarModulo(m);
                } catch (Exception e) {
                    Log.e("ERROX", "Erro ao salvar", e);
                    return new InformacaoModulo(TipoMensagem.ERRO, "ERRO", e.toString());
                }
            }

            @Override
            protected void onPostExecute(InformacaoModulo informacao) {
                new DialogMensagem().mensagemDialogOK(ModuloActivity.this, informacao.getConteudo(), informacao.getTitulo(), "sucesso");
                limpar();
            }
        }.execute();
    }

    private void limpar() {
        ((EditText) findViewById(R.id.edt_nome_modulo)).setText("");
        ((EditText) findViewById(R.id.edt_descricao_modulo)).setText("");
    }

}
