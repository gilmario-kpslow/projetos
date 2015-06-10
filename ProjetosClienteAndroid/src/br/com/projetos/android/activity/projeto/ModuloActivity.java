/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetos.android.activity.projeto;

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
import br.com.projetos.android.service.ExecutaService;
import br.com.projetos.android.service.ModuloService;
import br.com.projetos.android.util.DialogMensagem;

/**
 * @author gilmario
 */
public class ModuloActivity extends ServerActivity {

    public static final String MODULO_ID = "modulo";
    private ModuloService service;
    private Modulo modulo;
    private Projeto projeto;
    private EditText edtNome;
    private EditText edtDescricao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        service = new ModuloService(getServidor());
        setContentView(R.layout.modulo_novo);
        projeto = new Projeto();
        projeto.setId(getVariavelLong(AdminProjetoActivity.PROJETO_SELECIONADO_ID));
        projeto.setNome(getVariavelString(AdminProjetoActivity.PROJETO_SELECIONADO_NOME));
        edtNome = (EditText) findViewById(R.id.edt_nome_modulo);
        edtDescricao = (EditText) findViewById(R.id.edt_descricao_modulo);
        if (getIntent().getExtras() != null && getIntent().getExtras().containsKey(MODULO_ID)) {
            modulo = (Modulo) getIntent().getSerializableExtra(MODULO_ID);
            edtNome.setText(modulo.getNome());
            edtDescricao.setText(modulo.getDescricao());
        }

    }

    public void criarModulo(View view) {
        if (modulo == null) {
            criar();
        } else {
            editar();
        }
    }

    private void criar() {
        new ExecutaService<InformacaoModulo>(this) {

            @Override
            protected InformacaoModulo doInBackground(Void... on) {
                try {
                    modulo = new Modulo();
                    modulo.setProjeto(projeto);
                    modulo.setNome(edtNome.getText().toString());
                    modulo.setDescricao(edtDescricao.getText().toString());
                    return service.criarModulo(modulo);
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

    private void editar() {
        new ExecutaService<InformacaoModulo>(this) {

            @Override
            protected InformacaoModulo doInBackground(Void... on) {
                try {
                    modulo.setProjeto(projeto);
                    modulo.setNome(edtNome.getText().toString());
                    modulo.setDescricao(edtDescricao.getText().toString());
                    return service.editaModulo(modulo);
                } catch (Exception e) {
                    Log.e("ERROX", "Erro ao editar", e);
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
        edtNome.setText("");
        edtDescricao.setText("");
        modulo = null;
    }

}
