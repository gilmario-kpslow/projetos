/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.services.wsdl;

import br.com.projeto.controller.FuncionalidadeController;
import br.com.projeto.modelo.projeto.Atividade;
import br.com.projeto.modelo.projeto.Funcionalidade;
import br.com.projeto.modelo.projeto.Modulo;
import br.com.projeto.modelo.projeto.Projeto;
import br.com.projeto.util.Informacao;
import br.com.projeto.util.InformacaoConsultaFuncionalidade;
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
@WebService(targetNamespace = "projetos", name = "FuncionalidadeService", serviceName = "funcionalidade")
public class FuncionalidadeService {

    @EJB
    private FuncionalidadeController controller;

    @WebMethod(operationName = "criarFuncionalidade")
    public Informacao criar(@WebParam(name = "funcionalidade") Funcionalidade funcionalidade) {
        try {
            return controller.registrar(funcionalidade);
        } catch (Exception ex) {
            Logger.getLogger(FuncionalidadeService.class.getName()).log(Level.SEVERE, null, ex);
            return new Informacao(TipoMensagem.ERRO, "Erro", ex.toString());
        }
    }

    @WebMethod(operationName = "listarFuncionalidadeProjeto")
    public InformacaoConsultaFuncionalidade listar(@WebParam(name = "projeto") Projeto projeto) {
        try {
            return controller.listar(projeto);
        } catch (Exception ex) {
            Logger.getLogger(FuncionalidadeService.class.getName()).log(Level.SEVERE, null, ex);
            return new InformacaoConsultaFuncionalidade(TipoMensagem.ERRO, "Erro", ex.toString());
        }
    }

    @WebMethod(operationName = "listarFuncionalidadeModulo")
    public InformacaoConsultaFuncionalidade listar(@WebParam(name = "modulo") Modulo modulo) {
        try {
            return controller.listar(modulo);
        } catch (Exception ex) {
            Logger.getLogger(FuncionalidadeService.class.getName()).log(Level.SEVERE, null, ex);
            return new InformacaoConsultaFuncionalidade(TipoMensagem.ERRO, "Erro", ex.toString());
        }
    }

    @WebMethod(operationName = "listarFuncionalidadeAtividade")
    public InformacaoConsultaFuncionalidade listar(@WebParam(name = "atividade") Atividade atividade) {
        try {
            return controller.listar(atividade);
        } catch (Exception ex) {
            Logger.getLogger(FuncionalidadeService.class.getName()).log(Level.SEVERE, null, ex);
            return new InformacaoConsultaFuncionalidade(TipoMensagem.ERRO, "Erro", ex.toString());
        }
    }

}
