package br.com.truesystem.projetosweb.negocio;

import br.com.truesystem.projetosweb.bean.GerenciadorAtividadeBean;
import br.com.truesystem.projetosweb.dao.FuncionalidadeDao;
import br.com.truesystem.projetosweb.dominio.gerenciador.Atividade;
import br.com.truesystem.projetosweb.dominio.gerenciador.Funcionalidade;
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

    @Override
    public void excluir(Funcionalidade funcionalidade) throws Exception {
        dao.excluir(funcionalidade);
    }

    public List<Funcionalidade> buscar(Atividade atividade) {
        return dao.buscar(atividade);
    }

    @Override
    public Funcionalidade atualizar(Funcionalidade t) throws Exception {
        return dao.atualizar(t);
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

    @Override
    public void refresh(Funcionalidade entidade) {
        dao.refresh(entidade);
    }

    @Override
    public Funcionalidade gerenciar(Serializable pk) {
        return dao.gerenciar(Funcionalidade.class, pk);
    }

}
