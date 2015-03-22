/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.services.wsdl;

import br.com.projeto.controller.ModuloController;
import br.com.projeto.modelo.projeto.Modulo;
import br.com.projeto.modelo.projeto.Projeto;
import br.com.projeto.util.Informacao;
import br.com.projeto.util.InformacaoConsultaModulo;
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
@WebService(targetNamespace = "projetos", name = "ModuloService", serviceName = "modulo")
public class ModuloService {

    @EJB
    private ModuloController controller;

    @WebMethod(operationName = "criarModulo")
    public Informacao criar(@WebParam(name = "modulo") Modulo modulo) {
        try {
            return controller.registrar(modulo);
        } catch (Exception ex) {
            Logger.getLogger(ModuloService.class.getName()).log(Level.SEVERE, null, ex);
            return new Informacao(TipoMensagem.ERRO, "Erro", ex.toString());
        }
    }

    @WebMethod(operationName = "editaModulo")
    public Informacao editar(@WebParam(name = "modulo") Modulo modulo) {
        try {
            return controller.editar(modulo);
        } catch (Exception ex) {
            Logger.getLogger(ModuloService.class.getName()).log(Level.SEVERE, null, ex);
            return new Informacao(TipoMensagem.ERRO, "Erro", ex.toString());
        }
    }

    @WebMethod(operationName = "removeModulo")
    public Informacao remove(@WebParam(name = "modulo") Modulo modulo) {
        try {
            return controller.remover(modulo.getId());
        } catch (Exception ex) {
            Logger.getLogger(ModuloService.class.getName()).log(Level.SEVERE, null, ex);
            return new Informacao(TipoMensagem.ERRO, "Erro", ex.toString());
        }
    }

    @WebMethod(operationName = "listarModulo")
    public InformacaoConsultaModulo listar(@WebParam(name = "projeto") Projeto projeto) {
        try {
            return controller.listar(projeto);
        } catch (Exception ex) {
            Logger.getLogger(ModuloService.class.getName()).log(Level.SEVERE, null, ex);
            return new InformacaoConsultaModulo(TipoMensagem.ERRO, "Erro", ex.toString());
        }
    }

}
