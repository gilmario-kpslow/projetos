/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.cliente.mb;

import br.com.projeto.cliente.controller.FuncionalidadeController;
import br.com.projeto.cliente.modelo.projeto.Funcionalidade;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author gilmario
 */
@Named
@RequestScoped
public class FuncionalidadeMB implements Serializable {

    @EJB
    private FuncionalidadeController controller;
    private List<Funcionalidade> funcionalidades;

    public String listar() {
        funcionalidades = controller.listar();
        return "";
    }

    public List<Funcionalidade> getFuncionalidades() {
        return funcionalidades;
    }

    public void setFuncionalidades(List<Funcionalidade> funcionalidades) {
        this.funcionalidades = funcionalidades;
    }

}
