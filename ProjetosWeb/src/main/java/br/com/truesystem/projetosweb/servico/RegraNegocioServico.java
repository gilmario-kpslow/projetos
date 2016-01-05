package br.com.truesystem.projetosweb.servico;

import br.com.truesystem.projetosweb.bean.GerenciadorFuncionalidadeBean;
import br.com.truesystem.projetosweb.dao.RegraNegocioDao;
import br.com.truesystem.projetosweb.dominio.gerenciador.Funcionalidade;
import br.com.truesystem.projetosweb.dominio.gerenciador.RegraNegocio;
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
public class RegraNegocioServico implements ServicoInterface<RegraNegocio>, Serializable {

    @EJB
    private RegraNegocioDao dao;
    @Inject
    private GerenciadorFuncionalidadeBean gfb;

    @Override
    public void excluir(RegraNegocio t) throws Exception {
        dao.excluir(t);
    }

    public List<RegraNegocio> buscar(Funcionalidade funcionalidade) {
        return dao.buscar(funcionalidade);
    }

    @Override
    public void atualizar(RegraNegocio t) throws Exception {
        dao.atualizar(t);
    }

    @Override
    public void salvar(RegraNegocio t) {
        t.setId(gerarCodigo());
        t.setFuncionalidade(gfb.getFuncionalidade());
        dao.atualizar(t);
    }

    @Override
    public RegraNegocio carregar(Serializable pk) {
        return dao.carregar(RegraNegocio.class, pk);
    }

    private Long gerarCodigo() {
        Long total = dao.maiorCodigo(gfb.getFuncionalidade());
        return ++total;
    }

}
