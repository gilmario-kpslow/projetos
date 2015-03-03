/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetos.android;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import br.com.projetos.android.util.DialogMensagem;
import br.com.projetos.android.util.menu.ItemMenu;
import br.com.projetos.android.util.menu.ItemMenuAdapter;
import java.util.ArrayList;

/**
 *
 * @author gilmario
 */
public class TextActivity extends Activity implements ListView.OnItemClickListener {

    private ListView listView;
    private String[] titulos_menu;
    private ArrayList<ItemMenu> itensMenu;
    private ItemMenuAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //To change body of generated methods, choose Tools | Templates.
        setContentView(R.layout.teste_slide);
        titulos_menu = getResources().getStringArray(R.array.opcoes_menu);

    }

    public void onItemClick(AdapterView<?> arg0, View arg1, int i, long id) {
        new DialogMensagem().mensagemSimples(this, Integer.toString(i));
        Fragment fragment = null;
        if (fragment != null) {
            FragmentManager fragmentManager = getFragmentManager();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
                fragmentManager.beginTransaction()
                        .setCustomAnimations(R.anim.fadein, R.anim.fadeout, R.anim.fadein, R.anim.fadeout)
                        .replace(R.id.frame, fragment).commit();
            } else {
                fragmentManager.beginTransaction().replace(R.id.frame, fragment).commit();
            }

            listView.setItemChecked(i, true);
            listView.setSelection(i);
            setTitle(titulos_menu[i]);

        }
    }

}
