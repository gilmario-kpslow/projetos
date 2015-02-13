/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.util;

import br.com.projeto.modelo.projeto.Atividade;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gilmario
 */
@XmlRootElement
public class InformacaoAtividade extends Informacao {

    private Atividade atividade;

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

}
