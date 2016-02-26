package br.com.truesystem.projetosweb.bean;

import br.com.truesystem.projetosweb.dominio.gerenciador.Atividade;
import br.com.truesystem.projetosweb.dominio.gerenciador.Funcionalidade;
import br.com.truesystem.projetosweb.dominio.gerenciador.Modulo;
import br.com.truesystem.projetosweb.negocio.AtividadeNegocio;
import br.com.truesystem.projetosweb.negocio.FuncionalidadeNegocio;
import java.io.Serializable;
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

}
