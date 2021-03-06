package br.com.truesystem.projetosweb.dao;

import br.com.truesystem.projetosweb.dominio.gerenciador.Atividade;
import br.com.truesystem.projetosweb.dominio.gerenciador.Funcionalidade;
import br.com.truesystem.projetosweb.dominio.gerenciador.Modulo;
import br.com.truesystem.projetosweb.dominio.gerenciador.Projeto;
import br.com.truesystem.projetosweb.dominio.gerenciador.RegraNegocio;
import br.com.truesystem.projetosweb.dominio.gerenciador.RegraNegocioPK;
import br.com.truesystem.projetosweb.dominio.gerenciador.RegraNegocio_;
import br.com.truesystem.projetosweb.dominio.gerenciador.StatusRegraNegocio;
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
public class RegraNegocioDao extends DAO<RegraNegocio, RegraNegocioPK> implements Serializable {

    public List<RegraNegocio> buscar(Funcionalidade funcionalidade) {
        return getSession().createCriteria(RegraNegocio.class).add(Restrictions.eq(RegraNegocio_.funcionalidade.getName(), funcionalidade)).list();
    }

    public Long maiorCodigo(Funcionalidade funcionalidade) {
        return (Long) getSession().createCriteria(RegraNegocio.class).add(Restrictions.eq(RegraNegocio_.funcionalidade.getName(), funcionalidade)).setProjection(Projections.count(RegraNegocio_.id.getName())).uniqueResult();
    }

    public void excluir(Funcionalidade funcionalidade) {
        getSession().createQuery("DELETE FROM RegraNegocio r WHERE r.funcionalidade =:funcionalidade").setParameter("funcionalidade", funcionalidade).executeUpdate();
    }

    public BigDecimal concluidos(Funcionalidade f) {
        return new BigDecimal((Long) getSession().createCriteria(RegraNegocio.class)
                .add(Restrictions.eq(RegraNegocio_.status.getName(), StatusRegraNegocio.Concluida))
                .add(Restrictions.eq(RegraNegocio_.funcionalidade.getName(), f))
                .setProjection(Projections.rowCount()).uniqueResult());
    }

    public BigDecimal naoConcluidas(Funcionalidade f) {
        return new BigDecimal((Long) getSession().createCriteria(RegraNegocio.class)
                .add(Restrictions.ne(RegraNegocio_.status.getName(), StatusRegraNegocio.Concluida))
                .add(Restrictions.eq(RegraNegocio_.funcionalidade.getName(), f))
                .setProjection(Projections.rowCount()).uniqueResult());
    }

    public BigDecimal concluidas(Funcionalidade f) {
        return new BigDecimal((Long) getSession().createCriteria(RegraNegocio.class)
                .add(Restrictions.eq(RegraNegocio_.status.getName(), StatusRegraNegocio.Concluida))
                .add(Restrictions.eq(RegraNegocio_.funcionalidade.getName(), f))
                .setProjection(Projections.rowCount()).uniqueResult());
    }

    public BigDecimal concluidas(Atividade a) {
        return new BigDecimal((Long) getSession().createQuery("SELECT COUNT(r) FROM RegraNegocio r WHERE r.funcionalidade.atividade =:a AND r.status =:status")
                .setParameter("a", a)
                .setParameter("status", StatusRegraNegocio.Concluida)
                .uniqueResult());
    }

    public BigDecimal concluidas(Modulo m) {
        return new BigDecimal((Long) getSession().createQuery("SELECT COUNT(r) FROM RegraNegocio r WHERE r.funcionalidade.atividade.modulo =:m AND r.status =:status")
                .setParameter("m", m)
                .setParameter("status", StatusRegraNegocio.Concluida)
                .uniqueResult());
    }

    public BigDecimal concluidas(Projeto p) {
        return new BigDecimal((Long) getSession().createQuery("SELECT COUNT(r) FROM RegraNegocio r WHERE r.funcionalidade.atividade.modulo.projeto =:p AND r.status =:status")
                .setParameter("p", p)
                .setParameter("status", StatusRegraNegocio.Concluida)
                .uniqueResult());
    }

    public Long contar(Funcionalidade f) {
        return (Long) getSession().createCriteria(RegraNegocio.class)
                .add(Restrictions.eq(RegraNegocio_.funcionalidade.getName(), f))
                .setProjection(Projections.rowCount()).uniqueResult();
    }

    public BigDecimal contar(Atividade a) {
        return new BigDecimal((Long) getSession().createQuery("SELECT COUNT(r) FROM RegraNegocio r WHERE r.funcionalidade.atividade =:a")
                .setParameter("a", a)
                .uniqueResult());
    }

    public BigDecimal contar(Modulo a) {
        return new BigDecimal((Long) getSession().createQuery("SELECT COUNT(r) FROM RegraNegocio r WHERE r.funcionalidade.atividade.modulo =:a")
                .setParameter("a", a)
                .uniqueResult());
    }

    public BigDecimal contar(Projeto a) {
        return new BigDecimal((Long) getSession().createQuery("SELECT COUNT(r) FROM RegraNegocio r WHERE r.funcionalidade.atividade.modulo.projeto =:a")
                .setParameter("a", a)
                .uniqueResult());
    }

    public List<RegraNegocio> buscar(Projeto projeto, StatusRegraNegocio statusRegraNegocio) {
        return getSession().createQuery("SELECT r FROM RegraNegocio r WHERE r.status = :status AND r.funcionalidade.atividade.modulo.projeto =:projeto").setParameter("projeto", projeto).setParameter("status", statusRegraNegocio).list();
    }

    public List<RegraNegocio> buscar(Modulo modulo, StatusRegraNegocio statusRegraNegocio) {
        return getSession().createQuery("SELECT r FROM RegraNegocio r WHERE r.status = :status AND r.funcionalidade.atividade.modulo =:modulo").setParameter("modulo", modulo).setParameter("status", statusRegraNegocio).list();
    }

    public List<RegraNegocio> buscar(Atividade atividade, StatusRegraNegocio statusRegraNegocio) {
        return getSession().createQuery("SELECT r FROM RegraNegocio r WHERE r.status = :status AND r.funcionalidade.atividade =:atividade").setParameter("atividade", atividade).setParameter("status", statusRegraNegocio).list();
    }

    public List<RegraNegocio> buscar(Funcionalidade funcionalidade, StatusRegraNegocio statusRegraNegocio) {
        return getSession().createQuery("SELECT r FROM RegraNegocio r WHERE r.status = :status AND r.funcionalidade =:funcionalidade").setParameter("funcionalidade", funcionalidade).setParameter("status", statusRegraNegocio).list();
    }

}
