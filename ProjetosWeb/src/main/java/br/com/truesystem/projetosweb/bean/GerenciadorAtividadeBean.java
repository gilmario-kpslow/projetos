package br.com.truesystem.projetosweb.bean;

import br.com.truesystem.projetosweb.dominio.gerenciador.Atividade;
import br.com.truesystem.projetosweb.dominio.gerenciador.Funcionalidade;
import br.com.truesystem.projetosweb.negocio.FuncionalidadeNegocio;
import br.com.truesystem.projetosweb.negocio.RegraNegocioNegocio;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author gilmario
 */
@Named
@SessionScoped
public class GerenciadorAtividadeBean implements Serializable {

    private Atividade atividade;
    private List<Funcionalidade> listaDeFuncionalidades;
    @EJB
    private FuncionalidadeNegocio funcionalidadeServico;
    @EJB
    private RegraNegocioNegocio regraNegocioNegocio;

    public void atualizar() {
        listaDeFuncionalidades = funcionalidadeServico.buscar(atividade);
    }

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
        atualizar();
    }

    public List<Funcionalidade> getListaDeFuncionalidades() {
        return listaDeFuncionalidades;
    }

    public void setListaDeFuncionalidades(List<Funcionalidade> listaDeFuncionalidades) {
        this.listaDeFuncionalidades = listaDeFuncionalidades;
    }

    public BigDecimal getPercentual() {
        try {
            return regraNegocioNegocio.percentualConcluido(atividade);
        } catch (Exception e) {
            return BigDecimal.ZERO;
        }
    }

    public BigDecimal percentual(Funcionalidade f) {
        return regraNegocioNegocio.percentualConcluido(f);
    }
}
