package br.com.truesystem.projetosweb.dominio.gerenciador;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author gilmario
 */
@Entity
@Table(name = "atividade", schema = "projeto")
@IdClass(AtividadePK.class)
public class Atividade implements Serializable {

    @Id
    @Column(nullable = false, name = "ati_codigo")
    private Long codigo;
    @Id
    @JoinColumns({
        @JoinColumn(nullable = false, referencedColumnName = "pro_id", name = "pro_id"),
        @JoinColumn(nullable = false, referencedColumnName = "mod_codigo", name = "mod_codigo")
    })
    @ManyToOne
    private Modulo modulo;
    @Column(nullable = false, length = 100)
    private String nome;
    @Column(nullable = false, length = 1000)
    private String descricao;

    public Atividade() {
    }

    public Atividade(Long codigo, Modulo modulo) {
        this.codigo = codigo;
        this.modulo = modulo;
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

    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.codigo);
        hash = 29 * hash + Objects.hashCode(this.modulo);
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
        final Atividade other = (Atividade) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return Objects.equals(this.modulo, other.modulo);
    }

}
