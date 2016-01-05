package br.com.truesystem.projetosweb.bean;

import br.com.truesystem.projetosweb.dominio.gerenciador.Atividade;
import br.com.truesystem.projetosweb.dominio.gerenciador.Funcionalidade;
import br.com.truesystem.projetosweb.servico.AtividadeServico;
import br.com.truesystem.projetosweb.servico.FuncionalidadeServico;
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
public class CadastraFuncionalidadeBean extends BeanCadastroImplemente<Funcionalidade> implements Serializable {

    private Funcionalidade funcionalidade;
    @EJB
    private FuncionalidadeServico servico;

    @PostConstruct
    protected void init() {
        funcionalidade = new Funcionalidade();
    }

    @Override
    protected void salva() throws Exception {
        servico.salvar(funcionalidade);
    }

    @Override
    protected void valida() {
        // validar o login
    }

    @Override
    protected void exclui() throws Exception {
        servico.excluir(funcionalidade);
    }

    @Override
    public void limpar() {
        init();
    }

    @Override
    protected void atualiza() throws Exception {
        servico.atualizar(funcionalidade);
    }

    public Funcionalidade getFuncionalidade() {
        return funcionalidade;
    }

    public void setFuncionalidade(Funcionalidade funcionalidade) {
        this.funcionalidade = funcionalidade;
    }
}
