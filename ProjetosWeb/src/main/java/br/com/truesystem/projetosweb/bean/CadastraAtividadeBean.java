package br.com.truesystem.projetosweb.bean;

import br.com.truesystem.projetosweb.dominio.gerenciador.Atividade;
import br.com.truesystem.projetosweb.negocio.AtividadeNegocio;
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
public class CadastraAtividadeBean extends BeanCadastroImplemente<Atividade> implements Serializable {

    private Atividade atividade;
    @EJB
    private AtividadeNegocio servico;
    @Inject
    private GerenciadorAtividadeBean gab;
    @Inject
    private GerenciadorModuloBean gmb;

    @PostConstruct
    protected void init() {
        if (gab.getAtividade() != null) {
            atividade = gab.getAtividade();
            gab.setAtividade(null);
            editando = true;
        } else {
            atividade = new Atividade();
        }
    }

    @Override
    protected void salva() throws Exception {
        servico.salvar(atividade);
    }

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

    @Override
    protected void valida() {
        // validar o login
    }

    @Override
    protected void exclui() throws Exception {
        servico.excluir(atividade);
    }

    @Override
    public void limpar() {
        init();
        gmb.atualizar();
    }

    @Override
    protected void atualiza() throws Exception {
        servico.atualizar(atividade);
    }

}
