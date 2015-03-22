/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.cliente.controller;

import br.com.projeto.cliente.FuncionalidadeWebServiceCliente;
import br.com.projeto.cliente.UrlInject;
import br.com.projeto.cliente.interfaces.FuncionalidadeService;
import br.com.projeto.cliente.modelo.projeto.Funcionalidade;
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
public class FuncionalidadeController implements Serializable {

    @EJB
    private UrlInject urlInject;
    private FuncionalidadeService funcionalidadeService;

    @PostConstruct
    private void init() {
        funcionalidadeService = new FuncionalidadeWebServiceCliente(urlInject.getUrlWebServiceFuncionalidade()).getServicePort();
    }

    public List<Funcionalidade> listar() {
        Projeto p = new Projeto();
        p.setId(1L);
        return funcionalidadeService.listar(p).getFuncionalidades();
    }
}
