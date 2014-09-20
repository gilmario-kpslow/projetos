/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.docproject.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author gilmario
 */
@Entity
@Table(name = "pagina")
@IdClass(value = PaginaPk.class)
public class Pagina implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(nullable = false)
    private Integer numero;
    @Transient
    private List valor;
    @Id
    @JoinColumn(name = "manual", referencedColumnName = "id", nullable = false)
    @ManyToOne
    private Manual manual;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoPagina tipoPagina;

    public Pagina() {
        valor = new ArrayList<>();
    }

    public Manual getManual() {
        return manual;
    }

    public void setManual(Manual manual) {
        this.manual = manual;
    }

    public TipoPagina getTipoPagina() {
        return tipoPagina;
    }

    public void setTipoPagina(TipoPagina tipoPagina) {
        this.tipoPagina = tipoPagina;
    }

    public List getValor() {
        return valor;
    }

    public void setValor(List valor) {
        this.valor = valor;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.numero);
        hash = 73 * hash + Objects.hashCode(this.manual);
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
        final Pagina other = (Pagina) obj;
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        return Objects.equals(this.manual, other.manual);
    }

}
