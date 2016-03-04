package br.com.truesystem.projetosweb.dao;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Session;

/**
 *
 * @author gilmario
 * @param <T>
 * @param <PK>
 */
public abstract class DAO<T, PK extends Serializable> implements Serializable {

    @PersistenceContext
    private EntityManager manager;

    public Session getSession() {
        return (Session) manager.getDelegate();
    }

    public void salvar(T t) {
        getSession().save(t);
    }

    public T atualizar(T t) {
        return (T) getSession().merge(t);
    }

    public void excluir(T t) {
        getSession().refresh(t);
        getSession().delete(t);
    }

    public T carregar(Class<T> entidade, Serializable pk) {
        return (T) getSession().get(entidade, pk);
    }

    public T gerenciar(Class<T> entidade, Serializable pk) {
        return (T) getSession().load(entidade, pk);
    }

    public void refresh(T entidade) {
        getSession().refresh(entidade);
    }
}
