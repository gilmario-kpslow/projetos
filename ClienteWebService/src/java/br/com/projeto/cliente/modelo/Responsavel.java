/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.cliente.modelo;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author gilmario
 */
public class Responsavel implements Serializable {

    private Long id;
    private String login;
    private String senha;
    private String nomeCompleto;
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

    @Override
    public String toString() {
        return "Responsavel{" + "id=" + id + ", login=" + login + ", senha=" + senha + ", nomeCompleto=" + nomeCompleto + ", ativo=" + ativo + '}';
    }

}
