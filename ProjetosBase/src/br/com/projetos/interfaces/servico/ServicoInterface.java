/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetos.interfaces.servico;

import br.com.projeto.util.Informacao;

/**
 *
 * @author gilmario
 * @param <T>
 */
public interface ServicoInterface<T> {

    public Informacao registra(T t);

    public T remove(T t);
}
