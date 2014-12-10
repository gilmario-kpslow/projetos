/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetos.android;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import br.com.projeto.modelo.Responsavel;
import br.com.projetos.android.service.ResponsavelService;

/**
 *
 * @author gilmario
 */
public class ResponsavelActivity extends ServerActivity {

    private ResponsavelService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        service = new ResponsavelService();
        setContentView(R.layout.responsavel_cadastro);
    }

    public void salvar(View view) {
        Responsavel responsavel = new Responsavel();
        responsavel.setAtivo(Boolean.TRUE);
        responsavel.setLogin("gilmario");
        responsavel.setNomeCompleto("Jose Gilmario");
        responsavel.setSenha("1213456");
        Toast.makeText(this, service.registrar(responsavel).getConteudo(), Toast.LENGTH_SHORT).show();
    }

}
