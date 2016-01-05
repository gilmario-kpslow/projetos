package br.com.truesystem.projetosweb.dominio.gerenciador;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name = "funcionalidade", schema = "projeto")
@IdClass(FuncionalidadePK.class)
public class Funcionalidade implements Serializable {

    @Id
    @Column(nullable = false, name = "fun_codigo")
    private Long id;
    @Id
    @JoinColumns({
        @JoinColumn(nullable = false, referencedColumnName = "pro_id", name = "pro_id"),
        @JoinColumn(nullable = false, referencedColumnName = "mod_codigo", name = "mod_codigo"),
        @JoinColumn(nullable = false, referencedColumnName = "ati_codigo", name = "ati_codigo")
    })
    @ManyToOne
    private Atividade atividade;
    @Column(nullable = false, length = 100)
    private String nome;
    @Column(nullable = false, length = 1000)
    private String descricao;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusFuncionalidade status;

    public Funcionalidade() {
        status = StatusFuncionalidade.Pendente;
    }

    public StatusFuncionalidade getStatus() {
        return status;
    }

    public void setStatus(StatusFuncionalidade status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Funcionalidade other = (Funcionalidade) obj;
        return Objects.equals(this.id, other.id);
    }

}
