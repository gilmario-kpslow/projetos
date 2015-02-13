/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.cliente.controller;

import br.com.projeto.cliente.ProjetoWebServiceCliente;
import br.com.projeto.cliente.UrlInject;
import br.com.projeto.cliente.interfaces.ProjetoService;
import br.com.projeto.cliente.modelo.projeto.Projeto;
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
public class ProjetoController implements Serializable {

    @EJB
    private UrlInject urlInject;
    private ProjetoService projetoService;

    @PostConstruct
    private void init() {
        projetoService = new ProjetoWebServiceCliente(urlInject.getUrlWebServiceProjeto()).getServicePort();
    }

    public List<Projeto> listar() {
        return projetoService.listarProjeto(0).getProjetos();
    }
}
