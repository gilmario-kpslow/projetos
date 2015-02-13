/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.cliente.interfaces;

import br.com.projeto.cliente.modelo.projeto.Modulo;
import br.com.projeto.cliente.modelo.projeto.Projeto;
import br.com.projeto.cliente.modelo.respostas.InformacaoConsultaAtividade;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 *
 * @author gilmario
 */
@WebService(targetNamespace = "projetos", name = "AtividadeService")
public interface AtividadeService {

    @WebMethod(operationName = "listarAtividadeProjeto")
    @WebResult
    public InformacaoConsultaAtividade listar(@WebParam(name = "projeto", targetNamespace = "") Projeto projeto);

    @WebMethod(operationName = "listarAtividadeModulo")
    @WebResult
    public InformacaoConsultaAtividade listar(@WebParam(name = "modulo", targetNamespace = "") Modulo modulo);

}
