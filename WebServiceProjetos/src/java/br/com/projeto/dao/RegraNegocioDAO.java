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
import br.com.projeto.modelo.projeto.RegraNegocio;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author gilmario
 */
@Stateless
public class RegraNegocioDAO extends DAO<RegraNegocio, Long> implements Serializable {

    public RegraNegocioDAO() {
        super(RegraNegocio.class);
    }

    public List<RegraNegocio> listar(Projeto projeto) {
        return getManager().createQuery("SELECT a FROM RegraNegocio a WHERE a.funcionalidade.atividade.modulo.projeto =:p ").setParameter("p", projeto).getResultList();
    }

    public List<RegraNegocio> listar(Modulo modulo) {
        return getManager().createQuery("SELECT a FROM RegraNegocio a WHERE a.funcionalidade.atividade.modulo =:m ").setParameter("m", modulo).getResultList();
    }

    public List<RegraNegocio> listar(Atividade atividade) {
        return getManager().createQuery("SELECT a FROM RegraNegocio a WHERE a.funcionalidade.atividade =:m ").setParameter("m", atividade).getResultList();
    }

    public List<RegraNegocio> listar(Funcionalidade funcionalidade) {
        return getManager().createQuery("SELECT a FROM RegraNegocio a WHERE a.funcionalidade =:m ").setParameter("m", funcionalidade).getResultList();
    }

}
