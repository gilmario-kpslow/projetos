/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.truesystem.projetosweb.util;

import java.io.Serializable;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author gilmario
 */
@Stateless
public class GeradorMensagem implements Serializable {

    public void gerar(String titulo, String mensagem, FacesMessage.Severity severidade) {
        FacesContext.getCurrentInstance().addMessage("", new FacesMessage(severidade, titulo, mensagem));
    }

}
