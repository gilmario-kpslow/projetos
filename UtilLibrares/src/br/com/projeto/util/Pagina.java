/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.util;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gilmario
 */
@XmlRootElement
public class Pagina implements Serializable {

    private Integer pagina;
    private Integer quantidade;

    public Pagina() {
    }

    public Pagina(Integer pagina, Integer quantidade) {
        this.pagina = pagina;
        this.quantidade = quantidade;
    }

    public Integer getTotal() {
        return this.pagina * this.quantidade;
    }

    public Integer getInicio() {
        return (this.pagina * this.quantidade) - this.quantidade;
    }

    public Integer getPagina() {
        return pagina;
    }

    public void setPagina(Integer pagina) {
        this.pagina = pagina;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

}
