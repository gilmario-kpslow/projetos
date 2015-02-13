/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.cliente;

import br.com.projeto.cliente.interfaces.AtividadeService;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;

/**
 *
 * @author gilmario
 */
public class AtividadeWebServiceCliente extends Service {

    public AtividadeWebServiceCliente(URL url) {
        super(url, new QName("projetos", "atividade"));
    }

    @WebEndpoint(name = "AtividadeServicePort")
    public AtividadeService getServicePort() {
        return super.getPort(new QName("projetos", "AtividadeServicePort"), AtividadeService.class);
    }

}
