/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import modelo.Modulo;
import modelo.Projeto;

/**
 *
 * @author gilmario
 */
@Stateless
public class ModuloDAO extends AbstractDAO<Modulo> implements Serializable {

    public ModuloDAO() {
        super(Modulo.class);
    }

    public List<Modulo> pegarModulos(Projeto p) {
        return getEntityManager().createQuery("SELECT m FROM Modulo m WHERE m.projeto =:projeto").setParameter("projeto", p).getResultList();
    }
}
