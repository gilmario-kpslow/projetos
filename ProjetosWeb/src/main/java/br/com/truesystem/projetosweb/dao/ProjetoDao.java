package br.com.truesystem.projetosweb.dao;

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

}
