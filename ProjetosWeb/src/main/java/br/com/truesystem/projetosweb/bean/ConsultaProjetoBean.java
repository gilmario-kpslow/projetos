package br.com.truesystem.projetosweb.bean;

import br.com.truesystem.projetosweb.dominio.gerenciador.Projeto;
import br.com.truesystem.projetosweb.negocio.ProjetoNegocio;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author gilmario
 */
@Named
@ViewScoped
public class ConsultaProjetoBean extends BeanConsultaImplemente<Projeto> implements Serializable {

    @EJB
    private ProjetoNegocio servico;

    @Override
    public void busca() {
        setLista(servico.buscar());
    }

}
