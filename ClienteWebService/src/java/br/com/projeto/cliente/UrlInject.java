/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.cliente;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 *
 * @author gilmario
 */
@Stateless
public class UrlInject implements Serializable {

    public URL getUrlwebService() {
        try {
            return new URL("http://localhost:8080/projetos/responsavel?wsdl");
        } catch (MalformedURLException ex) {
            Logger.getLogger(UrlInject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
