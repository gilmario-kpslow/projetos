/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.docproject.controller;

import br.com.docproject.dao.DAO;
import java.io.Serializable;
import java.util.List;

/**
 * @param <T>
 * @param <PK>
 * @author Gilmário
 */
public abstract class Controller<T, PK extends Serializable> implements Serializable {

    private DAO dao;

    /**
     *
     */
    protected abstract void inicializaDAO();

    /**
     *
     * @param dao
     */
    protected void setDAO(DAO dao) {
        this.dao = dao;
    }

    /**
     *
     * @return
     */
    protected DAO getDAO() {
        return dao;
    }

    /**
     *
     * @param t
     * @throws Exception
     */
    public void salvar(T t) throws Exception {
        dao.salvar(t);
    }

    /**
     *
     * @param t
     * @throws Exception
     */
    public void atualizar(T t) throws Exception {
        dao.atualizar(t);
    }

    /**
     *
     * @param t
     * @throws Exception
     */
    public void salvarouAtualizar(T t) throws Exception {
        dao.atualizar(t);
    }

    /**
     *
     * @param t
     * @throws Exception
     */
    public void excluir(T t) throws Exception {
        dao.excluir(t);
    }

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    public T carregar(PK id) throws Exception {
        return (T) dao.carregar(id);
    }

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    public T gerenciar(PK id) throws Exception {
        return (T) dao.gerenciar(id);
    }

    /**
     *
     * @param ordem
     * @return
     * @throws Exception
     */
    public List<T> listarTodos(String ordem) throws Exception {
        return dao.listarTodos(ordem);
    }
}
