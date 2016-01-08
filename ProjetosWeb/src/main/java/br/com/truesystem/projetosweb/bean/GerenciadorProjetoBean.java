package br.com.truesystem.projetosweb.bean;

import br.com.truesystem.projetosweb.dominio.Responsavel;
import br.com.truesystem.projetosweb.dominio.gerenciador.AcessoResponsavelProjeto;
import br.com.truesystem.projetosweb.dominio.gerenciador.Modulo;
import br.com.truesystem.projetosweb.dominio.gerenciador.Projeto;
import br.com.truesystem.projetosweb.servico.AcessoResponsavelProjetoServico;
import br.com.truesystem.projetosweb.servico.ModuloServico;
import br.com.truesystem.projetosweb.util.GeradorMensagem;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Named;

/**
 *
 * @author gilmario
 */
@Named
@SessionScoped
public class GerenciadorProjetoBean implements Serializable {

    private Projeto projeto;
    private List<Modulo> listaDeModulos;
    private List<AcessoResponsavelProjeto> acessoResponsavelProjetos;
    @EJB
    private ModuloServico moduloServico;
    @EJB
    private AcessoResponsavelProjetoServico acessoResponsavelProjetoServico;
    @EJB
    private GeradorMensagem geradorMensagem;

    public void atualizar() {
        listaDeModulos = moduloServico.buscar(projeto);
        acessoResponsavelProjetos = acessoResponsavelProjetoServico.buscar(projeto, null);
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
        atualizar();
    }

    public void removeAcesso(AcessoResponsavelProjeto acesso) {
        try {
            if (acesso.getDono()) {
                throw new Exception("Você não pode excluir o dono do projeto!");
            }
            acessoResponsavelProjetoServico.excluir(acesso);
            atualizar();
            geradorMensagem.gerar("Sucesso", "Acesso removido", FacesMessage.SEVERITY_INFO);
        } catch (Exception e) {
            geradorMensagem.gerar("ERRO", e.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }

    public List<Modulo> getListaDeModulos() {
        return listaDeModulos;
    }

    public List<AcessoResponsavelProjeto> getAcessoResponsavelProjetos() {
        return acessoResponsavelProjetos;
    }

    public void adicionaResponsavel(Responsavel responsavel) {
        try {
            if (validaResponsavel(responsavel)) {
                AcessoResponsavelProjeto arp = new AcessoResponsavelProjeto(responsavel, projeto);
                acessoResponsavelProjetoServico.salvar(arp);
                atualizar();
                geradorMensagem.gerar("Sucesso", "Acesso concedido", FacesMessage.SEVERITY_INFO);
            }
        } catch (Exception e) {
            geradorMensagem.gerar("ERRO", e.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }

    private boolean validaResponsavel(Responsavel r) throws Exception {
        for (AcessoResponsavelProjeto a : acessoResponsavelProjetos) {
            if (r.equals(a.getResponsavel())) {
                throw new Exception("Acesso já existe!");
            }
        }
        return true;
    }

}
