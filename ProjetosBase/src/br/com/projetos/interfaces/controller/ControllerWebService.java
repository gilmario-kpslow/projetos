/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetos.interfaces.controller;

import br.com.projeto.util.Informacao;
import java.io.Serializable;

/**
 *
 * @author gilmario
 * @param <T>
 * @param <Id>
 */
public interface ControllerWebService<T, Id extends Serializable> {

    public Informacao registrar(T t) throws Exception;

    public Informacao remover(Id id) throws Exception;

    public Informacao editar(T t) throws Exception;

    public Informacao carregar(Id id) throws Exception;

    public Informacao valida(T t) throws Exception;

    public Informacao listar(Integer inicio) throws Exception;

}
