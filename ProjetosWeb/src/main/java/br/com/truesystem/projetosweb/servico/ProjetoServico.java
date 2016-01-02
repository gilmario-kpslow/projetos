package br.com.truesystem.projetosweb.servico;

import br.com.truesystem.projetosweb.dao.ProjetoDao;
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
public class ProjetoServico implements ServicoInterface<Projeto>, Serializable {

    @EJB
    private ProjetoDao dao;

    @Override
    public void excluir(Projeto t) throws Exception {
        dao.excluir(t);
    }

    public List<Projeto> buscar() {
        return dao.buscar();
    }

    @Override
    public void atualizar(Projeto t) throws Exception {
        dao.atualizar(t);
    }

    @Override
    public void salvar(Projeto t) {
        dao.atualizar(t);
    }

    @Override
    public Projeto carregar(Serializable pk) {
        return dao.carregar(Projeto.class, pk);
    }

}
