package br.com.truesystem.projetosweb.dao;

import br.com.truesystem.projetosweb.dominio.gerenciador.Funcionalidade;
import br.com.truesystem.projetosweb.dominio.gerenciador.RegraNegocio;
import br.com.truesystem.projetosweb.dominio.gerenciador.RegraNegocioPK;
import br.com.truesystem.projetosweb.dominio.gerenciador.RegraNegocio_;
import java.io.Serializable;
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

}
