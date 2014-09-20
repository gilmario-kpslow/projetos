/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.com.docproject.modelo.Projeto;
import java.io.Serializable;
import javax.ejb.Stateless;

/**
 *
 * @author gilmario
 */
@Stateless
public class ProjetoDAO extends DAO<Object, Long> implements Serializable {

    public ProjetoDAO() {
        super(Projeto.class);
    }

}
