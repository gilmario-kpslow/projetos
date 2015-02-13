/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.cliente;

import br.com.projeto.cliente.interfaces.ModuloService;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;

/**
 *
 * @author gilmario
 */
public class ModuloWebServiceCliente extends Service {

    public ModuloWebServiceCliente(URL url) {
        super(url, new QName("projetos", "modulo"));
    }

    @WebEndpoint(name = "ModuloServicePort")
    public ModuloService getServicePort() {
        return super.getPort(new QName("projetos", "ModuloServicePort"), ModuloService.class);
    }

}
