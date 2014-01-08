/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Responsavel;

/**
 *
 * @author gilmario
 */
@Stateless
public class ResponsavelDAO extends AbstractDAO<Responsavel> implements Serializable {

    public ResponsavelDAO() {
        super(Responsavel.class);
    }

    @PersistenceContext(unitName = "ControleSolicitacoesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Responsavel login(String nome, String senha) {
        return getEntityManager().createQuery("SELECT r FROM Responsavel r WHERE r.nome =:nome AND r.senha =:senha", Responsavel.class).setParameter("nome", nome).setParameter("senha", senha).getSingleResult();
    }

}
