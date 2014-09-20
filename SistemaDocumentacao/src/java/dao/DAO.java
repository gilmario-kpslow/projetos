/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author gilmario
 * @param <T>
 * @param <P>
 */
public abstract class DAO<T, P> implements Serializable {

    @PersistenceContext(unitName = "DocProjectPU")
    private EntityManager em;
    private final Class<T> entityClass;

    public DAO(Class enClass) {
        this.entityClass = enClass;
    }

    public void salvar(T t) {
        em.persist(t);
    }

    public void delete(P p) {
        em.remove(carregar(p));
    }

    public T carregar(P p) {
        return em.find(entityClass, p);
    }

    public List<T> consultar() {
        return em.createQuery("SELECT p FROM Projeto p ORDER BY p.nome").getResultList();
    }

}
