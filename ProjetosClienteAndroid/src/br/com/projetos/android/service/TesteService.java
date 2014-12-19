/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetos.android.service;

import br.com.projetos.android.modelos.InformacaoResponsavel;

/**
 *
 * @author gilmario
 */
public class TesteService extends Service {

    public TesteService(String servidor) {
        super(servidor + "/projetos/teste?wsdl");
    }

    public InformacaoResponsavel testar() throws Exception {
        return (InformacaoResponsavel) executaRequisicao("status", "projetos", InformacaoResponsavel.class);
    }

}
