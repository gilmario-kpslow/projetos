/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.dao;

import br.com.projeto.modelo.Responsavel;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author gilmario
 */
@Stateless
public class ResponsavelDAO extends DAO<Responsavel, Long> implements Serializable {

    public ResponsavelDAO() {
        super(Responsavel.class);
    }

    @Override
    public List<Responsavel> listar() throws Exception {
        return super.listar();
    }

    public Responsavel login(String login, String senha) {
        return (Responsavel) getManager().createQuery("SELECT r FROM Responsavel r WHERE r.login = :login AND r.senha =:senha").setParameter("login", login).setParameter("senha", senha).getSingleResult();
    }

}
