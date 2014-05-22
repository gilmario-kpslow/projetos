/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.docproject.dao;

import br.com.docproject.modelo.Conteudo;
import br.com.docproject.modelo.ConteudoPK;
import java.io.Serializable;

/**
 *
 * @author gilmario
 */
public class ConteudoDAO extends DAO<Conteudo, ConteudoPK> implements Serializable {

    public ConteudoDAO() {
        super(Conteudo.class);
    }

}
