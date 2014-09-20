/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.docproject.modelo;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author gilmario
 */
public class TopicoPK implements Serializable {

    private String numero;
    private Conteudo conteudo;

    public TopicoPK(String numero, Conteudo conteudo) {
        this.numero = numero;
        this.conteudo = conteudo;
    }

    public TopicoPK() {
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Conteudo getConteudo() {
        return conteudo;
    }

    public void setConteudo(Conteudo conteudo) {
        this.conteudo = conteudo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.numero);
        hash = 37 * hash + Objects.hashCode(this.conteudo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TopicoPK other = (TopicoPK) obj;
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        return Objects.equals(this.conteudo, other.conteudo);
    }

}
