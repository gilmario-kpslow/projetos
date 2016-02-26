package br.com.truesystem.projetosweb.bean;

import br.com.truesystem.projetosweb.dominio.gerenciador.Funcionalidade;
import br.com.truesystem.projetosweb.dominio.gerenciador.RegraNegocio;
import br.com.truesystem.projetosweb.negocio.RegraNegocioNegocio;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author gilmario
 */
@Named
@SessionScoped
public class GerenciadorRegraNegocioBean implements Serializable {

    private RegraNegocio regraNegocio;
    @EJB
    private RegraNegocioNegocio servico;

    public RegraNegocio getRegraNegocio() {
        return regraNegocio;
    }

    public void setRegraNegocio(RegraNegocio regraNegocio) {
        this.regraNegocio = regraNegocio;
    }

    public void mudaStatus(RegraNegocio regra) {
        try {
            regra.mudaStatus();
            servico.atualizar(regra);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
