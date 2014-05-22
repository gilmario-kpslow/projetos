/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.ResponsavelDAO;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.DependsOn;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.context.Dependent;
import modelo.Responsavel;

/**
 *
 * @author gilmario
 */
@Singleton
@Startup
public class AplicacaoConfiguracao implements Serializable {

    @EJB
    private ResponsavelDAO responsavelFacade;
    private String servidor;
    private String porta;
    private String nomeSistema;
    private final String extensao;

    //@PostConstruct
    private void init() {
        criarResponsavelPadrao();
    }

    public AplicacaoConfiguracao() {
        extensao = ".xhtml";
    }

    public String getServidor() {
        return servidor;
    }

    public String getPorta() {
        return porta;
    }

    public String getNomeSistema() {
        return nomeSistema;
    }

    public String getExtensao() {
        return extensao;
    }

    private void criarResponsavelPadrao() {
        Responsavel responsavel;
        try {
            responsavel = responsavelFacade.encontra(new Integer(1));
        } catch (Exception e) {
            responsavel = null;
            e.printStackTrace();
        }
        if (responsavel == null) {
            responsavel = new Responsavel();
            responsavel.setId(1);
            responsavel.setNome("Mestre");
            responsavel.setSenha("Controle");
            System.out.println(responsavelFacade);
            responsavelFacade.criar(responsavel);
        }

    }

}
