package br.com.truesystem.projetosweb.dao;

import br.com.truesystem.projetosweb.dominio.gerenciador.Atividade;
import br.com.truesystem.projetosweb.dominio.gerenciador.Funcionalidade;
import br.com.truesystem.projetosweb.dominio.gerenciador.FuncionalidadePK;
import br.com.truesystem.projetosweb.dominio.gerenciador.Funcionalidade_;
import br.com.truesystem.projetosweb.dominio.gerenciador.Modulo;
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
public class FuncionalidadeDao extends DAO<Funcionalidade, FuncionalidadePK> implements Serializable {

    public List<Funcionalidade> buscar(Atividade atividade) {
        return getSession().createCriteria(Funcionalidade.class).add(Restrictions.eq(Funcionalidade_.atividade.getName(), atividade)).list();
    }

    public Long maiorCodigo(Atividade atividade) {
        return (Long) getSession().createCriteria(Funcionalidade.class).add(Restrictions.eq(Funcionalidade_.atividade.getName(), atividade)).setProjection(Projections.count(Funcionalidade_.id.getName())).uniqueResult();
    }

    public void excluir(Atividade t) {
        getSession().createQuery("DELETE FROM Funcionalidade f WHERE f.atividade =:atividade").executeUpdate();
    }

    public void excluir(Projeto projeto) {
        getSession().createQuery("DELETE FROM Funcionalidade f WHERE f.atividade.modulo.projeto =:projeto").setParameter("projeto", projeto).executeUpdate();
    }

    public void excluir(Modulo modulo) {
        getSession().createQuery("DELETE FROM Funcionalidade f WHERE f.atividade.modulo =:modulo").setParameter("modulo", modulo).executeUpdate();
    }

}
