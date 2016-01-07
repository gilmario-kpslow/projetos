package br.com.truesystem.projetosweb.dominio.gerenciador;

import br.com.truesystem.projetosweb.dominio.Responsavel;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gilmario
 */
@Entity
@Table(name = "projeto", schema = "projeto")
@XmlRootElement
public class Projeto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "pro_id")
    private Long id;
    @Column(nullable = false, length = 100, unique = true)
    private String nome;
    @Column(nullable = false, length = 1000)
    private String descricao;
    @Column
    private String link;
    @JoinColumn(name = "dono", referencedColumnName = "id", nullable = false)
    @ManyToOne
    private Responsavel dono;

    public Responsavel getDono() {
        return dono;
    }

    public void setDono(Responsavel dono) {
        this.dono = dono;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        final Projeto other = (Projeto) obj;
        return Objects.equals(this.id, other.id);
    }

}
