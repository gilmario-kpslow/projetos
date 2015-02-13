/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.cliente.mb;

import br.com.projeto.cliente.controller.ModuloController;
import br.com.projeto.cliente.controller.ResponsavelController;
import br.com.projeto.cliente.modelo.Responsavel;
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
public class ModuloMB implements Serializable {

    @EJB
    private ModuloController controller;
    private List<Modulo> modulos;

    public String listar() {
        modulos = controller.listar();
        return "";
    }

    public List<Modulo> getModulos() {
        return modulos;
    }

    public void setModulos(List<Modulo> modulos) {
        this.modulos = modulos;
    }

}
