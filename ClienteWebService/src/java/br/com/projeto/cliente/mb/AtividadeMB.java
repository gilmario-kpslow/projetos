/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.cliente.mb;

import br.com.projeto.cliente.controller.AtividadeController;
import br.com.projeto.cliente.controller.ModuloController;
import br.com.projeto.cliente.controller.ResponsavelController;
import br.com.projeto.cliente.modelo.Responsavel;
import br.com.projeto.cliente.modelo.projeto.Atividade;
import br.com.projeto.cliente.modelo.projeto.Modulo;
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
public class AtividadeMB implements Serializable {

    @EJB
    private AtividadeController controller;
    private List<Atividade> atividades;

    public String listar() {
        atividades = controller.listar();
        return "";
    }

    public List<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(List<Atividade> atividades) {
        this.atividades = atividades;
    }

}
