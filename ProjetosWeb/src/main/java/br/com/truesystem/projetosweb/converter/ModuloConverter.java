package br.com.truesystem.projetosweb.converter;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.Dependent;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;
import br.com.truesystem.projetosweb.dominio.gerenciador.Modulo;
import br.com.truesystem.projetosweb.dominio.gerenciador.ModuloPK;
import br.com.truesystem.projetosweb.dominio.gerenciador.Projeto;
import br.com.truesystem.projetosweb.negocio.ModuloNegocio;
import br.com.truesystem.projetosweb.negocio.NegocioInterface;

/**
 *
 * @author gilmario
 */
@FacesConverter(value = "moduloConverter")
@Named
@Dependent
public class ModuloConverter extends DefaultConverter<Modulo> implements Serializable {

    @EJB
    private ModuloNegocio negocio;

    @Override
    protected Serializable getChave(String value) {
        String[] codes = value.split("-");
        return new ModuloPK(Long.parseLong(codes[0]), new Projeto(Long.parseLong(codes[1])));
    }

    @Override
    protected String getId(Object value) {
        Modulo m = (Modulo) value;
        return m.getCodigo().toString().concat("-").concat(m.getProjeto().getId().toString());
    }

    @Override
    protected NegocioInterface<Modulo> getServico() {
        return negocio;
    }

}
