/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import dao.DAO;
import java.io.Serializable;

/**
 *
 * @author gilmario
 * @param <T>
 * @param <P>
 */
public abstract class Controller<T, P> implements Serializable {

    protected abstract void init();

    protected void setDao(DAO dao) {
        this.dao = dao;
    }

    private DAO<T, P> dao;

    public void salvar(T t) {
        this.dao.salvar(t);
    }

}
