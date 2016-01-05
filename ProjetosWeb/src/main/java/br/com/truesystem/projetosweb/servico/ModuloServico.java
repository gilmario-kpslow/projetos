package br.com.truesystem.projetosweb.servico;

import br.com.truesystem.projetosweb.bean.GerenciadorProjetoBean;
import br.com.truesystem.projetosweb.dao.ModuloDao;
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
public class ModuloServico implements ServicoInterface<Modulo>, Serializable {

    @EJB
    private ModuloDao dao;
    @Inject
    private GerenciadorProjetoBean gpb;

    @Override
    public void excluir(Modulo t) throws Exception {
        dao.excluir(t);
    }

    public List<Modulo> buscar(Projeto projeto) {
        return dao.buscar(projeto);
    }

    @Override
    public void atualizar(Modulo t) throws Exception {
        dao.atualizar(t);
    }

    @Override
    public void salvar(Modulo t) {
        t.setCodigo(gerarCodigo());
        t.setProjeto(gpb.getProjeto());
        dao.atualizar(t);
    }

    @Override
    public Modulo carregar(Serializable pk) {
        return dao.carregar(Modulo.class, pk);
    }

    private Long gerarCodigo() {
        Long total = dao.maiorCodigo(gpb.getProjeto());
        return ++total;
    }

}
