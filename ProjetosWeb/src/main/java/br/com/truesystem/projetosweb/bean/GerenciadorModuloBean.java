package br.com.truesystem.projetosweb.bean;

import br.com.truesystem.projetosweb.dominio.gerenciador.Atividade;
import br.com.truesystem.projetosweb.dominio.gerenciador.Modulo;
import br.com.truesystem.projetosweb.servico.AtividadeServico;
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
public class GerenciadorModuloBean implements Serializable {

    private Modulo modulo;
    private List<Atividade> listaDeAtividades;
    @EJB
    private AtividadeServico atividadeServico;

    public void atualizar() {
        listaDeAtividades = atividadeServico.buscar(modulo);
    }

    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
        atualizar();
    }

    public List<Atividade> getListaDeAtividades() {
        return listaDeAtividades;
    }

    public void setListaDeAtividades(List<Atividade> listaDeAtividades) {
        this.listaDeAtividades = listaDeAtividades;
    }

}
