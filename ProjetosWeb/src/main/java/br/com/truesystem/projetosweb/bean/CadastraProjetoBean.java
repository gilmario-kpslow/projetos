package br.com.truesystem.projetosweb.bean;

import br.com.truesystem.projetosweb.dominio.gerenciador.AcessoResponsavelProjeto;
import br.com.truesystem.projetosweb.dominio.gerenciador.Projeto;
import br.com.truesystem.projetosweb.facade.ProjetoFacade;
import br.com.truesystem.projetosweb.negocio.AcessoResponsavelProjetoNegocio;
import br.com.truesystem.projetosweb.negocio.ProjetoNegocio;
import br.com.truesystem.projetosweb.negocio.ResponsavelSession;
import java.io.Serializable;
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
public class CadastraProjetoBean extends BeanCadastroImplemente<Projeto> implements Serializable {

    private Projeto projeto;
    @EJB
    private ProjetoNegocio servico;
    @Inject
    private GerenciadorProjetoBean gpb;
    @EJB
    private ProjetoFacade projetoFacade;

    @PostConstruct
    protected void init() {
        if (gpb.getProjeto() != null) {
            projeto = gpb.getProjeto();
            gpb.setProjeto(null);
            editando = true;
        } else {
            projeto = new Projeto();
        }
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
        this.editando = true;
    }

    @Override
    protected void salva() throws Exception {
        projetoFacade.salvar(projeto);
    }

    @Override
    protected void valida() {
        // validar o login
    }

    @Override
    protected void exclui() throws Exception {
        projetoFacade.excluirProjeto(projeto);
    }

    @Override
    public void limpar() {
        init();
    }

    @Override
    protected void atualiza() throws Exception {
        servico.atualizar(projeto);
    }

}
