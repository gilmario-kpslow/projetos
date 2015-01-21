/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetos.android.modelos;

import br.com.projetos.android.util.anotacoes.XmlObject;

/**
 *
 * @author gilmario
 */
@XmlObject(tagName = "mensagem", tagTipo = XmlObject.TipoDadoXML.COMPLEXO)
public class Informacao {

    @XmlObject(tagName = "tipo", tagTipo = XmlObject.TipoDadoXML.ENUMERADO)
    private TipoMensagem tipo;
    @XmlObject(tagName = "titulo")
    private String titulo;
    @XmlObject(tagName = "conteudo")
    private String conteudo;

    public Informacao() {
    }

    public Informacao(String titulo) {
        this.titulo = titulo;
    }

    public Informacao(String titulo, String conteudo) {
        this.titulo = titulo;
        this.conteudo = conteudo;
    }

    public Informacao(TipoMensagem tipo, String titulo, String conteudo) {
        this.tipo = tipo;
        this.titulo = titulo;
        this.conteudo = conteudo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public TipoMensagem getTipo() {
        return tipo;
    }

    public void setTipo(TipoMensagem tipo) {
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

}
