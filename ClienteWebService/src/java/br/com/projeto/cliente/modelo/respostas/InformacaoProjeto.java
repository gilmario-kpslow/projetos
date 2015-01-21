/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.cliente.modelo.respostas;

import br.com.projeto.cliente.modelo.projeto.Projeto;

/**
 *
 * @author gilmario
 */
public class InformacaoProjeto extends Informacao {

    private Projeto projeto;

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

}
