package br.com.truesystem.projetosweb.bean;

import br.com.truesystem.projetosweb.dominio.Responsavel;
import br.com.truesystem.projetosweb.dominio.gerenciador.Projeto;
import br.com.truesystem.projetosweb.servico.ProjetoServico;
import br.com.truesystem.projetosweb.servico.ResponsavelServico;
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
public class CadastraProjetoBean extends BeanCadastroImplemente<Projeto> implements Serializable {

    private Projeto projeto;
    @EJB
    private ProjetoServico servico;

    @PostConstruct
    protected void init() {
        projeto = new Projeto();
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    @Override
    protected void salva() throws Exception {
        servico.salvar(projeto);
    }

    @Override
    protected void valida() {
        // validar o login
    }

    @Override
    protected void exclui() throws Exception {
        servico.excluir(projeto);
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
