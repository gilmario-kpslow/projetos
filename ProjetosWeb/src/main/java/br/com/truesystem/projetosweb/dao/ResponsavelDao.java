package br.com.truesystem.projetosweb.dao;

import br.com.truesystem.projetosweb.dominio.Responsavel;
import br.com.truesystem.projetosweb.dominio.Responsavel_;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author gilmario
 */
@Stateless
public class ResponsavelDao extends DAO<Responsavel, Long> implements Serializable {

    public List<Responsavel> buscar() {
        return getSession().createCriteria(Responsavel.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }

    public Responsavel buscarPor(String login, String senha) {
        return (Responsavel) getSession().createCriteria(Responsavel.class).add(Restrictions.eq("senha", senha)).add(Restrictions.eq("login", login)).uniqueResult();
    }

    public Responsavel buscarPor(String login) {
        return (Responsavel) getSession().createCriteria(Responsavel.class).add(Restrictions.eq("login", login)).uniqueResult();
    }

    public List<Responsavel> buscar(String nome) {
        return getSession().createCriteria(Responsavel.class).add(Restrictions.ilike(Responsavel_.nomeCompleto.getName(), nome, MatchMode.ANYWHERE)).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }

}
