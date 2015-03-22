/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.services.wsdl;

import br.com.projeto.controller.RegraNegocioController;
import br.com.projeto.modelo.projeto.Atividade;
import br.com.projeto.modelo.projeto.Funcionalidade;
import br.com.projeto.modelo.projeto.Modulo;
import br.com.projeto.modelo.projeto.Projeto;
import br.com.projeto.modelo.projeto.RegraNegocio;
import br.com.projeto.util.Informacao;
import br.com.projeto.util.InformacaoConsultaRegraNegocio;
import br.com.projeto.util.TipoMensagem;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author gilmario
 */
@WebService(targetNamespace = "projetos", name = "RegraNegocioService", serviceName = "regranegocio")
public class RegraNegocioService {

    @EJB
    private RegraNegocioController controller;

    @WebMethod(operationName = "criarRegraNegocio")
    public Informacao criar(@WebParam(name = "regraNegocio") RegraNegocio regraNegocio) {
        try {
            return controller.registrar(regraNegocio);
        } catch (Exception ex) {
            Logger.getLogger(RegraNegocioService.class.getName()).log(Level.SEVERE, null, ex);
            return new Informacao(TipoMensagem.ERRO, "Erro", ex.toString());
        }
    }

    @WebMethod(operationName = "listarRegraNegocioProjeto")
    public InformacaoConsultaRegraNegocio listar(@WebParam(name = "projeto") Projeto projeto) {
        try {
            return controller.listar(projeto);
        } catch (Exception ex) {
            Logger.getLogger(RegraNegocioService.class.getName()).log(Level.SEVERE, null, ex);
            return new InformacaoConsultaRegraNegocio(TipoMensagem.ERRO, "Erro", ex.toString());
        }
    }

    @WebMethod(operationName = "listarRegraNegocioModulo")
    public InformacaoConsultaRegraNegocio listar(@WebParam(name = "modulo") Modulo modulo) {
        try {
            return controller.listar(modulo);
        } catch (Exception ex) {
            Logger.getLogger(RegraNegocioService.class.getName()).log(Level.SEVERE, null, ex);
            return new InformacaoConsultaRegraNegocio(TipoMensagem.ERRO, "Erro", ex.toString());
        }
    }

    @WebMethod(operationName = "listarRegraNegocioAtividade")
    public InformacaoConsultaRegraNegocio listar(@WebParam(name = "atividade") Atividade atividade) {
        try {
            return controller.listar(atividade);
        } catch (Exception ex) {
            Logger.getLogger(RegraNegocioService.class.getName()).log(Level.SEVERE, null, ex);
            return new InformacaoConsultaRegraNegocio(TipoMensagem.ERRO, "Erro", ex.toString());
        }
    }

    @WebMethod(operationName = "listarRegraNegocioFuncionalidade")
    public InformacaoConsultaRegraNegocio listar(@WebParam(name = "funcionalidade") Funcionalidade funcionalidade) {
        try {
            return controller.listar(funcionalidade);
        } catch (Exception ex) {
            Logger.getLogger(RegraNegocioService.class.getName()).log(Level.SEVERE, null, ex);
            return new InformacaoConsultaRegraNegocio(TipoMensagem.ERRO, "Erro", ex.toString());
        }
    }

}
