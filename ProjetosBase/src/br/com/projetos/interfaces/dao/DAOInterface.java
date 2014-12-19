/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetos.interfaces.dao;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author gilmario
 * @param <T>
 * @param <Id>
 */
public interface DAOInterface<T, Id extends Serializable> {

    public void salvar(T t) throws Exception;

    public void excluir(Id pk) throws Exception;

    public T carregar(Id pk) throws Exception;

    public T referencia(Id pk) throws Exception;

    public List listar() throws Exception;

}
