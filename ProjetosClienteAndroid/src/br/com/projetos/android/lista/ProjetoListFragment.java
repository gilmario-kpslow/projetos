/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetos.android.lista;

import br.com.projetos.android.*;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;
import br.com.projetos.android.modelos.Projeto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author gilmario
 */
public class ProjetoListFragment extends ListFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.lista_generica, null);
    }

    public void listar(List<Projeto> projetos) {
        List<Map<String, Object>> map = geraMapProjetos(projetos);
        String[] cabecalho = {"id", "nome", "descricao"};
        int[] ids = {R.id.id, R.id.nome, R.id.descricao};
        SimpleAdapter adapter = new SimpleAdapter(getActivity(), map, R.layout.projeto_row, cabecalho, ids);
        adapter.setViewBinder(new ProjetoListFragment.ProjetoViewBinder());
        setListAdapter(adapter);
        getListView().setOnItemClickListener((AdapterView.OnItemClickListener) getActivity());
    }

    private List<Map<String, Object>> geraMapProjetos(List<Projeto> projetos) {
        List<Map<String, Object>> listaAdaptada = new ArrayList<Map<String, Object>>();
        for (Projeto p : projetos) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("id", p.getId());
            item.put("nome", p.getNome());
            item.put("descricao", p.getDescricao());
            listaAdaptada.add(item);
        }
        return listaAdaptada;
    }

    private class ProjetoViewBinder implements SimpleAdapter.ViewBinder {

        @Override
        public boolean setViewValue(View view, Object data, String textRepresentation) {

            return false;
        }
    }

}