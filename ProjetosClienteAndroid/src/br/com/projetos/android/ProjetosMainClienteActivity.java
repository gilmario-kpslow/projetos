package br.com.projetos.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ProjetosMainClienteActivity extends Activity {

    /**
     * Called when the activity is first created.
     *
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void registrarResponsavel(View view) {
        startActivity(new Intent(this, ResponsavelActivity.class));
    }

    public void preferencias(View view) {
        startActivity(new Intent(this, ConfiguracoesActivity.class));
    }
}
