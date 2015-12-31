package br.com.truesystem.projetosweb.bean;

import br.com.truesystem.projetosweb.util.GeradorMensagem;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;

/**
 *
 * @author gilmario
 * @param <T>
 */
public abstract class BeanConsultaImplemente<T> implements BeanConsultaInterface<T>, Serializable {

    @Inject
    private GeradorMensagem gerador;
    private boolean ativo;

    private List lista;

    @Override
    public void setLista(List<T> lista) {
        this.lista = lista;
    }

    @Override
    public List<T> getLista() {
        return lista;
    }

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
    public void buscar() {
        try {
            busca();
            if (getLista().isEmpty()) {
                mensagem("Atenção", "Nenhum resultado encontrado", FacesMessage.SEVERITY_WARN);
            }
        } catch (Exception e) {
            mensagem("Erro", e.getMessage(), FacesMessage.SEVERITY_ERROR);
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
