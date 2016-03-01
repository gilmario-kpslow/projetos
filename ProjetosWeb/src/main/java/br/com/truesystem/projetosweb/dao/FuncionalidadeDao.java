package br.com.truesystem.projetosweb.dao;

import br.com.truesystem.projetosweb.dominio.gerenciador.Atividade;
import br.com.truesystem.projetosweb.dominio.gerenciador.Funcionalidade;
import br.com.truesystem.projetosweb.dominio.gerenciador.FuncionalidadePK;
import br.com.truesystem.projetosweb.dominio.gerenciador.Funcionalidade_;
import br.com.truesystem.projetosweb.dominio.gerenciador.StatusFuncionalidade;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author gilmario
 */
@Stateless
public class FuncionalidadeDao extends DAO<Funcionalidade, FuncionalidadePK> implements Serializable {

    public List<Funcionalidade> buscar(Atividade atividade) {
        return getSession().createCriteria(Funcionalidade.class).add(Restrictions.eq(Funcionalidade_.atividade.getName(), atividade)).list();
    }

    public Long maiorCodigo(Atividade atividade) {
        return (Long) getSession().createCriteria(Funcionalidade.class).add(Restrictions.eq(Funcionalidade_.atividade.getName(), atividade)).setProjection(Projections.count(Funcionalidade_.id.getName())).uniqueResult();
    }

    public BigDecimal concluidas(Atividade atividade) {
        return new BigDecimal((Long) getSession().createCriteria(Funcionalidade.class)
                .add(Restrictions.eq(Funcionalidade_.status.getName(), StatusFuncionalidade.Concluida))
                .add(Restrictions.eq(Funcionalidade_.atividade.getName(), atividade))
                .setProjection(Projections.rowCount()).uniqueResult());

    }

    public BigDecimal contar(Atividade atividade) {
        return new BigDecimal((Long) getSession().createCriteria(Funcionalidade.class)
                .add(Restrictions.eq(Funcionalidade_.atividade.getName(), atividade))
                .setProjection(Projections.rowCount()).uniqueResult());
    }
}
