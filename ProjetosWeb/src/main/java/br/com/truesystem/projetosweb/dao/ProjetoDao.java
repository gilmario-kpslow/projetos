package br.com.truesystem.projetosweb.dao;

import br.com.truesystem.projetosweb.dominio.Responsavel;
import br.com.truesystem.projetosweb.dominio.gerenciador.Projeto;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author gilmario
 */
@Stateless
public class ProjetoDao extends DAO<Projeto, Long> implements Serializable {

    public List<Projeto> buscar() {
        return getSession().createCriteria(Projeto.class).list();
    }

    public List<Projeto> buscar(Responsavel responsavel) {
        return getSession().createQuery("SELECT a.projeto FROM AcessoResponsavelProjeto a WHERE a.responsavel =:responsavel").setParameter("responsavel", responsavel).list();
    }

}
