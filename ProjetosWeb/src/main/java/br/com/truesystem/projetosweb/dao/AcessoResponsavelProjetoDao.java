package br.com.truesystem.projetosweb.dao;

import br.com.truesystem.projetosweb.dominio.Responsavel;
import br.com.truesystem.projetosweb.dominio.gerenciador.AcessoResponsavelProjeto;
import br.com.truesystem.projetosweb.dominio.gerenciador.AcessoResponsavelProjetoPK;
import br.com.truesystem.projetosweb.dominio.gerenciador.AcessoResponsavelProjeto_;
import br.com.truesystem.projetosweb.dominio.gerenciador.Projeto;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author gilmario
 */
@Stateless
public class AcessoResponsavelProjetoDao extends DAO<AcessoResponsavelProjeto, AcessoResponsavelProjetoPK> implements Serializable {

    public List<Projeto> buscarProjetos(Responsavel responsavel) {
        return getSession().createQuery("SELECT a.projeto FROM AcessoResponsavelProjeto a WHERE a.responsavel =:responsavel ")
                .setParameter("responsavel", responsavel)
                .list();
    }

    public List<Responsavel> buscarResponsaveis(Projeto projeto) {
        return getSession().createQuery("SELECT a.responsavel FROM AcessoResponsavelProjeto a WHERE a.projeto =:projeto ")
                .setParameter("projeto", projeto)
                .list();
    }

    public List<AcessoResponsavelProjeto> buscar(Projeto projeto, Responsavel responsavel) {
        Criteria criteria = getSession().createCriteria(AcessoResponsavelProjeto.class);
        if (projeto != null) {
            criteria.add(Restrictions.eq(AcessoResponsavelProjeto_.projeto.getName(), projeto));
        }
        if (responsavel != null) {
            criteria.add(Restrictions.eq(AcessoResponsavelProjeto_.responsavel.getName(), responsavel));
        }
        return criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }

    public void excluir(Projeto t) {
        getSession().createQuery("DELETE FROM AcessoResponsavelProjeto a WHERE a.projeto = :projeto").setParameter("projeto", t).executeUpdate();
    }
}
