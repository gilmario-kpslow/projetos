package br.com.truesystem.projetosweb.bean;

import br.com.truesystem.projetosweb.dominio.gerenciador.Modulo;
import br.com.truesystem.projetosweb.servico.ModuloServico;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author gilmario
 */
@Named
@ViewScoped
public class CadastraModuloBean extends BeanCadastroImplemente<Modulo> implements Serializable {

    private Modulo modulo;
    @EJB
    private ModuloServico servico;
    @Inject
    private GerenciadorModuloBean gmb;

    @PostConstruct
    protected void init() {
        if (gmb.getModulo() != null) {
            modulo = gmb.getModulo();
            gmb.setModulo(null);
        } else {
            modulo = new Modulo();
        }
    }

    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }

    @Override
    protected void salva() throws Exception {
        servico.salvar(modulo);
    }

    @Override
    protected void valida() {
        // validar o login
    }

    @Override
    protected void exclui() throws Exception {
        servico.excluir(modulo);
    }

    @Override
    public void limpar() {
        init();
    }

    @Override
    protected void atualiza() throws Exception {
        servico.atualizar(modulo);
    }

    @Override
    public boolean isEditando() {
        return modulo.getCodigo() != null;
    }

}
