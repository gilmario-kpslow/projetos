package controler;

import modelo.Projeto;
import controler.util.JsfUtil;
import dao.ProjetoDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

@Named("projetoController")
@SessionScoped
public class ProjetoController implements Serializable {

    private Projeto projeto;
    private List<Projeto> projetosList;
    @EJB
    private ProjetoDAO dao;

    public ProjetoController() {
        projetosList = new ArrayList<>();
    }

    public void mostrarProjetos() {
        projetosList = getDAO().findAll();
    }

    private ProjetoDAO getDAO() {
        return dao;
    }

    public void criar() {
        try {
            getDAO().create(projeto);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ProjetoCreated"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    public void update() {
        try {
            getDAO().edit(projeto);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ProjetoUpdated"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public List<Projeto> getProjetosList() {
        return projetosList;
    }

    public void setProjetosList(List<Projeto> projetosList) {
        this.projetosList = projetosList;
    }

}
