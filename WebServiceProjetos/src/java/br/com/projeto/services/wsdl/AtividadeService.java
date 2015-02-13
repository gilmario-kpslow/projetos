/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.services.wsdl;

import br.com.projeto.controller.AtividadeController;
import br.com.projeto.modelo.projeto.Atividade;
import br.com.projeto.modelo.projeto.Modulo;
import br.com.projeto.modelo.projeto.Projeto;
import br.com.projeto.util.Informacao;
import br.com.projeto.util.InformacaoConsultaAtividade;
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
@WebService(targetNamespace = "projetos", name = "AtividadeService", serviceName = "atividade")
public class AtividadeService {

    @EJB
    private AtividadeController controller;

    @WebMethod(operationName = "criarAtividade")
    public Informacao criar(@WebParam(name = "atividade") Atividade atividade) {
        try {
            return controller.registrar(atividade);
        } catch (Exception ex) {
            Logger.getLogger(AtividadeService.class.getName()).log(Level.SEVERE, null, ex);
            return new Informacao(TipoMensagem.ERRO, "Erro", ex.toString());
        }
    }

    @WebMethod(operationName = "listarAtividadeProjeto")
    public InformacaoConsultaAtividade listar(@WebParam(name = "projeto") Projeto projeto) {
        try {
            return controller.listar(projeto);
        } catch (Exception ex) {
            Logger.getLogger(ProjetoService.class.getName()).log(Level.SEVERE, null, ex);
            return new InformacaoConsultaAtividade(TipoMensagem.ERRO, "Erro", ex.toString());
        }
    }

    @WebMethod(operationName = "listarAtividadeModulo")
    public InformacaoConsultaAtividade listar(@WebParam(name = "modulo") Modulo modulo) {
        try {
            return controller.listar(modulo);
        } catch (Exception ex) {
            Logger.getLogger(ProjetoService.class.getName()).log(Level.SEVERE, null, ex);
            return new InformacaoConsultaAtividade(TipoMensagem.ERRO, "Erro", ex.toString());
        }
    }

}
