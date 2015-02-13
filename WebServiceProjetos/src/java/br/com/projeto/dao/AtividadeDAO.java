/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.dao;

import br.com.projeto.modelo.projeto.Atividade;
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
public class AtividadeDAO extends DAO<Atividade, Long> implements Serializable {

    public AtividadeDAO() {
        super(Atividade.class);
    }

    public List<Atividade> listar(Projeto projeto) {
        return getManager().createQuery("SELECT a FROM Atividade a WHERE a.modulo.projeto =:p ").setParameter("p", projeto).getResultList();
    }

    public List<Atividade> listar(Modulo modulo) {
        return getManager().createQuery("SELECT a FROM Atividade a WHERE a.modulo =:m ").setParameter("m", modulo).getResultList();
    }

}
