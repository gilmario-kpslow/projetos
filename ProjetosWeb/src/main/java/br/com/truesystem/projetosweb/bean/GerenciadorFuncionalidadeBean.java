package br.com.truesystem.projetosweb.bean;

import br.com.truesystem.projetosweb.dominio.gerenciador.Funcionalidade;
import br.com.truesystem.projetosweb.dominio.gerenciador.RegraNegocio;
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
public class GerenciadorFuncionalidadeBean implements Serializable {

    private Funcionalidade funcionalidade;
    private List<RegraNegocio> listaDeRegraNegocio;
    @EJB
    private RegraNegocioNegocio regraNegocioServico;

    public void atualizar() {
        listaDeRegraNegocio = regraNegocioServico.buscar(funcionalidade);
    }

    public Funcionalidade getFuncionalidade() {
        return funcionalidade;
    }

    public void setFuncionalidade(Funcionalidade funcionalidade) {
        this.funcionalidade = funcionalidade;
        atualizar();
    }

    public List<RegraNegocio> getListaDeRegraNegocio() {
        return listaDeRegraNegocio;
    }

    public void setListaDeRegraNegocio(List<RegraNegocio> listaDeRegraNegocio) {
        this.listaDeRegraNegocio = listaDeRegraNegocio;
    }

    public BigDecimal getPercentual() {
        return regraNegocioServico.percentualConcluido(funcionalidade);
    }

}
