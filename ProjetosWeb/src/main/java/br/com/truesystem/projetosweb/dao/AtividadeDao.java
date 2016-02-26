package br.com.truesystem.projetosweb.dao;

import br.com.truesystem.projetosweb.dominio.gerenciador.Atividade;
import br.com.truesystem.projetosweb.dominio.gerenciador.AtividadePK;
import br.com.truesystem.projetosweb.dominio.gerenciador.Modulo;
import br.com.truesystem.projetosweb.dominio.gerenciador.Atividade_;
import br.com.truesystem.projetosweb.dominio.gerenciador.Projeto;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author gilmario
 */
@Stateless
public class AtividadeDao extends DAO<Atividade, AtividadePK> implements Serializable {

    public List<Atividade> buscar(Modulo modulo) {
        return getSession().createCriteria(Atividade.class).add(Restrictions.eq(Atividade_.modulo.getName(), modulo)).addOrder(Order.asc(Atividade_.nome.getName())).list();
    }

    public Long maiorCodigo(Modulo modulo) {
        return (Long) getSession().createCriteria(Atividade.class).add(Restrictions.eq(Atividade_.modulo.getName(), modulo)).setProjection(Projections.count(Atividade_.codigo.getName())).uniqueResult();
    }

}
