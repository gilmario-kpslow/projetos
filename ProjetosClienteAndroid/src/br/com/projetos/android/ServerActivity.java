/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetos.android;

import android.app.Activity;
import static android.content.Context.MODE_PRIVATE;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import java.util.Map;

/**
 *
 * @author gilmario
 */
public class ServerActivity extends Activity {

    private String SERVIDOR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SERVIDOR = preferences.getString("servidor", "");
        super.onCreate(savedInstanceState);
    }

    public String getServidor() {
        return SERVIDOR;
    }

}
