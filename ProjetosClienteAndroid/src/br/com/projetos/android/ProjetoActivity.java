/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetos.android;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import br.com.projetos.android.modelos.Responsavel;

/**
 *
 * @author gilmario
 */
public class ProjetoActivity extends ServerActivity {

    public static final String RESPONSAVEL = "reponsavel";
    private Responsavel reponsavel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.reponsavel = (Responsavel) getIntent().getSerializableExtra(RESPONSAVEL);
        this.setContentView(R.layout.projeto_main);
        TextView text = (TextView) findViewById(R.id.usuario_nome);
        text.setText(reponsavel.getNomeCompleto());
    }

    public void novo(View view) {
        setContentView(R.layout.projeto_novo);
    }

    public void consultar(View view) {
        setContentView(R.layout.projeto_lista);
    }

}
