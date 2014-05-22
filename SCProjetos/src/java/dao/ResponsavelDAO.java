package dao;

import java.io.Serializable;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modelo.Responsavel;

/**
 *
 * @author gilmario
 */
@Stateless(name = "responsavelDAO")
public class ResponsavelDAO extends AbstractDAO<Responsavel> implements Serializable {

    @PersistenceContext(unitName = "SCProjetoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ResponsavelDAO() {
        super(Responsavel.class);
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Responsavel existe(Integer id) {
        return getEntityManager().createQuery("SELECT r FROM Responsavel r WHERE r.id =:id", Responsavel.class).setParameter("id", id).getSingleResult();
    }

    public Responsavel login(String nome, String senha) {
        Query q = getEntityManager().createQuery("SELECT r FROM Responsavel r WHERE r.nome =:nome AND r.senha =:senha");
        q.setParameter("nome", nome);
        q.setParameter("senha", senha);
        try {
            return (Responsavel) q.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

}
