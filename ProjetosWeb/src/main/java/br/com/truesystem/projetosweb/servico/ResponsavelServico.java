package br.com.truesystem.projetosweb.servico;

import br.com.truesystem.projetosweb.dao.ResponsavelDao;
import br.com.truesystem.projetosweb.dominio.Papel;
import br.com.truesystem.projetosweb.dominio.Responsavel;
import br.com.truesystem.projetosweb.util.CriptografiaUtil;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author gilmario
 */
@Stateless
@LocalBean
public class ResponsavelServico implements ServicoInterface<Responsavel>, Serializable {

    @EJB
    private ResponsavelDao dao;

    @Override
    public void excluir(Responsavel t) throws Exception {
        dao.excluir(t);
    }

    public List<Responsavel> buscar() {
        return dao.buscar();
    }

    public List<Responsavel> buscar(String nome) {
        return dao.buscar(nome);
    }

    @Override
    public void atualizar(Responsavel t) throws Exception {
        t.setSenha(CriptografiaUtil.MD5(t.getSenha()));
        dao.atualizar(t);
    }

    @Override
    public void salvar(Responsavel t) {
        t.setSenha(CriptografiaUtil.MD5(t.getSenha()));
        dao.atualizar(t);
    }

    @Override
    public Responsavel carregar(Serializable pk) {
        return dao.carregar(Responsavel.class, pk);
    }

    public Responsavel logar(String login, String senha) {
        return dao.buscarPor(login, senha);
    }

    public Responsavel buscarPorLogin(String login) {
        return dao.buscarPor(login);
    }

}
