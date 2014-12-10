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

/**
 *
 * @author gilmario
 */
public class ServerActivity extends Activity {

    private String SERVIDOR;
    private String PORTA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        SERVIDOR = preferences.getString("servidor", "localhost");
        PORTA = preferences.getString("porta", "8080");
    }

    public String getSERVIDOR() {
        return SERVIDOR;
    }

    public String getPORTA() {
        return PORTA;
    }

}
