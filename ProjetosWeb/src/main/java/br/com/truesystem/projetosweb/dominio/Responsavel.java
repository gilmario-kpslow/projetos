package br.com.truesystem.projetosweb.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gilmario
 */
@Entity
@Table(name = "responsavel", schema = "projeto")
@XmlRootElement
public class Responsavel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    @Column(nullable = false, length = 40, unique = true)
    private String login;
    @Column(nullable = false)
    private String senha;
    private String email;
    @Column(nullable = false)
    private String nomeCompleto;
    @Column(nullable = false)
    private Boolean ativo;
    @ElementCollection(fetch = FetchType.EAGER)
    @Column
    @CollectionTable
    @Enumerated(EnumType.STRING)
    private final List<Papel> papeis;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.id);
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
        final Responsavel other = (Responsavel) obj;
        return Objects.equals(this.id, other.id);
    }

    public Responsavel() {
        ativo = true;
        papeis = new ArrayList<>();
        papeis.add(Papel.ROLE_USUARIO);
    }

    public List<Papel> getPapel() {
        return Collections.unmodifiableList(papeis);
    }

    public void addPapel(Papel papel) {
        this.papeis.add(papel);
    }

}
