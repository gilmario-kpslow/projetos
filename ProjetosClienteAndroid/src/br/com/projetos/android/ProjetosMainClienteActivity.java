package br.com.projetos.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ProjetosMainClienteActivity extends Activity {

    /**
     *
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void responsavel(View view) {
        startActivity(new Intent(this, ResponsavelActivity.class));
    }

    public void login(View view) {
        Intent i = new Intent(this, ResponsavelActivity.class);
        i.putExtra(ResponsavelActivity.FORM_LOGIN, true);
        startActivity(i);
    }

    public void preferencias(View view) {
        startActivity(new Intent(this, ConfiguracoesActivity.class));
    }

}
