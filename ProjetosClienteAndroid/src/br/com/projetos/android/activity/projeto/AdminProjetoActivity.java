/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetos.android.activity.projeto;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import br.com.projetos.android.R;
import br.com.projetos.android.ServerActivity;
import br.com.projetos.android.modelos.InformacaoConsultaAtividade;
import br.com.projetos.android.modelos.InformacaoConsultaModulo;
import br.com.projetos.android.modelos.Projeto;
import br.com.projetos.android.modelos.TipoMensagem;
import br.com.projetos.android.service.AtividadeService;
import br.com.projetos.android.service.ExecutaService;
import br.com.projetos.android.service.ModuloService;
import br.com.projetos.android.util.DialogMensagem;

/**
 * Mostrar o andamento do projeto e dar opções diversas como incluir modulos
 * cancelar o projeto, incluir
 *
 * @author gilmario
 */
public class AdminProjetoActivity extends ServerActivity {

    public static final String PROJETO_SELECIONADO_NOME = "projeto_selecionado_nome";
    public static final String PROJETO_SELECIONADO_ID = "projeto_selecionado_id";
    private ModuloService moduloService;
    private AtividadeService atividadeService;
    private Projeto projeto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        moduloService = new ModuloService(getServidor());
        atividadeService = new AtividadeService(getServidor());
        setContentView(R.layout.admin_projeto);
        projeto = new Projeto();
        projeto.setId(getVariavelLong(PROJETO_SELECIONADO_ID));
        projeto.setNome(getVariavelString(PROJETO_SELECIONADO_NOME));
        setView();

    }

    private void setView() {
        try {
            ((TextView) findViewById(R.id.projeto_modulo_nome)).setText(projeto.getNome());
            ((TextView) findViewById(R.id.projeto_modulo_id)).setText(projeto.getId().toString());
            new ExecutaService<InformacaoConsultaModulo>(this) {

                protected InformacaoConsultaModulo doInBackground(Void... on) {
                    try {
                        return moduloService.listarModulo(projeto);
                    } catch (Exception e) {
                        Log.e("ERROX", "Erro ao Listar", e);
                        return new InformacaoConsultaModulo(TipoMensagem.ERRO, "ERRO", e.toString());
                    }
                }

                @Override
                protected void onPostExecute(InformacaoConsultaModulo informacao) {
                    if (TipoMensagem.SUCESSO.equals(informacao.getTipo())) {
                        ((TextView) findViewById(R.id.admin_projetos_modulos)).setText(getResources().getString(R.string.admin_projetos_modulos) + " - " + informacao.getModulos().size());
                    } else {
                        new DialogMensagem().mensagemDialogOK(AdminProjetoActivity.this, informacao.getConteudo(), informacao.getTitulo(), "sucesso");
                        ((TextView) findViewById(R.id.admin_projetos_modulos)).setText(getResources().getString(R.string.admin_projetos_modulos) + " - 0");
                    }
                }
            }.execute();
        } catch (Exception e) {
            new DialogMensagem().mensagemSimples(this, e.getMessage());
        }
        try {
            new ExecutaService<InformacaoConsultaAtividade>(this) {

                protected InformacaoConsultaAtividade doInBackground(Void... on) {
                    try {
                        return atividadeService.listarAtividade(projeto);
                    } catch (Exception e) {
                        Log.e("ERROX", "Erro ao Listar", e);
                        return new InformacaoConsultaAtividade(TipoMensagem.ERRO, "ERRO", e.toString());
                    }
                }

                @Override
                protected void onPostExecute(InformacaoConsultaAtividade informacao) {
                    if (TipoMensagem.SUCESSO.equals(informacao.getTipo())) {
                        ((TextView) findViewById(R.id.admin_projetos_atividades)).setText(getResources().getString(R.string.admin_projetos_atividades) + " - " + informacao.getAtividades().size());
                    } else {
                        new DialogMensagem().mensagemDialogOK(AdminProjetoActivity.this, informacao.getConteudo(), informacao.getTitulo(), "sucesso");
                        ((TextView) findViewById(R.id.admin_projetos_atividades)).setText(getResources().getString(R.string.admin_projetos_atividades) + " - 0");
                    }
                }
            }.execute();
        } catch (Exception e) {
            new DialogMensagem().mensagemSimples(this, e.getMessage());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.projeto_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        if (item.getItemId() == R.id.menu_novo_projeto) {
            startActivity(new Intent(this, ModuloActivity.class));
        }
        return super.onMenuItemSelected(featureId, item);
    }

    public void iniciaListaModulos(View view) {
        startActivity(new Intent(this, ModuloConsultaActivity.class));
    }

}
