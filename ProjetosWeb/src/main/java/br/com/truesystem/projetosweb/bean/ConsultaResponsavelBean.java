package br.com.truesystem.projetosweb.bean;

import br.com.truesystem.projetosweb.dominio.Responsavel;
import br.com.truesystem.projetosweb.servico.ResponsavelServico;
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
public class ConsultaResponsavelBean extends BeanConsultaImplemente<Responsavel> implements Serializable {

    @EJB
    private ResponsavelServico servico;

    @Override
    public void busca() {
        setLista(servico.buscar());
    }

}
