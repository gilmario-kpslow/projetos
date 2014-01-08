/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.io.Serializable;
import javax.annotation.PreDestroy;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import modelo.Responsavel;

/**
 *
 * @author gilmario
 */
@Named
@SessionScoped
public class UsuarioMB implements Serializable {

    public UsuarioMB() {
    }

    private Responsavel responsavel;

    public Responsavel getResponsavel() {
        return responsavel;
    }

    public boolean isLogado() {
        return responsavel != null;
    }

    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    }

    @PreDestroy
    private void destroy() {
        System.out.println("Destruida");
    }

}
