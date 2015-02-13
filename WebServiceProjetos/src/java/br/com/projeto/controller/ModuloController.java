/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.controller;

import br.com.projeto.dao.DAO;
import br.com.projeto.dao.ModuloDAO;
import br.com.projeto.dao.ProjetoDAO;
import br.com.projeto.modelo.projeto.Modulo;
import br.com.projeto.modelo.projeto.Projeto;
import br.com.projeto.util.Informacao;
import br.com.projeto.util.InformacaoConsultaModulo;
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
public class ModuloController extends Controller<Modulo, Long> implements Serializable {

    @EJB
    private ModuloDAO dao;
    @EJB
    private ProjetoDAO projetoDAO;

    public ModuloController() {
    }

    @Override
    protected DAO<Modulo, Long> getDao() {
        return dao;
    }

    @Override
    protected void registra(Modulo t) throws Exception {
        t.setProjeto(projetoDAO.carregar(t.getProjeto().getId()));
        super.registra(t);
    }

    @Override
    public Informacao remover(Long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Informacao carregar(Long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Informacao valida(Modulo t) throws Exception {
        Informacao resposta = new Informacao();
        if (t.getProjeto() == null) {
            resposta.setTipo(TipoMensagem.ALERTA);
            resposta.setConteudo(new ResourcesUtil("strings").getMensagem("modulo.projeto_invalido"));
            resposta.setTitulo(new ResourcesUtil("strings").getMensagem("modulo.invalido_titulo"));
        } else if (t.getNome().trim().length() < 3) {
            resposta.setTipo(TipoMensagem.ALERTA);
            resposta.setConteudo(new ResourcesUtil("strings").getMensagem("modulo.nome_invalido"));
            resposta.setTitulo(new ResourcesUtil("strings").getMensagem("modulo.invalido_titulo"));
        } else {
            resposta.setTipo(TipoMensagem.SUCESSO);
        }
        return resposta;
    }

    @Override
    public InformacaoConsultaModulo listar(Integer inicio) throws Exception {
        List<Modulo> lista = getDao().listar(inicio);
        InformacaoConsultaModulo informacao = new InformacaoConsultaModulo();
        if (lista.isEmpty()) {
            informacao.setConteudo(new ResourcesUtil("strings").getMensagem("consulta.vazia"));
            informacao.setTitulo(new ResourcesUtil("strings").getMensagem("consulta.vazia_titulo"));
            informacao.setTipo(TipoMensagem.INFORMACAO);
        } else {
            informacao.setModulos(lista);
            informacao.setTipo(TipoMensagem.SUCESSO);
        }
        return informacao;
    }

    public InformacaoConsultaModulo listar(Projeto projeto) throws Exception {
        List<Modulo> lista = dao.listar(projeto);
        InformacaoConsultaModulo informacao = new InformacaoConsultaModulo();
        if (lista.isEmpty()) {
            informacao.setConteudo(new ResourcesUtil("strings").getMensagem("consulta.vazia"));
            informacao.setTitulo(new ResourcesUtil("strings").getMensagem("consulta.vazia_titulo"));
            informacao.setTipo(TipoMensagem.INFORMACAO);
        } else {
            informacao.setModulos(lista);
            informacao.setTipo(TipoMensagem.SUCESSO);
        }
        return informacao;
    }

}
