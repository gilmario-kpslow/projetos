/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.cliente.mb;

import br.com.projeto.cliente.controller.RegraNegocioController;
import br.com.projeto.cliente.modelo.projeto.RegraNegocio;
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
public class RegraNegocioMB implements Serializable {

    @EJB
    private RegraNegocioController controller;
    private List<RegraNegocio> regraNegocios;

    public String listar() {
        regraNegocios = controller.listar();
        return "";
    }

    public List<RegraNegocio> getRegraNegocios() {
        return regraNegocios;
    }

    public void setRegraNegocios(List<RegraNegocio> regraNegocios) {
        this.regraNegocios = regraNegocios;
    }

}
