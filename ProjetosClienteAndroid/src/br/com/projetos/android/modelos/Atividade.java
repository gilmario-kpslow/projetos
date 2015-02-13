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
@XmlObject(tagName = "atividade", tagTipo = XmlObject.TipoDadoXML.COMPLEXO)
public class Atividade {

    @XmlObject(tagName = "id", tagTipo = XmlObject.TipoDadoXML.LONG)
    private Long id;
    @XmlObject(tagName = "nome")
    private String nome;
    @XmlObject(tagName = "descricao")
    private String descricao;
    @XmlObject(tagName = "modulo", tagTipo = XmlObject.TipoDadoXML.COMPLEXO)
    private Modulo modulo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }

}
