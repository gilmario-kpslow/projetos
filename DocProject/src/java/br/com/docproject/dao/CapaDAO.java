/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.docproject.dao;

import br.com.docproject.modelo.Capa;
import br.com.docproject.modelo.Pagina;
import java.io.Serializable;

/**
 *
 * @author gilmario
 */
public class CapaDAO extends DAO<Capa, Pagina> implements Serializable {

    public CapaDAO() {
        super(Capa.class);
    }

}
