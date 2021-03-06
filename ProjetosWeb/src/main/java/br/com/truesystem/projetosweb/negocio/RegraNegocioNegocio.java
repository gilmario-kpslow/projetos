package br.com.truesystem.projetosweb.negocio;

import br.com.truesystem.projetosweb.bean.GerenciadorFuncionalidadeBean;
import br.com.truesystem.projetosweb.dao.RegraNegocioDao;
import br.com.truesystem.projetosweb.dominio.gerenciador.Atividade;
import br.com.truesystem.projetosweb.dominio.gerenciador.Funcionalidade;
import br.com.truesystem.projetosweb.dominio.gerenciador.Modulo;
import br.com.truesystem.projetosweb.dominio.gerenciador.Projeto;
import br.com.truesystem.projetosweb.dominio.gerenciador.RegraNegocio;
import br.com.truesystem.projetosweb.dominio.gerenciador.StatusRegraNegocio;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
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
public class RegraNegocioNegocio implements NegocioInterface<RegraNegocio>, Serializable {

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
    public RegraNegocio atualizar(RegraNegocio t) {
        return dao.atualizar(t);
    }

    @Override
    public void salvar(RegraNegocio t) {
        if (t.getId() == null) {
            t.setId(gerarCodigo());
            t.setFuncionalidade(gfb.getFuncionalidade());
            dao.atualizar(t);
        } else {
            atualizar(t);
        }
    }

    @Override
    public RegraNegocio carregar(Serializable pk) {
        return dao.carregar(RegraNegocio.class, pk);
    }

    private Long gerarCodigo() {
        Long total = dao.maiorCodigo(gfb.getFuncionalidade());
        return ++total;
    }

    public void excluir(Funcionalidade t) {
        dao.excluir(t);
    }

    public BigDecimal regrasTotais(Funcionalidade f) {
        Long total = dao.contar(f);
        if (total == null) {
            total = 0L;
        }
        return new BigDecimal(total);
    }

    public BigDecimal percentualConcluido(Funcionalidade funcionalidade) {
        try {
            return dao.concluidas(funcionalidade).divide(regrasTotais(funcionalidade), 2, RoundingMode.CEILING);
        } catch (ArithmeticException e) {
            return BigDecimal.ZERO;
        }
    }

    public BigDecimal percentualConcluido(Atividade atividade) {
        try {
            return dao.concluidas(atividade).divide(dao.contar(atividade), 2, RoundingMode.CEILING);
        } catch (ArithmeticException e) {
            return BigDecimal.ZERO;
        }
    }

    public BigDecimal percentualConcluido(Modulo modulo) {
        try {
            return dao.concluidas(modulo).divide(dao.contar(modulo), 2, RoundingMode.CEILING);
        } catch (ArithmeticException e) {
            return BigDecimal.ZERO;
        }
    }

    public BigDecimal percentualConcluido(Projeto projeto) {
        try {
            return dao.concluidas(projeto).divide(dao.contar(projeto), 2, RoundingMode.CEILING);
        } catch (ArithmeticException e) {
            return BigDecimal.ZERO;
        }
    }

    public List<RegraNegocio> regrasPendentes(Projeto projeto, Modulo modulo, Atividade atividade, Funcionalidade funcionalidade) {
        return listarPor(projeto, modulo, atividade, funcionalidade, StatusRegraNegocio.Pendente);
    }

    public List<RegraNegocio> regrasEmAndamento(Projeto projeto, Modulo modulo, Atividade atividade, Funcionalidade funcionalidade) {
        return listarPor(projeto, modulo, atividade, funcionalidade, StatusRegraNegocio.Andamento);
    }

    public List<RegraNegocio> regrasConcluidas(Projeto projeto, Modulo modulo, Atividade atividade, Funcionalidade funcionalidade) {
        return listarPor(projeto, modulo, atividade, funcionalidade, StatusRegraNegocio.Concluida);
    }

    private List<RegraNegocio> listarPor(Projeto projeto, Modulo modulo, Atividade atividade, Funcionalidade funcionalidade, StatusRegraNegocio statusRegraNegocio) {
        if (funcionalidade != null) {
            return dao.buscar(funcionalidade, statusRegraNegocio);
        } else if (atividade != null) {
            return dao.buscar(atividade, statusRegraNegocio);
        } else if (modulo != null) {
            return dao.buscar(modulo, statusRegraNegocio);
        } else if (projeto != null) {
            return dao.buscar(projeto, statusRegraNegocio);
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public void refresh(RegraNegocio regraNegocio) {
        dao.refresh(regraNegocio);
    }

    @Override
    public RegraNegocio gerenciar(Serializable pk) {
        return dao.gerenciar(RegraNegocio.class, pk);
    }

}
