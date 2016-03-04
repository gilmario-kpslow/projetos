package br.com.truesystem.projetosweb.negocio;

import br.com.truesystem.projetosweb.dao.ProjetoDao;
import br.com.truesystem.projetosweb.dominio.Responsavel;
import br.com.truesystem.projetosweb.dominio.gerenciador.Projeto;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author gilmario
 */
@Stateless
@LocalBean
public class ProjetoNegocio implements NegocioInterface<Projeto>, Serializable {

    @EJB
    private ProjetoDao dao;

    @Override
    public void excluir(Projeto t) {
        dao.excluir(t);
    }

    public List<Projeto> buscar() {
        return dao.buscar();
    }

    public List<Projeto> buscar(Responsavel responsavel) {
        return dao.buscar(responsavel);
    }

    @Override
    public Projeto atualizar(Projeto t) {
        return dao.atualizar(t);
    }

    @Override
    public void salvar(Projeto t) {
        dao.salvar(t);
    }

    @Override
    public Projeto carregar(Serializable pk) {
        return dao.carregar(Projeto.class, pk);
    }

    @Override
    public void refresh(Projeto entidade) {
        dao.refresh(entidade);
    }

    @Override
    public Projeto gerenciar(Serializable pk) {
        return dao.gerenciar(Projeto.class, pk);
    }
}
