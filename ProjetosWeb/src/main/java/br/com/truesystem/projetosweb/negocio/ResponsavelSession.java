package br.com.truesystem.projetosweb.negocio;

import br.com.truesystem.projetosweb.dominio.Responsavel;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author gilmario
 */
@Named
@SessionScoped
public class ResponsavelSession implements Serializable {

    private Responsavel responsavel;

    public Responsavel getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    }

    public boolean isLogado() {
        return responsavel != null;
    }

}
