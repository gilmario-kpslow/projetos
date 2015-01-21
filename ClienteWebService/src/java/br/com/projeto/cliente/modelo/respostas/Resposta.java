/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.cliente.modelo.respostas;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gilmario
 */
@XmlRootElement
public class Resposta implements Serializable {

    private TipoResposta tipo;
    private String informacao;
    private Object resposta;

    public Resposta() {
    }

    public Resposta(TipoResposta tipo, String informacao) {
        this.tipo = tipo;
        this.informacao = informacao;
    }

    public Resposta(TipoResposta tipo, String informacao, Object resposta) {
        this.tipo = tipo;
        this.informacao = informacao;
        this.resposta = resposta;
    }

    public TipoResposta getTipo() {
        return tipo;
    }

    public void setTipo(TipoResposta tipo) {
        this.tipo = tipo;
    }

    public String getInformacao() {
        return informacao;
    }

    public void setInformacao(String informacao) {
        this.informacao = informacao;
    }

    public Object getResposta() {
        return resposta;
    }

    public void setResposta(Object resposta) {
        this.resposta = resposta;
    }

}
