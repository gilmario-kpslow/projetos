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
import br.com.projetos.android.lista.RegraNegocioListFragment;
import br.com.projetos.android.modelos.Atividade;
import br.com.projetos.android.modelos.Funcionalidade;
import br.com.projetos.android.modelos.InformacaoConsultaRegraNegocio;
import br.com.projetos.android.modelos.RegraNegocio;
import br.com.projetos.android.modelos.TipoMensagem;
import br.com.projetos.android.service.RegraNegocioService;
import br.com.projetos.android.util.DialogMensagem;
import java.util.ArrayList;
import java.util.Map;

/**
 * Mostrar o andamento do projeto e dar opções diversas como incluir modulos
 * cancelar o projeto, incluir
 *
 * @author gilmario
 */
public class AdminFuncionalidadeActivity extends ServerActivity implements AdapterView.OnItemClickListener {

    public static final String FUNCIONALIDADE_SELECIONADO_NOME = "funcionalidade_selecionado_nome";
    public static final String FUNCIONALIDADE_SELECIONADO_ID = "funcionalidade_selecionado_id";
    private RegraNegocioService regraNegocioService;
    private Funcionalidade funcionalidade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        regraNegocioService = new RegraNegocioService(getServidor());
        setContentView(R.layout.admin_funcionalidade);
        funcionalidade = new Funcionalidade();
        funcionalidade.setId(getVariavelLong(FUNCIONALIDADE_SELECIONADO_ID));
        funcionalidade.setNome(getVariavelString(FUNCIONALIDADE_SELECIONADO_NOME));
        setView();
        listarRegraNegocio();
    }

    private void setView() {
        ((TextView) findViewById(R.id.adm_funcionalidade_nome)).setText(funcionalidade.getNome());
        ((TextView) findViewById(R.id.adm_funcionalidade_id)).setText(funcionalidade.getId().toString());
    }

    public void listarRegraNegocio(View view) {
        listarRegraNegocio();
    }

    private void listarRegraNegocio() {
        new AsyncTask<Void, Void, InformacaoConsultaRegraNegocio>() {

            @Override
            protected InformacaoConsultaRegraNegocio doInBackground(Void... on) {
                try {
                    return regraNegocioService.listarRegraNegocio(funcionalidade);
                } catch (Exception e) {
                    Log.e("ERRO", "Erro ao Listar", e);
                    return new InformacaoConsultaRegraNegocio(TipoMensagem.ERRO, "ERRO", e.toString());
                }
            }

            @Override
            protected void onPostExecute(InformacaoConsultaRegraNegocio informacao) {
                if (TipoMensagem.SUCESSO.equals(informacao.getTipo())) {
                    mostraLista(informacao.getRegraNegocios());
                } else {
                    new DialogMensagem().mensagemDialogOK(AdminFuncionalidadeActivity.this, informacao.getConteudo(), informacao.getTitulo(), "sucesso");
                }
            }
        }.execute();
    }

    private void mostraLista(ArrayList<RegraNegocio> regraNegocios) {
        if (regraNegocios.isEmpty()) {
            new DialogMensagem().mensagemDialogOK(this, "Nenhum resultado encontrado", "Atenção", "");
        } else {
            RegraNegocioListFragment fragment = (RegraNegocioListFragment) getFragmentManager().findFragmentByTag("lista");
            fragment.listar(regraNegocios);
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
            setVariavel(FUNCIONALIDADE_SELECIONADO_ID, funcionalidade.getId());
            setVariavel(FUNCIONALIDADE_SELECIONADO_NOME, funcionalidade.getNome());
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
