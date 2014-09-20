/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import br.com.docproject.modelo.Projeto;
import dao.ProjetoDAO;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author gilmario
 */
@Stateless
public class ProjetoController extends Controller<Projeto, Long> {

    @EJB
    private ProjetoDAO dao;

    @Override
    @PostConstruct
    protected void init() {
        setDao(dao);
    }

}
