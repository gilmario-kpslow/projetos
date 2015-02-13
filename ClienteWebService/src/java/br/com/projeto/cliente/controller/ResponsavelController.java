/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.cliente.controller;

import br.com.projeto.cliente.ResponsavelWebServiceCliente;
import br.com.projeto.cliente.UrlInject;
import br.com.projeto.cliente.interfaces.ResponsavelService;
import br.com.projeto.cliente.modelo.Responsavel;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author gilmario
 */
@Stateless
public class ResponsavelController {

    @EJB
    private UrlInject urlInject;
    private ResponsavelWebServiceCliente responsavelWebServiceCliente;
    private ResponsavelService responsavelService;

    @PostConstruct
    private void init() {
        responsavelWebServiceCliente = new ResponsavelWebServiceCliente(urlInject.getUrlWebServiceResponsavel());
        responsavelService = responsavelWebServiceCliente.getResponsavelServicePort();
    }

    public List<Responsavel> listar(Integer inicio) {
        return responsavelService.listarResponsavel(inicio).getResponsaveis();
    }

}
