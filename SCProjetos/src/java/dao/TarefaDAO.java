package dao;

import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Modulo;
import modelo.Tarefa;

/**
 *
 * @author gilmario
 */
@Stateless
public class TarefaDAO extends AbstractDAO<Tarefa> implements Serializable {

    public TarefaDAO() {
        super(Tarefa.class);
    }

    public List<Tarefa> pegarTarefas(Modulo m) {
        return getEntityManager().createQuery("SELECT t FROM Tarefa t WHERE t.modulo =:modulo").setParameter("modulo", m).getResultList();
    }
}
