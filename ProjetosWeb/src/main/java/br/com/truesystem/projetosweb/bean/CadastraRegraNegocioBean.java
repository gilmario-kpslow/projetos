package br.com.truesystem.projetosweb.bean;

import br.com.truesystem.projetosweb.dominio.gerenciador.RegraNegocio;
import br.com.truesystem.projetosweb.servico.RegraNegocioServico;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author gilmario
 */
@Named
@ViewScoped
public class CadastraRegraNegocioBean extends BeanCadastroImplemente<RegraNegocio> implements Serializable {

    private RegraNegocio regraNegocio;
    @EJB
    private RegraNegocioServico servico;

    @PostConstruct
    protected void init() {
        regraNegocio = new RegraNegocio();
    }

    @Override
    protected void salva() throws Exception {
        servico.salvar(regraNegocio);
    }

    @Override
    protected void valida() {
        // validar o login
    }

    @Override
    protected void exclui() throws Exception {
        servico.excluir(regraNegocio);
    }

    @Override
    public void limpar() {
        init();
    }

    @Override
    protected void atualiza() throws Exception {
        servico.atualizar(regraNegocio);
    }

    public RegraNegocio getRegraNegocio() {
        return regraNegocio;
    }

    public void setRegraNegocio(RegraNegocio regraNegocio) {
        this.regraNegocio = regraNegocio;
    }

}
