/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.cliente.modelo.respostas;

import br.com.projeto.cliente.modelo.Responsavel;

/**
 *
 * @author gilmario
 */
public class InformacaoResponsavel extends Informacao {

    private Responsavel responsavel;

    public Responsavel getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    }

}
