/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.services.wsdl;

import br.com.projeto.controller.ResponsavelController;
import br.com.projeto.modelo.Responsavel;
import br.com.projeto.util.Informacao;
import br.com.projeto.util.InformacaoConsultaProjeto;
import br.com.projeto.util.InformacaoConsultaResponsavel;
import br.com.projeto.util.InformacaoResponsavel;
import br.com.projeto.util.TipoMensagem;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * *
 * @author gilmario
 */
@WebService(targetNamespace = "projetos", name = "ResponsavelService", serviceName = "responsavel")
public class ResponsavelService {

    @EJB
    private ResponsavelController controller;

    @WebMethod(operationName = "registrarResponsavel")
    public Informacao registrar(@WebParam(name = "responsavel") Responsavel responsavel) {
        try {
            return controller.registrar(responsavel);
        } catch (Exception ex) {
            Logger.getLogger(ResponsavelService.class.getName()).log(Level.SEVERE, null, ex);
            return new Informacao(TipoMensagem.ERRO, "Erro", ex.toString());
        }
    }

    @WebMethod(operationName = "listarResponsavel")
    public InformacaoConsultaResponsavel listar(@WebParam(name = "inicio") Integer inicio) {
        try {
            return controller.listar();
        } catch (Exception ex) {
            Logger.getLogger(ProjetoService.class.getName()).log(Level.SEVERE, null, ex);
            return new InformacaoConsultaResponsavel(TipoMensagem.ERRO, "Erro", ex.toString());
        }
    }

    @WebMethod(operationName = "loginResponsavel")
    public InformacaoResponsavel login(@WebParam(name = "login") String login, @WebParam(name = "senha") String senha) {
        return controller.login(login, senha);
    }

}
