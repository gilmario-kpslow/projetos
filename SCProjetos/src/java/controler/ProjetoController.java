package controler;

import modelo.Projeto;
import dao.ProjetoDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import util.MenssagemUtil;

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
        projetosList = getDAO().pegarTodos();
    }

    @PostConstruct
    public void init() {
        novo();
    }

    public void novo() {
        projeto = new Projeto();
    }

    private ProjetoDAO getDAO() {
        return dao;
    }

    public void criar() {
        try {
            getDAO().criar(projeto);
        } catch (Exception e) {

        }
    }

    public void update() {
        try {
            getDAO().editar(projeto);
            MenssagemUtil.addMessageInfo("Projeto Criado com sucesso.");
        } catch (Exception e) {
            MenssagemUtil.addMessageErro(e);
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

    public void selecionaProjeto(Projeto p) {
        this.projeto = p;
    }

}
