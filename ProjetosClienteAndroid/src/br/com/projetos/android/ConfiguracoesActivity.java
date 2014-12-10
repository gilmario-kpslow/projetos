/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetos.android;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import java.util.List;

/**
 *
 * @author gilmario
 */
public class ConfiguracoesActivity extends PreferenceActivity {

    /**
     * Called when the activity is first created.
     *
     * @param icicle
     */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        if (hasHeaders()) {
            Button teste = new Button(this);
            teste.setText("Testar Web Service");
            teste.setOnClickListener(new View.OnClickListener() {

                public void onClick(View arg0) {
                    testaWebService();
                }
            });

            setListFooter(teste);

        }
    }

    @Override
    public void onBuildHeaders(List<Header> target) {
        loadHeadersFromResource(R.xml.preferencias_headers, target);
    }

    @Override
    protected boolean isValidFragment(String fragmentName) {
        return true;
    }

    public static class ServidorPreferencias extends PreferenceFragment {

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            PreferenceManager.setDefaultValues(getActivity(), R.xml.preferencias, false);
            addPreferencesFromResource(R.xml.preferencias);
        }
    }

    public void testaWebService() {

    }

}
