package controler;

import bean.NavegacaoBean;
import dao.ModuloDAO;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import modelo.Modulo;
import util.MenssagemUtil;

/**
 *
 * @author gilmario
 */
@Named
@SessionScoped
public class ModuloController implements Serializable {

    @Inject
    private ProjetoController controller;
    @EJB
    private ModuloDAO dao;
    private Modulo modulo;
    private List<Modulo> modulosList;
    private NavegacaoBean navegacaoBean;

    public ModuloController() {
    }

    @PostConstruct
    private void init() {
        consultarModulos();
        novo();
        if (controller.getProjeto() == null && controller.getProjeto().getId() == null) {
            navegacaoBean.redireciona(null);
        }
    }

    public void novo() {
        modulo = new Modulo();
        modulo.setProjeto(controller.getProjeto());
    }

    public void criar() {
        try {
            dao.criar(modulo);
            MenssagemUtil.addMessageInfo("Modulo criado com sucesso.");
        } catch (Exception e) {
            MenssagemUtil.addMessageErro(e);
        }
    }

    public void atualizar() {
        try {
            dao.editar(modulo);
            MenssagemUtil.addMessageInfo("Modulo atualizado com sucesso.");
        } catch (Exception e) {
            MenssagemUtil.addMessageErro(e);
        }
    }

    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }

    public List<Modulo> getModulosList() {
        return modulosList;
    }

    public void setModulosList(List<Modulo> modulosList) {
        this.modulosList = modulosList;
    }

    public void consultarModulos() {
        modulosList = dao.pegarModulos(controller.getProjeto());
        if (modulosList.isEmpty()) {
            MenssagemUtil.addMessageInfo("Esse Projeto não possue módulos cadastrados.");
        }
    }

    public void selecionaModulo(Modulo m) {
        this.modulo = m;
    }

}
