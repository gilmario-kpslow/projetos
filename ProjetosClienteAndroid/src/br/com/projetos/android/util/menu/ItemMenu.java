/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetos.android.util.menu;

/**
 *
 * @author gilmario
 */
public class ItemMenu {

    private String nome;
    private String descricao;
    private boolean estaVisivel;

    public ItemMenu(String nome, String descricao, boolean estaVisivel) {
        this.nome = nome;
        this.descricao = descricao;
        this.estaVisivel = estaVisivel;
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

    public boolean isEstaVisivel() {
        return estaVisivel;
    }

    public void setEstaVisivel(boolean estaVisivel) {
        this.estaVisivel = estaVisivel;
    }

}
