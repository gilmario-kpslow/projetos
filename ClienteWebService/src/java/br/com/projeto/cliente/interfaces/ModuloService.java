/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.cliente.interfaces;

import br.com.projeto.cliente.modelo.projeto.Projeto;
import br.com.projeto.cliente.modelo.respostas.InformacaoConsultaModulo;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 *
 * @author gilmario
 */
@WebService(targetNamespace = "projetos", name = "ModuloService")
public interface ModuloService {

    @WebMethod
    @WebResult
    public InformacaoConsultaModulo listarModulo(@WebParam(name = "projeto", targetNamespace = "") Projeto projeto);

}
