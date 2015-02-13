/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.cliente.controller;

import br.com.projeto.cliente.ModuloWebServiceCliente;
import br.com.projeto.cliente.ProjetoWebServiceCliente;
import br.com.projeto.cliente.UrlInject;
import br.com.projeto.cliente.interfaces.ModuloService;
import br.com.projeto.cliente.interfaces.ProjetoService;
import br.com.projeto.cliente.modelo.projeto.Modulo;
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
public class ModuloController implements Serializable {

    @EJB
    private UrlInject urlInject;
    private ModuloService moduloService;

    @PostConstruct
    private void init() {
        moduloService = new ModuloWebServiceCliente(urlInject.getUrlWebServiceModulo()).getServicePort();
    }

    public List<Modulo> listar() {
        Projeto p = new Projeto();
        p.setId(1L);
        return moduloService.listarModulo(p).getModulos();
    }
}
