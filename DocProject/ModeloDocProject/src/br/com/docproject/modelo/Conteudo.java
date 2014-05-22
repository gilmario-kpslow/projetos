/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.docproject.modelo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author gilmario
 */
@Entity
@Table(name = "conteudo")
@IdClass(ConteudoPK.class)
public class Conteudo implements Serializable {

    @Id
    @NotNull
    @Column(length = 255, nullable = false)
    private String numero;
    @NotNull
    @Column(length = 255, nullable = false)
    private String titulo;
    @NotNull
    @Column(length = 100000, nullable = false)
    private String texto;
    @Id
    @NotNull
    @JoinColumns({
        @JoinColumn(name = "manual", referencedColumnName = "id", nullable = false),
        @JoinColumn(name = "numero_pagina", referencedColumnName = "numero", nullable = false)})
    @ManyToOne
    private Pagina pagina;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Topico> listaTopico;

    public Conteudo() {
    }

    public Pagina getPagina() {
        return pagina;
    }

    public void setPagina(Pagina pagina) {
        this.pagina = pagina;
    }

    public List<Topico> getListaTopico() {
        return listaTopico;
    }

    public void setListaTopico(List<Topico> listaTopico) {
        this.listaTopico = listaTopico;
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.numero);
        hash = 97 * hash + Objects.hashCode(this.pagina);
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
        final Conteudo other = (Conteudo) obj;
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        return Objects.equals(this.pagina, other.pagina);
    }

}
