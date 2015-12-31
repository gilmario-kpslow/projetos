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

    private final String servidor = "http://localhost:8080/service";

    public URL getUrlWebServiceResponsavel() {
        try {
            return new URL(servidor + "/responsavel?wsdl");
        } catch (MalformedURLException ex) {
            Logger.getLogger(UrlInject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public URL getUrlWebServiceModulo() {
        try {
            return new URL(servidor + "/modulo?wsdl");
        } catch (MalformedURLException ex) {
            Logger.getLogger(UrlInject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public URL getUrlWebServiceProjeto() {
        try {
            return new URL(servidor + "/projeto?wsdl");
        } catch (MalformedURLException ex) {
            Logger.getLogger(UrlInject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public URL getUrlWebServiceAtividade() {
        try {
            return new URL(servidor + "/atividade?wsdl");
        } catch (MalformedURLException ex) {
            Logger.getLogger(UrlInject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public URL getUrlWebServiceFuncionalidade() {
        try {
            return new URL(servidor + "/funcionalidade?wsdl");
        } catch (MalformedURLException ex) {
            Logger.getLogger(UrlInject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public URL getUrlWebServiceRegraNegocio() {
        try {
            return new URL(servidor + "/regranegocio?wsdl");
        } catch (MalformedURLException ex) {
            Logger.getLogger(UrlInject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
