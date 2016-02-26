package br.com.truesystem.projetosweb.negocio;

import br.com.truesystem.projetosweb.bean.GerenciadorAtividadeBean;
import br.com.truesystem.projetosweb.dao.FuncionalidadeDao;
import br.com.truesystem.projetosweb.dominio.gerenciador.Atividade;
import br.com.truesystem.projetosweb.dominio.gerenciador.Funcionalidade;
import br.com.truesystem.projetosweb.dominio.gerenciador.Modulo;
import br.com.truesystem.projetosweb.dominio.gerenciador.Projeto;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author gilmario
 */
@Stateless
@LocalBean
public class FuncionalidadeNegocio implements NegocioInterface<Funcionalidade>, Serializable {

    @EJB
    private FuncionalidadeDao dao;
    @Inject
    private GerenciadorAtividadeBean gab;
    @EJB
    private RegraNegocioNegocio regraNegocioNegocio;

    @Override
    public void excluir(Funcionalidade funcionalidade) throws Exception {
        regraNegocioNegocio.excluir(funcionalidade);
        dao.excluir(funcionalidade);
    }

    public List<Funcionalidade> buscar(Atividade atividade) {
        return dao.buscar(atividade);
    }

    @Override
    public void atualizar(Funcionalidade t) throws Exception {
        dao.atualizar(t);
    }

    @Override
    public void salvar(Funcionalidade t) {
        t.setId(gerarCodigo());
        t.setAtividade(gab.getAtividade());
        dao.atualizar(t);
    }

    @Override
    public Funcionalidade carregar(Serializable pk) {
        return dao.carregar(Funcionalidade.class, pk);
    }

    private Long gerarCodigo() {
        Long total = dao.maiorCodigo(gab.getAtividade());
        return ++total;
    }

    public void excluir(Atividade t) {
        dao.excluir(t);
    }

    public void excluir(Projeto projeto) {
        dao.excluir(projeto);
    }

    public void excluir(Modulo modulo) {
        dao.excluir(modulo);
    }

}
