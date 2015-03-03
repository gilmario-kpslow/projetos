/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetos.android.util.menu;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import br.com.projetos.android.R;
import java.util.List;

/**
 *
 * @author gilmario
 */
public class ItemMenuAdapter extends BaseAdapter {

    private Context context;
    private List<ItemMenu> itens;

    public ItemMenuAdapter(Context context, List<ItemMenu> itens) {
        this.context = context;
        this.itens = itens;
    }

    public int getCount() {
        return itens.size();
    }

    public Object getItem(int i) {
        return itens.get(i);
    }

    public long getItemId(int i) {
        return i;
    }

    public View getView(int i, View view, ViewGroup vg) {
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.menu_row, null);
        }
        TextView nome = (TextView) view.findViewById(R.id.menu_nome);
        TextView desc = (TextView) view.findViewById(R.id.menu_desc);
        nome.setText(itens.get(i).getNome());
        desc.setText(itens.get(i).getDescricao());
        return view;
    }

}
