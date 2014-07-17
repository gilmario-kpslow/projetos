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
@Table(name = "capa")
public class Capa implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotEmpty
    @Column(nullable = false)
    @Length(max = 255)
    private String cabecalho;
    @NotEmpty
    @Length(max = 255)
    @Column(nullable = false)
    private String titulo;
    @NotEmpty
    @Length(max = 255)
    @Column(nullable = false)
    private String SubTitulo;
    @Id
    @NotNull
    @JoinColumns({
        @JoinColumn(name = "manual", referencedColumnName = "manual", nullable = false),
        @JoinColumn(name = "numero_pagina", referencedColumnName = "numero", nullable = false)})
    @ManyToOne
    private Pagina pagina;

    public Capa() {
    }

    public String getCabecalho() {
        return cabecalho;
    }

    public void setCabecalho(String cabecalho) {
        this.cabecalho = cabecalho;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSubTitulo() {
        return SubTitulo;
    }

    public void setSubTitulo(String SubTitulo) {
        this.SubTitulo = SubTitulo;
    }

    public Pagina getPagina() {
        return pagina;
    }

    public void setPagina(Pagina pagina) {
        this.pagina = pagina;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.pagina);
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
        final Capa other = (Capa) obj;
        return Objects.equals(this.pagina, other.pagina);
    }

}
