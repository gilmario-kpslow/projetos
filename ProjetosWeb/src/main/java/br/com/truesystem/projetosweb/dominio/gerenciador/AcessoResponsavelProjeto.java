package br.com.truesystem.projetosweb.dominio.gerenciador;

import br.com.truesystem.projetosweb.dominio.Responsavel;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 *
 * @author gilmario
 */
@Entity
@Table(schema = "projeto", name = "acesso_responsavel_projeto")
@IdClass(AcessoResponsavelProjetoPK.class)
public class AcessoResponsavelProjeto implements Serializable {

    @Id
    @JoinColumn(name = "res_id", referencedColumnName = "res_id", nullable = false)
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Responsavel responsavel;
    @Id
    @JoinColumn(name = "pro_id", referencedColumnName = "pro_id", nullable = false)
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Projeto projeto;
    @Column(nullable = false)
    private Boolean dono;

    public AcessoResponsavelProjeto() {
    }

    public AcessoResponsavelProjeto(Responsavel responsavel, Projeto projeto) {
        this.responsavel = responsavel;
        this.projeto = projeto;
        this.dono = false;
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

    public Boolean getDono() {
        return dono;
    }

    public void setDono(Boolean dono) {
        this.dono = dono;
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
        final AcessoResponsavelProjeto other = (AcessoResponsavelProjeto) obj;
        if (!Objects.equals(this.responsavel, other.responsavel)) {
            return false;
        }
        return Objects.equals(this.projeto, other.projeto);
    }

}
