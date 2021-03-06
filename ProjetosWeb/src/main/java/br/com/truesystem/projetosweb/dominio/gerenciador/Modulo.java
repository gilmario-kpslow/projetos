package br.com.truesystem.projetosweb.dominio.gerenciador;

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
@Table(name = "modulo", schema = "projeto")
@IdClass(ModuloPK.class)
public class Modulo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(nullable = false, name = "mod_codigo")
    private Long codigo;
    @Id
    @JoinColumn(nullable = false, name = "pro_id", referencedColumnName = "pro_id")
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Projeto projeto;
    @Column(nullable = false, length = 100)
    private String nome;
    @Column(nullable = false, length = 1000)
    private String descricao;

    public Modulo() {
    }

    public Modulo(Long codigo, Projeto projeto) {
        this.codigo = codigo;
        this.projeto = projeto;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.codigo);
        hash = 79 * hash + Objects.hashCode(this.projeto);
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
        final Modulo other = (Modulo) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return Objects.equals(this.projeto, other.projeto);
    }

}
