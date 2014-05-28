/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Projeto;

/**
 *
 * @author gilmario
 */
@Stateless
public class ProjetoDAO extends AbstractDAO<Projeto> implements Serializable {

    public ProjetoDAO() {
        super(Projeto.class);
    }

}
