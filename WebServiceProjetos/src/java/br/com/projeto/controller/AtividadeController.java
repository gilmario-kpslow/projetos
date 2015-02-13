/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.controller;

import br.com.projeto.dao.AtividadeDAO;
import br.com.projeto.dao.DAO;
import br.com.projeto.dao.ModuloDAO;
import br.com.projeto.dao.ProjetoDAO;
import br.com.projeto.modelo.projeto.Atividade;
import br.com.projeto.modelo.projeto.Modulo;
import br.com.projeto.modelo.projeto.Projeto;
import br.com.projeto.util.Informacao;
import br.com.projeto.util.InformacaoConsultaAtividade;
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
public class AtividadeController extends Controller<Atividade, Long> implements Serializable {

    @EJB
    private AtividadeDAO dao;
    @EJB
    private ModuloDAO moduloDAO;

    public AtividadeController() {
    }

    @Override
    protected DAO<Atividade, Long> getDao() {
        return dao;
    }

    @Override
    protected void registra(Atividade t) throws Exception {
        t.setModulo(moduloDAO.carregar(t.getModulo().getId()));
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
    public Informacao valida(Atividade t) throws Exception {
        Informacao resposta = new Informacao();
        if (t.getModulo() == null) {
            resposta.setTipo(TipoMensagem.ALERTA);
            resposta.setConteudo(new ResourcesUtil("strings").getMensagem("atividade.projeto_invalido"));
            resposta.setTitulo(new ResourcesUtil("strings").getMensagem("atividade.invalido_titulo"));
        } else if (t.getNome().trim().length() < 3) {
            resposta.setTipo(TipoMensagem.ALERTA);
            resposta.setConteudo(new ResourcesUtil("strings").getMensagem("atividade.nome_invalido"));
            resposta.setTitulo(new ResourcesUtil("strings").getMensagem("atividade.invalido_titulo"));
        } else {
            resposta.setTipo(TipoMensagem.SUCESSO);
        }
        return resposta;
    }

    @Override
    public InformacaoConsultaAtividade listar(Integer inicio) throws Exception {
        List<Atividade> lista = getDao().listar(inicio);
        InformacaoConsultaAtividade informacao = new InformacaoConsultaAtividade();
        if (lista.isEmpty()) {
            informacao.setConteudo(new ResourcesUtil("strings").getMensagem("consulta.vazia"));
            informacao.setTitulo(new ResourcesUtil("strings").getMensagem("consulta.vazia_titulo"));
            informacao.setTipo(TipoMensagem.INFORMACAO);
        } else {
            informacao.setAtividades(lista);
            informacao.setTipo(TipoMensagem.SUCESSO);
        }
        return informacao;
    }

    public InformacaoConsultaAtividade listar(Projeto projeto) throws Exception {
        List<Atividade> lista = dao.listar(projeto);
        InformacaoConsultaAtividade informacao = new InformacaoConsultaAtividade();
        if (lista.isEmpty()) {
            informacao.setConteudo(new ResourcesUtil("strings").getMensagem("consulta.vazia"));
            informacao.setTitulo(new ResourcesUtil("strings").getMensagem("consulta.vazia_titulo"));
            informacao.setTipo(TipoMensagem.INFORMACAO);
        } else {
            informacao.setAtividades(lista);
            informacao.setTipo(TipoMensagem.SUCESSO);
        }
        return informacao;
    }

    public InformacaoConsultaAtividade listar(Modulo modulo) throws Exception {
        List<Atividade> lista = dao.listar(modulo);
        InformacaoConsultaAtividade informacao = new InformacaoConsultaAtividade();
        if (lista.isEmpty()) {
            informacao.setConteudo(new ResourcesUtil("strings").getMensagem("consulta.vazia"));
            informacao.setTitulo(new ResourcesUtil("strings").getMensagem("consulta.vazia_titulo"));
            informacao.setTipo(TipoMensagem.INFORMACAO);
        } else {
            informacao.setAtividades(lista);
            informacao.setTipo(TipoMensagem.SUCESSO);
        }
        return informacao;
    }

}
