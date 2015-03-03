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
import br.com.projetos.android.lista.FuncionalidadeListFragment;
import br.com.projetos.android.modelos.Atividade;
import br.com.projetos.android.modelos.Funcionalidade;
import br.com.projetos.android.modelos.InformacaoConsultaFuncionalidade;
import br.com.projetos.android.modelos.Projeto;
import br.com.projetos.android.modelos.TipoMensagem;
import br.com.projetos.android.service.FuncionalidadeService;
import br.com.projetos.android.util.DialogMensagem;
import java.util.ArrayList;
import java.util.Map;

/**
 * Mostrar o andamento do projeto e dar opções diversas como incluir modulos
 * cancelar o projeto, incluir
 *
 * @author gilmario
 */
public class AdminAtividadeActivity extends ServerActivity implements AdapterView.OnItemClickListener {

    public static final String ATIVIDADE_SELECIONADO_NOME = "atividade_selecionado_nome";
    public static final String ATIVIDADE_SELECIONADO_ID = "atividade_selecionado_id";
    private FuncionalidadeService funcionalidadeService;
    private Atividade atividade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        funcionalidadeService = new FuncionalidadeService(getServidor());
        setContentView(R.layout.admin_atividade);
        atividade = new Atividade();
        atividade.setId(getVariavelLong(ATIVIDADE_SELECIONADO_ID));
        atividade.setNome(getVariavelString(ATIVIDADE_SELECIONADO_NOME));
        setView();
        listarFuncionalidades();
    }

    private void setView() {
        ((TextView) findViewById(R.id.atividade_funcionalidade_nome)).setText(atividade.getNome());
        ((TextView) findViewById(R.id.atividade_funcionalidade_id)).setText(atividade.getId().toString());
    }

    public void listarFuncionalidades(View view) {
        listarFuncionalidades();
    }

    private void listarFuncionalidades() {
        new AsyncTask<Void, Void, InformacaoConsultaFuncionalidade>() {

            @Override
            protected InformacaoConsultaFuncionalidade doInBackground(Void... on) {
                try {
                    Projeto p = new Projeto();
                    p.setId(1L);
                    return funcionalidadeService.listarFuncionalidade(atividade);
                } catch (Exception e) {
                    Log.e("ERRO", "Erro ao Listar", e);
                    return new InformacaoConsultaFuncionalidade(TipoMensagem.ERRO, "ERRO", e.toString());
                }
            }

            @Override
            protected void onPostExecute(InformacaoConsultaFuncionalidade informacao) {
                if (TipoMensagem.SUCESSO.equals(informacao.getTipo())) {
                    mostraLista(informacao.getFuncionalidades());
                } else {
                    new DialogMensagem().mensagemDialogOK(AdminAtividadeActivity.this, informacao.getConteudo(), informacao.getTitulo(), "sucesso");
                }
            }
        }.execute();
    }

    private void mostraLista(ArrayList<Funcionalidade> funcionalidades) {
        if (funcionalidades.isEmpty()) {
            new DialogMensagem().mensagemDialogOK(this, "Nenhum resultado encontrado", "Atenção", "");
        } else {
            FuncionalidadeListFragment fragment = (FuncionalidadeListFragment) getFragmentManager().findFragmentByTag("lista");
            fragment.listar(funcionalidades);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.atividade_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        if (item.getItemId() == R.id.menu_nova_funcionalidade) {
            setVariavel(ATIVIDADE_SELECIONADO_ID, atividade.getId());
            setVariavel(ATIVIDADE_SELECIONADO_NOME, atividade.getNome());
            startActivity(new Intent(this, FuncionalidadeActivity.class));
        } else if (item.getItemId() == R.id.menu_atividade_voltar) {
            finish();
        }
        return super.onMenuItemSelected(featureId, item);
    }

    public void onItemClick(AdapterView<?> adapter, View view, int op, long pos) {
        Map<String, Object> map = (Map<String, Object>) adapter.getAdapter().getItem(op);

        new DialogMensagem().optionDialog(this, new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int opcao) {
                switch (opcao) {
                    case 0:
                        // Abrir a view tarefa
                        selecionarAtividade(null);
                        break;
                    case 1:
                        // Editar tarefa
                        break;
                    case 2:
                        // Ecluir tarefa
                        break;
                }
            }

        }, getResources().getStringArray(R.array.opcoes_dialog), "Selecionar uma opção?");
    }

    private void selecionarAtividade(Atividade a) {

    }

}
