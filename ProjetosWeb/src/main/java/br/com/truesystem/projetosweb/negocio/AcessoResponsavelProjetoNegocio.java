package br.com.truesystem.projetosweb.negocio;

import br.com.truesystem.projetosweb.dao.AcessoResponsavelProjetoDao;
import br.com.truesystem.projetosweb.dominio.Responsavel;
import br.com.truesystem.projetosweb.dominio.gerenciador.AcessoResponsavelProjeto;
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
public class AcessoResponsavelProjetoNegocio implements NegocioInterface<AcessoResponsavelProjeto>, Serializable {

    @EJB
    private AcessoResponsavelProjetoDao dao;

    @Override
    public void excluir(AcessoResponsavelProjeto t) throws Exception {
        dao.excluir(t);
    }

    @Override
    public void atualizar(AcessoResponsavelProjeto t) throws Exception {
        dao.atualizar(t);
    }

    @Override
    public void salvar(AcessoResponsavelProjeto t) {
        dao.atualizar(t);
    }

    @Override
    public AcessoResponsavelProjeto carregar(Serializable pk) {
        return dao.carregar(AcessoResponsavelProjeto.class, pk);
    }

    public List<Responsavel> buscarResponsaveis(Projeto projeto) {
        return dao.buscarResponsaveis(projeto);
    }

    public List<AcessoResponsavelProjeto> buscar(Projeto projeto, Responsavel responsavel) {
        return dao.buscar(projeto, responsavel);
    }

    public List<Projeto> buscarProjetos(Responsavel responsavel) {
        return dao.buscarProjetos(responsavel);
    }

    public void excluir(Projeto t) {
        dao.excluir(t);
    }

}
