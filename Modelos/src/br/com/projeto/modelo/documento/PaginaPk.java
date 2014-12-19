/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.modelo.documento;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author gilmario
 */
public class PaginaPk implements Serializable {

    private Manual manual;
    private Integer numero;

    public Manual getManual() {
        return manual;
    }

    public void setManual(Manual manual) {
        this.manual = manual;
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
        hash = 11 * hash + Objects.hashCode(this.manual);
        hash = 11 * hash + Objects.hashCode(this.numero);
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
        final PaginaPk other = (PaginaPk) obj;
        if (!Objects.equals(this.manual, other.manual)) {
            return false;
        }
        return Objects.equals(this.numero, other.numero);
    }

}
