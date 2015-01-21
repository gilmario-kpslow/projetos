/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.dao;

import br.com.projeto.modelo.projeto.Projeto;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author gilmario
 */
@Stateless
public class ProjetoDAO extends DAO<Projeto, Long> implements Serializable {

    public ProjetoDAO() {
        super(Projeto.class);
    }

    @Override
    public List<Projeto> listar() throws Exception {
        return super.listar(0);
    }

}