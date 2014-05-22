/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author gilmario
 */
@Named
@RequestScoped
public class NavegacaoBean implements Serializable {

    public void redireciona(String pagina) {
        try {
            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            String nomeSiste = context.getRequestContextPath();
            String url = nomeSiste + "/web/" + pagina + ".xhtml";
            context.redirect(url);
        } catch (IOException ex) {
            Logger.getLogger(NavegacaoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
