package br.com.truesystem.projetosweb.negocio;

import br.com.truesystem.projetosweb.bean.GerenciadorAtividadeBean;
import br.com.truesystem.projetosweb.dao.FuncionalidadeDao;
import br.com.truesystem.projetosweb.dominio.gerenciador.Atividade;
import br.com.truesystem.projetosweb.dominio.gerenciador.Funcionalidade;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
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

    public BigDecimal percentualConcluido(Atividade atividade) {
        return funcionalidadesConcluidas(atividade).divide(funcionalidadesTotais(atividade), 4, RoundingMode.CEILING);
    }

    private BigDecimal funcionalidadesConcluidas(Atividade atividade) {
        BigDecimal totais = dao.concluidas(atividade);
        if (totais == null) {
            return BigDecimal.ZERO;
        }
        return totais;
    }

    private BigDecimal funcionalidadesTotais(Atividade atividade) {
        BigDecimal totais = dao.contar(atividade);
        if (totais == null) {
            return BigDecimal.ZERO;
        }
        return totais;
    }

}
