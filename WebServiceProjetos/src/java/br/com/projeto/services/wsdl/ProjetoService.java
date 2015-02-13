/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.services.wsdl;

import br.com.projeto.controller.ProjetoController;
import br.com.projeto.modelo.projeto.Projeto;
import br.com.projeto.util.Informacao;
import br.com.projeto.util.InformacaoConsultaProjeto;
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
@WebService(targetNamespace = "projetos", name = "ProjetoService", serviceName = "projeto")
public class ProjetoService {

    @EJB
    private ProjetoController controller;

    @WebMethod(operationName = "criarProjeto")
    public Informacao criar(@WebParam(name = "projeto") Projeto projeto) {
        try {
            return controller.registrar(projeto);
        } catch (Exception ex) {
            Logger.getLogger(ProjetoService.class.getName()).log(Level.SEVERE, null, ex);
            return new Informacao(TipoMensagem.ERRO, "Erro", ex.toString());
        }
    }

    @WebMethod(operationName = "listarProjeto")
    public InformacaoConsultaProjeto listar(@WebParam(name = "inicio") Integer inicio) {
        try {
            return controller.listar(inicio);
        } catch (Exception ex) {
            Logger.getLogger(ProjetoService.class.getName()).log(Level.SEVERE, null, ex);
            return new InformacaoConsultaProjeto(TipoMensagem.ERRO, "Erro", ex.toString());
        }
    }

}
