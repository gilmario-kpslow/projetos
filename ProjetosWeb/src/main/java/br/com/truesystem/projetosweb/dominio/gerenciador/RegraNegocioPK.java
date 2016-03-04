package br.com.truesystem.projetosweb.dominio.gerenciador;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author gilmario
 */
public class RegraNegocioPK implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Funcionalidade funcionalidade;

    public RegraNegocioPK() {
    }

    public RegraNegocioPK(Long id, Funcionalidade funcionalidade) {
        this.id = id;
        this.funcionalidade = funcionalidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Funcionalidade getFuncionalidade() {
        return funcionalidade;
    }

    public void setFuncionalidade(Funcionalidade funcionalidade) {
        this.funcionalidade = funcionalidade;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.funcionalidade);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RegraNegocioPK other = (RegraNegocioPK) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.funcionalidade, other.funcionalidade);
    }

}
