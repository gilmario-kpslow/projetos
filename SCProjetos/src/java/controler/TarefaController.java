package controler;

import dao.TarefaDAO;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import modelo.Tarefa;
import util.MenssagemUtil;

/**
 *
 * @author gilmario
 */
@Named
@SessionScoped
public class TarefaController implements Serializable {

    @Inject
    private ModuloController controller;
    @EJB
    private TarefaDAO dao;
    private Tarefa tarefa;
    private List<Tarefa> tarefasList;

    public TarefaController() {
    }

    @PostConstruct
    private void init() {
        consultarTarefas();
        novo();
    }

    public void novo() {
        tarefa = new Tarefa();
        tarefa.setModulo(controller.getModulo());
    }

    public void criar() {
        try {
            dao.criar(tarefa);
            MenssagemUtil.addMessageInfo("Tarefa criada com sucesso.");
        } catch (Exception e) {
            MenssagemUtil.addMessageErro(e);
        }
    }

    public void atualizar() {
        try {
            dao.editar(tarefa);
            MenssagemUtil.addMessageInfo("Tarefa atualizada com sucesso.");
        } catch (Exception e) {
            MenssagemUtil.addMessageErro(e);
        }
    }

    public Tarefa getTarefa() {
        return tarefa;
    }

    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    public List<Tarefa> getTarefasList() {
        return tarefasList;
    }

    public void setTarefasList(List<Tarefa> tarefasList) {
        this.tarefasList = tarefasList;
    }

    public void consultarTarefas() {
        tarefasList = dao.pegarTarefas(controller.getModulo());
        if (tarefasList.isEmpty()) {
            MenssagemUtil.addMessageInfo("Esse Modulo não possue tarefas cadastradas.");
        }

    }

}
