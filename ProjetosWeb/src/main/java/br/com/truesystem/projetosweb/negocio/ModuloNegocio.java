package br.com.truesystem.projetosweb.negocio;

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
public class ModuloNegocio implements NegocioInterface<Modulo>, Serializable {

    @EJB
    private ModuloDao dao;
    @Inject
    private GerenciadorProjetoBean gpb;

    @Override
    public void excluir(Modulo modulo) throws Exception {
        dao.excluir(modulo);
    }

    public List<Modulo> buscar(Projeto projeto) {
        return dao.buscar(projeto);
    }

    @Override
    public Modulo atualizar(Modulo t) throws Exception {
        return dao.atualizar(t);
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

    @Override
    public void refresh(Modulo entidade) {
        dao.refresh(entidade);
    }

    @Override
    public Modulo gerenciar(Serializable pk) {
        return dao.gerenciar(Modulo.class, pk);
    }

}
