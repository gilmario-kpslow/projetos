/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.cliente.controller;

import br.com.projeto.cliente.AtividadeWebServiceCliente;
import br.com.projeto.cliente.RegraNegocioWebServiceCliente;
import br.com.projeto.cliente.UrlInject;
import br.com.projeto.cliente.interfaces.AtividadeService;
import br.com.projeto.cliente.interfaces.RegraNegocioService;
import br.com.projeto.cliente.modelo.projeto.Atividade;
import br.com.projeto.cliente.modelo.projeto.Projeto;
import br.com.projeto.cliente.modelo.projeto.RegraNegocio;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author gilmario
 */
@Stateless
public class RegraNegocioController implements Serializable {

    @EJB
    private UrlInject urlInject;
    private RegraNegocioService regraNegocioService;

    @PostConstruct
    private void init() {
        regraNegocioService = new RegraNegocioWebServiceCliente(urlInject.getUrlWebServiceRegraNegocio()).getServicePort();
    }

    public List<RegraNegocio> listar() {
        Projeto p = new Projeto();
        p.setId(1L);
        return regraNegocioService.listar(p).getRegraNegocios();
    }
}
