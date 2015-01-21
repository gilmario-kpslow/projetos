/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.cliente;

import br.com.projeto.modelo.Responsavel;
import br.com.projeto.services.wsdl.ResponsavelService;
import java.net.MalformedURLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gilmario
 */
public class TesteWebSerivce {

    public static void main(String[] args) {
        try {
            ResponsavelService service = new ResponsavelWebServiceCliente("http://localhost:8080/projetos/responsavel?wsdl").getResponsavelServicePort();
            List<Responsavel> responsavel = service.listar(1).getResponsaveis();
            for (Responsavel r : responsavel) {
                System.out.println(r.getNomeCompleto());
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(TesteWebSerivce.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
