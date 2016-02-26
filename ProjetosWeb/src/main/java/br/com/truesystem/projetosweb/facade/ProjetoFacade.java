package br.com.truesystem.projetosweb.facade;

import br.com.truesystem.projetosweb.dominio.gerenciador.AcessoResponsavelProjeto;
import br.com.truesystem.projetosweb.dominio.gerenciador.Projeto;
import br.com.truesystem.projetosweb.negocio.AcessoResponsavelProjetoNegocio;
import br.com.truesystem.projetosweb.negocio.AtividadeNegocio;
import br.com.truesystem.projetosweb.negocio.FuncionalidadeNegocio;
import br.com.truesystem.projetosweb.negocio.ModuloNegocio;
import br.com.truesystem.projetosweb.negocio.ProjetoNegocio;
import br.com.truesystem.projetosweb.negocio.RegraNegocioNegocio;
import br.com.truesystem.projetosweb.negocio.ResponsavelSession;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author gilmario
 */
@Stateless
public class ProjetoFacade implements Serializable {

    @Inject
    private ResponsavelSession responsavelSession;
    @EJB
    private AcessoResponsavelProjetoNegocio arps;
    @EJB
    private ProjetoNegocio projetoNegocio;
    @EJB
    private ModuloNegocio moduloNegocio;
    @EJB
    private AtividadeNegocio atividadeNegocio;
    @EJB
    private FuncionalidadeNegocio funcionalidadeNegocio;
    @EJB
    private RegraNegocioNegocio regraNegocioNegocio;

    public void excluirProjeto(Projeto projeto) {
        arps.excluir(projeto);
        regraNegocioNegocio.excluir(projeto);
        funcionalidadeNegocio.excluir(projeto);
        atividadeNegocio.excluir(projeto);
        moduloNegocio.excluir(projeto);
        projetoNegocio.excluir(projeto);
    }

    public void registrarAcesso(Projeto t) {
        AcessoResponsavelProjeto arp = new AcessoResponsavelProjeto(responsavelSession.getResponsavel(), t);
        arp.setDono(Boolean.TRUE);
        arps.salvar(arp);
    }

}
