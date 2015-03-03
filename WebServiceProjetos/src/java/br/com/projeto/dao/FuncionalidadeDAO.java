/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.dao;

import br.com.projeto.modelo.projeto.Atividade;
import br.com.projeto.modelo.projeto.Funcionalidade;
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
public class FuncionalidadeDAO extends DAO<Funcionalidade, Long> implements Serializable {

    public FuncionalidadeDAO() {
        super(Funcionalidade.class);
    }

    public List<Funcionalidade> listar(Projeto projeto) {
        return getManager().createQuery("SELECT a FROM Funcionalidade a WHERE a.atividade.modulo.projeto =:p ").setParameter("p", projeto).getResultList();
    }

    public List<Funcionalidade> listar(Modulo modulo) {
        return getManager().createQuery("SELECT a FROM Funcionalidade a WHERE a.atividade.modulo =:m ").setParameter("m", modulo).getResultList();
    }

    public List<Funcionalidade> listar(Atividade atividade) {
        return getManager().createQuery("SELECT a FROM Funcionalidade a WHERE a.atividade =:m ").setParameter("m", atividade).getResultList();
    }

}
