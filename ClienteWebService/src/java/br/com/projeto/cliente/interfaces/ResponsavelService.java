/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.cliente.interfaces;

import br.com.projeto.cliente.modelo.Responsavel;
import br.com.projeto.cliente.modelo.respostas.Informacao;
import br.com.projeto.cliente.modelo.respostas.InformacaoConsultaResponsavel;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 *
 * @author gilmario
 */
@WebService(targetNamespace = "projetos", name = "ResponsavelService", wsdlLocation = "http://webservice-gilserver.rhcloud.com/service/responsavel?wsdl")
public interface ResponsavelService {

    @WebMethod
    public Informacao registrarResponsavel(@WebParam(name = "responsavel", targetNamespace = "") Responsavel responsavel);

    @WebMethod
    @WebResult(targetNamespace = "")
    public InformacaoConsultaResponsavel listarResponsavel(@WebParam(name = "inicio", targetNamespace = "") Integer inicio);

}
