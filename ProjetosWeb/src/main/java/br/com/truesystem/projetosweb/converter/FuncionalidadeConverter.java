package br.com.truesystem.projetosweb.converter;

import br.com.truesystem.projetosweb.dominio.gerenciador.Atividade;
import br.com.truesystem.projetosweb.dominio.gerenciador.Funcionalidade;
import br.com.truesystem.projetosweb.dominio.gerenciador.FuncionalidadePK;
import br.com.truesystem.projetosweb.dominio.gerenciador.Modulo;
import br.com.truesystem.projetosweb.dominio.gerenciador.Projeto;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.Dependent;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;
import br.com.truesystem.projetosweb.negocio.FuncionalidadeNegocio;
import br.com.truesystem.projetosweb.negocio.NegocioInterface;

/**
 *
 * @author gilmario
 */
@FacesConverter(value = "funcionalidadeConverter")
@Named
@Dependent
public class FuncionalidadeConverter extends DefaultConverter<Funcionalidade> implements Serializable {

    @EJB
    private FuncionalidadeNegocio negocio;

    @Override
    protected Serializable getChave(String value) {
        String[] codigo = value.split("-");
        return new FuncionalidadePK(Long.parseLong(codigo[0]), new Atividade(Long.parseLong(codigo[1]), new Modulo(Long.parseLong(codigo[2]), new Projeto(Long.parseLong(codigo[3])))));
    }

    @Override
    protected String getId(Object value) {
        Funcionalidade f = (Funcionalidade) value;
        return f.getId().toString().concat("-")
                .concat(f.getAtividade().getCodigo().toString()).concat("-")
                .concat(f.getAtividade().getModulo().getCodigo().toString())
                .concat(f.getAtividade().getModulo().getProjeto().getId().toString());
    }

    @Override
    protected NegocioInterface<Funcionalidade> getServico() {
        return negocio;
    }

}
