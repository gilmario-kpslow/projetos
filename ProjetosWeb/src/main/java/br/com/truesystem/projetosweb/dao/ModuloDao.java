package br.com.truesystem.projetosweb.dao;

import br.com.truesystem.projetosweb.dominio.gerenciador.Modulo;
import br.com.truesystem.projetosweb.dominio.gerenciador.ModuloPK;
import br.com.truesystem.projetosweb.dominio.gerenciador.Modulo_;
import br.com.truesystem.projetosweb.dominio.gerenciador.Projeto;
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
public class ModuloDao extends DAO<Modulo, ModuloPK> implements Serializable {

    public List<Modulo> buscar(Projeto projeto) {
        return getSession().createCriteria(Modulo.class).add(Restrictions.eq(Modulo_.projeto.getName(), projeto)).list();
    }

    public Long maiorCodigo(Projeto projeto) {
        return (Long) getSession().createCriteria(Modulo.class).add(Restrictions.eq(Modulo_.projeto.getName(), projeto)).setProjection(Projections.count(Modulo_.codigo.getName())).uniqueResult();

    }

}
