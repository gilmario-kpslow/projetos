package br.com.truesystem.projetosweb.servico;

import br.com.truesystem.projetosweb.bean.GerenciadorModuloBean;
import br.com.truesystem.projetosweb.bean.GerenciadorProjetoBean;
import br.com.truesystem.projetosweb.dao.AtividadeDao;
import br.com.truesystem.projetosweb.dominio.gerenciador.Atividade;
import br.com.truesystem.projetosweb.dominio.gerenciador.Modulo;
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
public class AtividadeServico implements ServicoInterface<Atividade>, Serializable {

    @EJB
    private AtividadeDao dao;
    @Inject
    private GerenciadorModuloBean gmb;

    @Override
    public void excluir(Atividade t) throws Exception {
        dao.excluir(t);
    }

    public List<Atividade> buscar(Modulo modulo) {
        return dao.buscar(modulo);
    }

    @Override
    public void atualizar(Atividade t) throws Exception {
        dao.atualizar(t);
    }

    @Override
    public void salvar(Atividade t) {
        t.setCodigo(gerarCodigo());
        t.setModulo(gmb.getModulo());
        dao.atualizar(t);
    }

    @Override
    public Atividade carregar(Serializable pk) {
        return dao.carregar(Atividade.class, pk);
    }

    private Long gerarCodigo() {
        Long total = dao.maiorCodigo(gmb.getModulo());
        return ++total;
    }

}