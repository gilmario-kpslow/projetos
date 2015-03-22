/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.cliente.interfaces;

import br.com.projeto.cliente.modelo.projeto.Atividade;
import br.com.projeto.cliente.modelo.projeto.Modulo;
import br.com.projeto.cliente.modelo.projeto.Projeto;
import br.com.projeto.cliente.modelo.respostas.InformacaoConsultaFuncionalidade;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 *
 * @author gilmario
 */
@WebService(targetNamespace = "projetos", name = "FuncionalidadeService")
public interface FuncionalidadeService {

    @WebResult
    @WebMethod(operationName = "listarFuncionalidadeProjeto")
    public InformacaoConsultaFuncionalidade listar(@WebParam(name = "projeto", targetNamespace = "") Projeto projeto);

    @WebResult
    @WebMethod(operationName = "listarFuncionalidadeModulo")
    public InformacaoConsultaFuncionalidade listar(@WebParam(name = "modulo", targetNamespace = "") Modulo modulo);

    @WebResult
    @WebMethod(operationName = "listarFuncionalidadeAtividade")
    public InformacaoConsultaFuncionalidade listar(@WebParam(name = "atividade", targetNamespace = "") Atividade atividade);

}
