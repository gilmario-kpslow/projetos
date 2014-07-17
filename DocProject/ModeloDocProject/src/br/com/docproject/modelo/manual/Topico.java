/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.docproject.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author gilmario
 */
@Entity
@Table(name = "topico")
@IdClass(TopicoPK.class)
public class Topico implements Serializable {

    @Id
    @NotEmpty
    private String numero;
    @Id
    @NotNull
    @JoinColumns({
        @JoinColumn(name = "manual", referencedColumnName = "manual", nullable = false),
        @JoinColumn(name = "numero_pagina", referencedColumnName = "numero_pagina", nullable = false),
        @JoinColumn(name = "numero_conteudo", referencedColumnName = "numero", nullable = false)})
    @ManyToOne
    private Conteudo conteudo;
    @Length(max = 100)
    @NotEmpty
    @Column(length = 100)
    private String titulo;
    @Length(max = 10000)
    @Column(length = 10000)
    private String texto;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
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
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.numero);
        hash = 83 * hash + Objects.hashCode(this.conteudo);
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
        final Topico other = (Topico) obj;
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        return Objects.equals(this.conteudo, other.conteudo);
    }

}
