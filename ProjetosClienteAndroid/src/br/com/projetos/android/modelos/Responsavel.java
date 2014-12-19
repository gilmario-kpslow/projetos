/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetos.android.modelos;

import br.com.projetos.android.util.anotacoes.XmlObject;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author gilmario
 */
@XmlObject(tagName = "responsavel")
public class Responsavel implements Serializable {

    @XmlObject(tagName = "id", tagTipo = XmlObject.TipoDadoXML.LONG)
    private Long id;
    @XmlObject(tagName = "login")
    private String login;
    @XmlObject(tagName = "senha")
    private String senha;
    @XmlObject(tagName = "nomeCompleto")
    private String nomeCompleto;
    @XmlObject(tagName = "ativo", tagTipo = XmlObject.TipoDadoXML.BOOLEANO)
    private Boolean ativo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.id);
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
        final Responsavel other = (Responsavel) obj;
        return Objects.equals(this.id, other.id);
    }

    public Responsavel() {
    }

}
