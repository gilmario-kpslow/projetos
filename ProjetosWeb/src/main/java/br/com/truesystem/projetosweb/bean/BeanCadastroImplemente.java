package br.com.truesystem.projetosweb.bean;

import br.com.truesystem.projetosweb.util.GeradorMensagem;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;

/**
 *
 * @author gilmario
 * @param <T>
 */
public abstract class BeanCadastroImplemente<T> implements BeanCadastroInterface<T> {

    @Inject
    private GeradorMensagem gerador;
    private boolean ativo = true;
    protected boolean editando = false;

    protected abstract void salva() throws Exception;

    protected abstract void valida();

    protected abstract void exclui() throws Exception;

    public abstract void limpar();

    protected abstract void atualiza() throws Exception;

    public void mensagem(String titulo, String mensagem) {
        gerador.gerar(titulo, mensagem, FacesMessage.SEVERITY_INFO);
    }

    public void mensagem(String titulo, String mensagem, FacesMessage.Severity severidade) {
        gerador.gerar(titulo, mensagem, severidade);
    }

    public void mensagem(String mensagem) {
        gerador.gerar("Informação", mensagem, FacesMessage.SEVERITY_INFO);
    }

    @Override
    public void salvar() {
        try {
            valida();
            salva();
            limpar();
            mensagem("Sucesso", "Registro salvo com sucesso");
        } catch (Exception e) {
            mensagem("ERRO", e.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }

    @Override
    public void atualizar() {
        try {
            valida();
            atualiza();
            limpar();
            editando = false;
            mensagem("Sucesso", "Registro salvo com sucesso");
        } catch (Exception e) {
            mensagem("ERRO", e.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }

    public boolean isEditando() {
        return editando;
    }

    @Override
    public void excluir() {
        try {
            exclui();
            limpar();
            editando = false;
            mensagem("Sucesso", "Registro excluido com sucesso");
        } catch (Exception e) {
            mensagem("ERRO", e.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void mostrar() {
        ativo = true;
    }

    public void esconder() {
        ativo = false;
    }

}
