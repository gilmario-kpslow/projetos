package br.com.truesystem.projetosweb.bean;

import br.com.truesystem.projetosweb.dominio.gerenciador.Modulo;
import br.com.truesystem.projetosweb.dominio.gerenciador.Projeto;
import br.com.truesystem.projetosweb.servico.ModuloServico;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author gilmario
 */
@Named
@SessionScoped
public class GerenciadorProjetoBean implements Serializable {

    private Projeto projeto;
    private List<Modulo> listaDeModulos;
    @EJB
    private ModuloServico moduloServico;

    public void atualizar() {
        listaDeModulos = moduloServico.buscar(projeto);
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
        atualizar();
    }

    public List<Modulo> getListaDeModulos() {
        return listaDeModulos;
    }

    public void setListaDeModulos(List<Modulo> listaDeModulos) {
        this.listaDeModulos = listaDeModulos;
    }

}
