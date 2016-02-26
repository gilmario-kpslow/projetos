package br.com.truesystem.projetosweb.bean;

import br.com.truesystem.projetosweb.dominio.Responsavel;
import br.com.truesystem.projetosweb.negocio.ResponsavelNegocio;
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
public class CadastraResponsavelBean extends BeanCadastroImplemente<Responsavel> implements Serializable {

    private Responsavel responsavel;
    @EJB
    private ResponsavelNegocio servico;

    @PostConstruct
    protected void init() {
        responsavel = new Responsavel();
    }

    public Responsavel getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    }

    @Override
    protected void salva() throws Exception {
        servico.salvar(responsavel);
    }

    @Override
    protected void valida() {
        // validar o login
    }

    @Override
    protected void exclui() throws Exception {
        servico.excluir(responsavel);
    }

    @Override
    public void limpar() {
        init();
    }

    @Override
    protected void atualiza() throws Exception {
        servico.atualizar(responsavel);
    }

}
