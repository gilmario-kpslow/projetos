/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.cliente.modelo.respostas;

import br.com.projeto.cliente.modelo.projeto.RegraNegocio;

/**
 *
 * @author gilmario
 */
public class InformacaoRegraNegocio extends Informacao {

    private RegraNegocio regraNegocio;

    public RegraNegocio getRegraNegocio() {
        return regraNegocio;
    }

    public void setRegraNegocio(RegraNegocio regraNegocio) {
        this.regraNegocio = regraNegocio;
    }

}
