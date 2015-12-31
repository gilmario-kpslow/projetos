/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.cliente;

import br.com.projeto.cliente.interfaces.ResponsavelService;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;

/**
 *
 * @author gilmario
 */
@WebServiceClient(name = "ResponsavelCliente", targetNamespace = "projetos")
public class ResponsavelWebServiceCliente extends Service {

    public ResponsavelWebServiceCliente(URL url) {
        super(url, new QName("projetos", "responsavel"));
    }

    @WebEndpoint(name = "ResponsavelServicePort")
    public ResponsavelService getResponsavelServicePort() {
        return super.getPort(new QName("projetos", "ResponsavelServicePort"), ResponsavelService.class);
    }

}
