/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.docproject.dao;

import br.com.docproject.modelo.Manual;
import java.io.Serializable;

/**
 *
 * @author gilmario
 */
public class ManualDAO extends DAO<Manual, Long> implements Serializable {

    public ManualDAO() {
        super(Manual.class);
    }

}
