package br.com.truesystem.projetosweb.servico;

import br.com.truesystem.projetosweb.dao.ProjetoDao;
import br.com.truesystem.projetosweb.dominio.gerenciador.AcessoResponsavelProjeto;
import br.com.truesystem.projetosweb.dominio.gerenciador.Projeto;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author gilmario
 */
@Stateless
@LocalBean
public class ProjetoServico implements ServicoInterface<Projeto>, Serializable {

    @EJB
    private ProjetoDao dao;
    @Inject
    private ResponsavelSession responsavelSession;
    @EJB
    private AcessoResponsavelProjetoServico arps;

    @Override
    public void excluir(Projeto t) throws Exception {
        dao.excluir(t);
    }

    public List<Projeto> buscar() {
        return dao.buscar();
    }

    @Override
    public void atualizar(Projeto t) {
        dao.atualizar(t);
    }

    @Override
    public void salvar(Projeto t) {
        if (t.getId() == null) {
            dao.salvar(t);
            registrarAcesso(t);
        } else {
            atualizar(t);
        }
    }

    @Override
    public Projeto carregar(Serializable pk) {
        return dao.carregar(Projeto.class, pk);
    }

    private void registrarAcesso(Projeto t) {
        AcessoResponsavelProjeto arp = new AcessoResponsavelProjeto(responsavelSession.getResponsavel(), t);
        arp.setDono(Boolean.TRUE);
        arps.salvar(arp);
    }

}
