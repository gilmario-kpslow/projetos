package br.com.truesystem.projetosweb.servico;

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
public class FuncionalidadeServico implements ServicoInterface<Funcionalidade>, Serializable {

    @EJB
    private FuncionalidadeDao dao;
    @Inject
    private GerenciadorAtividadeBean gab;

    @Override
    public void excluir(Funcionalidade t) throws Exception {
        dao.excluir(t);
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

}
