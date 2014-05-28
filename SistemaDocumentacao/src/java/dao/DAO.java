/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author gilmario
 * @param <T>
 * @param <P>
 */
public abstract class DAO<T, P> implements Serializable {

    @PersistenceContext
    private EntityManager em;
    private Class<T> entityClass;

    public void salvar(T t) {
        em.persist(t);
    }

    public void delete(P p) {
        em.remove(carregar(p));
    }

    public T carregar(P p) {
        return em.find(entityClass, p);
    }

}
