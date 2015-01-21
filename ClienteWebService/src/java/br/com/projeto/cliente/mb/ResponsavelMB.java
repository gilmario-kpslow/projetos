/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.cliente.mb;

import br.com.projeto.cliente.ResponsavelWebServiceCliente;
import br.com.projeto.cliente.UrlInject;
import br.com.projeto.cliente.controller.ResponsavelController;
import br.com.projeto.cliente.modelo.Responsavel;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;

/**
 *
 * @author gilmario
 */
@Named
@RequestScoped
public class ResponsavelMB implements Serializable {

    @EJB
    private ResponsavelController controller;
    private List<Responsavel> responsaveis;

    public String listar() {
        responsaveis = controller.listar(0);
        return "";
    }

    public List<Responsavel> getResponsaveis() {
        return responsaveis;
    }

    public void setResponsaveis(List<Responsavel> responsaveis) {
        this.responsaveis = responsaveis;
    }

}
