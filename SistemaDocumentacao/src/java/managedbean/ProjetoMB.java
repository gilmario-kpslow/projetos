/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import br.com.docproject.modelo.Projeto;
import controler.ProjetoController;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author gilmario
 */
@Named
@SessionScoped
public class ProjetoMB extends BeanGenerico implements Serializable {

    @EJB
    private ProjetoController projetoController;

    private Projeto projeto;

    public void criaProjeto() {
        try {
            projetoController.salvar(projeto);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

}
