/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetos.android;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

/**
 *
 * @author gilmario
 */
public class ServerActivity extends Activity {

    private String SERVIDOR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public String getServidor() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SERVIDOR = preferences.getString("servidor", "");
        return SERVIDOR;
    }

    public Long getVariavelLong(String chave) {
        SharedPreferences settings = getSharedPreferences(chave, 0);
        return settings.getLong(chave, 0L);
    }

    public String getVariavelString(String chave) {
        SharedPreferences settings = getSharedPreferences(chave, 0);
        return settings.getString(chave, "");
    }

    public void setVariavel(String chave, Long valor) {
        SharedPreferences settings = getSharedPreferences(chave, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putLong(chave, valor);
        editor.commit();
    }

    public void setVariavel(String chave, String valor) {
        SharedPreferences settings = getSharedPreferences(chave, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(chave, valor);
        editor.commit();
    }

}
