/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetos.android;

import android.app.ListActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import br.com.projetos.android.modelos.InformacaoProjeto;
import br.com.projetos.android.modelos.Projeto;
import br.com.projetos.android.modelos.TipoMensagem;
import br.com.projetos.android.util.DialogMensagem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author gilmario
 */
public class ProjetoListActivity extends ListActivity implements AdapterView.OnItemClickListener {

    public static final String LISTA_DE_PROJETOS = "projetos";
    private List<Projeto> projetos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        projetos = (List<Projeto>) getIntent().getSerializableExtra(LISTA_DE_PROJETOS);

    }

    public void listar(List<Projeto> projetos) {
        List<Map<String, Object>> map = geraMapProjetos(projetos);

        String[] cabecalho = {"id", "nome", "descricao"};
        int[] ids = {R.id.id, R.id.nome, R.id.descricao};
        SimpleAdapter adapter = new SimpleAdapter(this, map, R.layout.projeto_lista, cabecalho, ids);
        adapter.setViewBinder(new ProjetoListActivity.ProjetoViewBinder());
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
        registerForContextMenu(getListView());
    }

    public void onItemClick(AdapterView<?> av, View view, int i, long l) {
        //Map<String, Object> map = projetos.get(i);
        //String descricao = (String) map.get("descricao");
        //String mensagem = "Gasto selecionada: " + descricao;
        Toast.makeText(this, "HI", Toast.LENGTH_SHORT).show();
    }

    private String dataAnterior = "";

    private List<Map<String, Object>> geraMapProjetos(List<Projeto> projetos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private class ProjetoViewBinder implements SimpleAdapter.ViewBinder {

        @Override
        public boolean setViewValue(View view, Object data, String textRepresentation) {

            /**
             * if (view.getId() == R.id.id) { if (!dataAnterior.equals(data)) {
             * TextView textView = (TextView) view;
             * textView.setText(textRepresentation); dataAnterior =
             * textRepresentation; view.setVisibility(View.VISIBLE); } else {
             * view.setVisibility(View.GONE); } return true; }
             *
             * if (view.getId() == R.id.categoria) { Integer id = (Integer)
             * data; view.setBackgroundColor(getResources().getColor(id));
             * return true; }
             *
             */
            return false;
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.projeto_menu, menu);
    }
    /**
     * @Override public boolean onContextItemSelected(MenuItem item) { if
     * (item.getItemId() == R.id.remover_gasto) {
     * AdapterView.AdapterContextMenuInfo info =
     * (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
     * gastos.remove(info.position); getListView().invalidateViews();
     * dataAnterior = ""; return true; }
     *
     * return super.onContextItemSelected(item); } *
     */
}
