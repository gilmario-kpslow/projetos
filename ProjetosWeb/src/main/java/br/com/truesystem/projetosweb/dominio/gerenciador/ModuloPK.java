package br.com.truesystem.projetosweb.dominio.gerenciador;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author gilmario
 */
public class ModuloPK implements Serializable {

    private Long codigo;
    private Projeto projeto;

    public ModuloPK() {
    }

    public ModuloPK(Long codigo, Projeto projeto) {
        this.codigo = codigo;
        this.projeto = projeto;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.codigo);
        hash = 47 * hash + Objects.hashCode(this.projeto);
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
        final ModuloPK other = (ModuloPK) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return Objects.equals(this.projeto, other.projeto);
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

}
