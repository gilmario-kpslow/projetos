/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.dao;

import br.com.projeto.util.Pagina;
import br.com.projetos.interfaces.dao.DAOInterface;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author gilmario
 * @param <T>
 * @param <PK>
 */
public abstract class DAO<T, PK extends Serializable> implements DAOInterface<T, PK>, Serializable {

    @PersistenceContext(unitName = "WebServiceProjetosPU")
    private EntityManager manager;
    private final Class<T> entidadeClass;

    public DAO(Class classe) {
        this.entidadeClass = classe;
    }

    @Override
    public void salvar(T t) throws Exception {
        getManager().persist(t);
    }

    public T atualizar(T t) throws Exception {
        return (T) getManager().merge(t);
    }

    @Override
    public void excluir(PK pk) throws Exception {
        getManager().remove(referencia(pk));
    }

    @Override
    public T carregar(PK pk) throws Exception {
        return (T) getManager().find(getEntidadeClass(), pk);
    }

    @Override
    public T referencia(PK pk) throws Exception {
        return (T) getManager().getReference(getEntidadeClass(), pk);
    }

    public EntityManager getManager() {
        return manager;
    }

    public Class<T> getEntidadeClass() {
        return entidadeClass;
    }

    public List<T> listar(Pagina p) throws Exception {
        String sql = "SELECT t FROM " + getEntidadeClass().getName() + " t";
        return getManager().createQuery(sql).setFirstResult(p.getInicio()).setMaxResults(p.getQuantidade()).getResultList();
    }

    public List<T> listar(Integer inicio) throws Exception {
        String sql = "SELECT t FROM " + getEntidadeClass().getName() + " t";
        return getManager().createQuery(sql).setFirstResult(inicio).setMaxResults(100).getResultList();
    }

}
