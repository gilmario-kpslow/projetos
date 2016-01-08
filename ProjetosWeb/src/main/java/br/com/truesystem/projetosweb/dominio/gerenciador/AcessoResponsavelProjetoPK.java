package br.com.truesystem.projetosweb.dominio.gerenciador;

import br.com.truesystem.projetosweb.dominio.Responsavel;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author gilmario
 */
public class AcessoResponsavelProjetoPK implements Serializable {

    private Responsavel responsavel;

    private Projeto projeto;

    public AcessoResponsavelProjetoPK() {
    }

    public AcessoResponsavelProjetoPK(Responsavel responsavel, Projeto projeto) {
        this.responsavel = responsavel;
        this.projeto = projeto;
    }

    public Responsavel getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this.responsavel);
        hash = 73 * hash + Objects.hashCode(this.projeto);
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
        final AcessoResponsavelProjetoPK other = (AcessoResponsavelProjetoPK) obj;
        if (!Objects.equals(this.responsavel, other.responsavel)) {
            return false;
        }
        return Objects.equals(this.projeto, other.projeto);
    }

}
