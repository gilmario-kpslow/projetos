/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.cliente.interfaces;

import br.com.projeto.cliente.modelo.projeto.Atividade;
import br.com.projeto.cliente.modelo.projeto.Funcionalidade;
import br.com.projeto.cliente.modelo.projeto.Modulo;
import br.com.projeto.cliente.modelo.projeto.Projeto;
import br.com.projeto.cliente.modelo.respostas.InformacaoConsultaRegraNegocio;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 *
 * @author gilmario
 */
@WebService(targetNamespace = "projetos", name = "RegraNegocioService")
public interface RegraNegocioService {

    @WebMethod(operationName = "listarRegraNegocioProjeto")
    @WebResult
    public InformacaoConsultaRegraNegocio listar(@WebParam(name = "projeto", targetNamespace = "") Projeto projeto);

    @WebMethod(operationName = "listarRegraNegocioModulo")
    @WebResult
    public InformacaoConsultaRegraNegocio listar(@WebParam(name = "modulo", targetNamespace = "") Modulo modulo);

    @WebMethod(operationName = "listarRegraNegocioAtividade")
    @WebResult
    public InformacaoConsultaRegraNegocio listar(@WebParam(name = "atividade", targetNamespace = "") Atividade atividade);

    @WebMethod(operationName = "listarRegraNegocioFuncionalidade")
    @WebResult
    public InformacaoConsultaRegraNegocio listar(@WebParam(name = "funcionalidade", targetNamespace = "") Funcionalidade funcionalidade);

}
