package br.com.truesystem.projetosweb.bean;

import br.com.truesystem.projetosweb.dominio.gerenciador.AcessoResponsavelProjeto;
import br.com.truesystem.projetosweb.dominio.gerenciador.AcessoResponsavelProjetoPK;
import br.com.truesystem.projetosweb.dominio.gerenciador.Projeto;
import br.com.truesystem.projetosweb.negocio.AcessoResponsavelProjetoNegocio;
import br.com.truesystem.projetosweb.negocio.ProjetoNegocio;
import br.com.truesystem.projetosweb.negocio.RegraNegocioNegocio;
import br.com.truesystem.projetosweb.negocio.ResponsavelSession;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author gilmario
 */
@Named
@ViewScoped
public class DashBoardBean implements Serializable {

    private List<Projeto> listaDeProjetos;
    @EJB
    private ProjetoNegocio projetoServico;
    @EJB
    private RegraNegocioNegocio regraNegocioNegocio;
    @EJB
    private AcessoResponsavelProjetoNegocio acessoResponsavelProjetoNegocio;
    @Inject
    private ResponsavelSession responsavelSession;

    @PostConstruct
    private void iniciar() {
        listaDeProjetos = projetoServico.buscar(responsavelSession.getResponsavel());
    }

    public Boolean getDono(Projeto p) {
        return acessoResponsavelProjetoNegocio.carregar(new AcessoResponsavelProjetoPK(responsavelSession.getResponsavel(), p)).getDono();
    }

    public List<Projeto> getListaDeProjetos() {
        return listaDeProjetos;
    }

    public void setListaDeProjetos(List<Projeto> listaDeProjetos) {
        this.listaDeProjetos = listaDeProjetos;
    }

    public BigDecimal getPercentual(Projeto projeto) {
        try {
            return regraNegocioNegocio.percentualConcluido(projeto);
        } catch (ArithmeticException e) {
            return BigDecimal.ZERO;
        }
    }

}
