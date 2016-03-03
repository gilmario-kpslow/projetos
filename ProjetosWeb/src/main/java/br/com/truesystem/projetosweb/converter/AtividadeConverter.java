package br.com.truesystem.projetosweb.converter;

import br.com.truesystem.projetosweb.dominio.gerenciador.Atividade;
import br.com.truesystem.projetosweb.dominio.gerenciador.AtividadePK;
import br.com.truesystem.projetosweb.dominio.gerenciador.Modulo;
import br.com.truesystem.projetosweb.dominio.gerenciador.Projeto;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.Dependent;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;
import br.com.truesystem.projetosweb.negocio.AtividadeNegocio;
import br.com.truesystem.projetosweb.negocio.NegocioInterface;

/**
 *
 * @author gilmario
 */
@FacesConverter(value = "atividadeConverter")
@Named
@Dependent
public class AtividadeConverter extends DefaultConverter<Atividade> implements Serializable {

    @EJB
    private AtividadeNegocio negocio;

    @Override
    protected Serializable getChave(String value) {
        String[] codigos = value.split("-");
        return new AtividadePK(Long.parseLong(codigos[0]), new Modulo(Long.parseLong(codigos[1]), new Projeto(Long.parseLong(codigos[2]))));
    }

    @Override
    protected String getId(Object value) {
        Atividade a = (Atividade) value;
        return a.getCodigo().toString()
                .concat("-")
                .concat(a.getModulo().getCodigo().toString())
                .concat("-")
                .concat(a.getModulo().getProjeto().getId().toString());
    }

    @Override
    protected NegocioInterface<Atividade> getServico() {
        return negocio;
    }

}
