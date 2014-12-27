/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.controller;

import br.com.projeto.dao.DAO;
import br.com.projeto.dao.ResponsavelDAO;
import br.com.projeto.modelo.Responsavel;
import br.com.projeto.util.Informacao;
import br.com.projeto.util.InformacaoResponsavel;
import br.com.projeto.util.ResourcesUtil;
import br.com.projeto.util.TipoMensagem;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author gilmario
 */
@Stateless
public class ResponsavelController extends Controller<Responsavel, Long> implements Serializable {

    @EJB
    private ResponsavelDAO dao;

    @Override
    public Informacao carregar(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public InformacaoResponsavel login(String login, String senha) {
        InformacaoResponsavel resposta = new InformacaoResponsavel();
        try {
            resposta.setResponsavel(dao.login(login, senha));
            resposta.setTipo(TipoMensagem.SUCESSO);
            resposta.setTitulo(new ResourcesUtil("strings").getMensagem("responsavel.login_titulo"));
            resposta.setConteudo(new ResourcesUtil("strings").getMensagem("responsavel.login"));
        } catch (Exception e) {
            resposta.setTipo(TipoMensagem.ERRO);
            resposta.setTitulo(new ResourcesUtil("strings").getMensagem("responsavel.login_erro_titulo"));
            resposta.setConteudo(new ResourcesUtil("strings").getMensagem("responsavel.login_erro"));
        }

        return resposta;
    }

    @Override
    public Informacao valida(Responsavel t) {
        Informacao resposta = new Informacao();
        if (t.getLogin().trim().length() < 3 || t.getNomeCompleto().trim().length() < 3 || t.getSenha().trim().length() < 8) {
            resposta.setTipo(TipoMensagem.ALERTA);
            resposta.setConteudo(new ResourcesUtil("strings").getMensagem("responsavel.invalido"));
            resposta.setTitulo(new ResourcesUtil("strings").getMensagem("responsavel.invalido_titulo"));
        } else {
            resposta.setTipo(TipoMensagem.SUCESSO);
        }
        return resposta;
    }

    @Override
    protected DAO<Responsavel, Long> getDao() {
        return dao;
    }

    @Override
    public Informacao remover(Long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Informacao listar() throws Exception {
        return null;
    }

}
