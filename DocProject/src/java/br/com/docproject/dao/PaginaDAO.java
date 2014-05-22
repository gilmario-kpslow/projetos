/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.docproject.dao;

import br.com.docproject.modelo.Pagina;
import br.com.docproject.modelo.PaginaPk;
import java.io.Serializable;

/**
 *
 * @author gilmario
 */
public class PaginaDAO extends DAO<Pagina, PaginaPk> implements Serializable {

    public PaginaDAO() {
        super(Pagina.class);
    }

}
