/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetos.android.activity.projeto;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import br.com.projetos.android.ServerActivity;
import br.com.projetos.android.R;
import br.com.projetos.android.lista.AtividadeListFragment;
import br.com.projetos.android.modelos.Atividade;
import br.com.projetos.android.modelos.InformacaoConsultaAtividade;
import br.com.projetos.android.modelos.Modulo;
import br.com.projetos.android.modelos.TipoMensagem;
import br.com.projetos.android.service.AtividadeService;
import br.com.projetos.android.util.DialogMensagem;
import java.util.ArrayList;
import java.util.Map;

/**
 * Mostrar o andamento do projeto e dar opções diversas como incluir modulos
 * cancelar o projeto, incluir
 *
 * @author gilmario
 */
public class AdminModuloActivity extends ServerActivity implements AdapterView.OnItemClickListener {

    public static final String MODULO_SELECIONADO_NOME = "modulo_selecionado_nome";
    public static final String MODULO_SELECIONADO_ID = "modulo_selecionado_id";
    private AtividadeService atividadeService;
    private Modulo modulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        atividadeService = new AtividadeService(getServidor());
        setContentView(R.layout.admin_modulo);
        modulo = new Modulo();
        modulo.setId(getVariavelLong(MODULO_SELECIONADO_ID));
        modulo.setNome(getVariavelString(MODULO_SELECIONADO_NOME));
        setView();
        listarAtividades();
    }

    private void setView() {
        ((TextView) findViewById(R.id.modulo_atividade_nome)).setText(modulo.getNome());
        ((TextView) findViewById(R.id.modulo_atividade_id)).setText(modulo.getId().toString());
    }

    public void listarAtividades(View view) {
        listarAtividades();
    }

    private void listarAtividades() {
        new AsyncTask<Void, Void, InformacaoConsultaAtividade>() {

            @Override
            protected InformacaoConsultaAtividade doInBackground(Void... on) {
                try {
                    return atividadeService.listarAtividade(modulo);
                } catch (Exception e) {
                    Log.e("ERRO", "Erro ao Listar", e);
                    return new InformacaoConsultaAtividade(TipoMensagem.ERRO, "ERRO", e.toString());
                }
            }

            @Override
            protected void onPostExecute(InformacaoConsultaAtividade informacao) {
                if (TipoMensagem.SUCESSO.equals(informacao.getTipo())) {
                    mostraLista(informacao.getAtividades());
                } else {
                    new DialogMensagem().mensagemDialogOK(AdminModuloActivity.this, informacao.getConteudo(), informacao.getTitulo(), "sucesso");
                }
            }
        }.execute();
    }

    private void mostraLista(ArrayList<Atividade> atividades) {
        if (atividades.isEmpty()) {
            new DialogMensagem().mensagemDialogOK(this, "Nenhum resultado encontrado", "Atenção", "");
        } else {
            AtividadeListFragment fragment = (AtividadeListFragment) getFragmentManager().findFragmentByTag("lista");
            fragment.listar(atividades);
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
            setVariavel(MODULO_SELECIONADO_ID, modulo.getId());
            setVariavel(MODULO_SELECIONADO_NOME, modulo.getNome());
            startActivity(new Intent(this, AtividadeActivity.class));
        }
        return super.onMenuItemSelected(featureId, item);
    }

    public void onItemClick(AdapterView<?> adapter, View view, int op, long pos) {
        Map<String, Object> map = (Map<String, Object>) adapter.getAdapter().getItem(op);
        final Atividade a = new Atividade();
        a.setId((Long) map.get("id"));
        a.setNome((String) map.get("nome"));
        new DialogMensagem().optionDialog(this, new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int opcao) {
                switch (opcao) {
                    case 0:
                        // Abrir a view tarefa
                        selecionarAtividade(a);
                        break;
                    case 1:
                        // Editar tarefa
                        //editarAtividade(a);
                        break;
                    case 2:
                        // Ecluir tarefa
                        //excluirAtividade(a);
                        break;
                }
            }

        }, getResources().getStringArray(R.array.opcoes_dialog), "Selecionar uma opção?");
    }

    private void selecionarAtividade(Atividade a) {
        Intent i = new Intent(this, AdminAtividadeActivity.class);
        setVariavel(AdminAtividadeActivity.ATIVIDADE_SELECIONADO_ID, a.getId());
        setVariavel(AdminAtividadeActivity.ATIVIDADE_SELECIONADO_NOME, a.getNome());
        startActivity(i);
    }

}
