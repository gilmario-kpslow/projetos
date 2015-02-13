/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.cliente.mb;

import br.com.projeto.cliente.controller.ProjetoController;
import br.com.projeto.cliente.modelo.projeto.Projeto;
import java.io.Serializable;
import java.util.ArrayList;
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
public class ProjetoMB implements Serializable {

    @EJB
    private ProjetoController controller;
    private List<Projeto> projetos = new ArrayList<>();

    public String listar() {
        projetos = controller.listar();
        return "";
    }

    public List<Projeto> getProjetos() {
        return projetos;
    }

    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }

}
