package br.com.truesystem.projetosweb.bean;

import br.com.truesystem.projetosweb.dominio.gerenciador.Projeto;
import br.com.truesystem.projetosweb.servico.ProjetoServico;
import br.com.truesystem.projetosweb.servico.ResponsavelSession;
import java.io.Serializable;
import java.util.List;
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
public class DashBoardBean implements Serializable {

    private List<Projeto> listaDeProjetos;
    @Inject
    private ResponsavelSession responsavelSession;
    @EJB
    private ProjetoServico projetoServico;

    @PostConstruct
    private void iniciar() {
        listaDeProjetos = projetoServico.buscar();
    }

    public List<Projeto> getListaDeProjetos() {
        return listaDeProjetos;
    }

    public void setListaDeProjetos(List<Projeto> listaDeProjetos) {
        this.listaDeProjetos = listaDeProjetos;
    }

}
