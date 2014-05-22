/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * Classe do Projeto ******* - Criado em 17/05/2013 -
 *
 * @author Gilmário
 */
public class MenssagemUtil {

    public static void addMessageInfo(String menssagem) {
        addMenssagem(null, FacesMessage.SEVERITY_INFO, "Informação", menssagem);
    }

    public static void addMessageWarn(String menssagem) {
        addMenssagem(null, FacesMessage.SEVERITY_WARN, "Atenção", menssagem);
    }

    public static void addMessageFatal(String menssagem) {
        addMenssagem(null, FacesMessage.SEVERITY_FATAL, "Fatal", menssagem);
    }

    public static void addMessageErro(Object menssagem) {
        addMenssagem(null, FacesMessage.SEVERITY_ERROR, "Erro", menssagem.toString());
    }

    public static void addMenssagem(String clientId, FacesMessage.Severity severity, String sumario, String detalhe) {
        FacesContext.getCurrentInstance().addMessage(clientId, new FacesMessage(severity, sumario, detalhe));
    }
}
