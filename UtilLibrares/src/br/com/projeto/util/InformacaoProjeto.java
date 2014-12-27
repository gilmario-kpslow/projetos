/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.util;

import br.com.projeto.modelo.projeto.Projeto;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gilmario
 */
@XmlRootElement
public class InformacaoProjeto extends Informacao {

    private Projeto projeto;

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

}
