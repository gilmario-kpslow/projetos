/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.dao;

import br.com.projeto.modelo.projeto.Modulo;
import br.com.projeto.modelo.projeto.Projeto;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author gilmario
 */
@Stateless
public class ModuloDAO extends DAO<Modulo, Long> implements Serializable {

    public ModuloDAO() {
        super(Modulo.class);
    }

    public List<Modulo> listar(Projeto projeto) {
        return getManager().createQuery("SELECT m FROM Modulo m WHERE m.projeto =:p ").setParameter("p", projeto).getResultList();
    }

}
