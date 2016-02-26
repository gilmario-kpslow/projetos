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

    public Long contar(Funcionalidade f) {
        return (Long) getSession().createCriteria(RegraNegocio.class)
                .add(Restrictions.eq(RegraNegocio_.funcionalidade.getName(), f))
                .setProjection(Projections.rowCount()).uniqueResult();
    }

    public void excluir(Projeto projeto) {
        getSession().createQuery("DELETE FROM RegraNegocio r WHERE r.funcionalidade.atividade.modulo.projeto =:projeto").setParameter("projeto", projeto).executeUpdate();
    }

    public void excluir(Atividade atividade) {
        getSession().createSQLQuery("DELETE FROM RegraNegocio r WHERE r.re_id IN  .funcionalidade.atividade =:atividade").setParameter("atividade", atividade).executeUpdate();
    }

    public void excluir(Modulo modulo) {
        getSession().createQuery("DELETE FROM RegraNegocio r WHERE r IN(SELECT re FROM RegraNegocio re WHERE re.funcionalidade.atividade.modulo=:modulo)").setParameter("modulo", modulo).executeUpdate();
    }

}
