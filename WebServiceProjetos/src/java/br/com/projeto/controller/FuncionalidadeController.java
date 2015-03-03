/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.controller;

import br.com.projeto.dao.AtividadeDAO;
import br.com.projeto.dao.DAO;
import br.com.projeto.dao.FuncionalidadeDAO;
import br.com.projeto.dao.ModuloDAO;
import br.com.projeto.modelo.projeto.Atividade;
import br.com.projeto.modelo.projeto.Funcionalidade;
import br.com.projeto.modelo.projeto.Modulo;
import br.com.projeto.modelo.projeto.Projeto;
import br.com.projeto.util.Informacao;
import br.com.projeto.util.InformacaoConsultaAtividade;
import br.com.projeto.util.InformacaoConsultaFuncionalidade;
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
public class FuncionalidadeController extends Controller<Funcionalidade, Long> implements Serializable {

    @EJB
    private FuncionalidadeDAO dao;
    @EJB
    private AtividadeDAO atividadeDAO;

    public FuncionalidadeController() {
    }

    @Override
    protected DAO<Funcionalidade, Long> getDao() {
        return dao;
    }

    @Override
    protected void registra(Funcionalidade t) throws Exception {
        t.setAtividade(atividadeDAO.carregar(t.getAtividade().getId()));
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
    public Informacao valida(Funcionalidade t) throws Exception {
        Informacao resposta = new Informacao();
        if (t.getAtividade() == null) {
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
    public InformacaoConsultaFuncionalidade listar(Integer inicio) throws Exception {
        List<Funcionalidade> lista = getDao().listar(inicio);
        InformacaoConsultaFuncionalidade informacao = new InformacaoConsultaFuncionalidade();
        if (lista.isEmpty()) {
            informacao.setConteudo(new ResourcesUtil("strings").getMensagem("consulta.vazia"));
            informacao.setTitulo(new ResourcesUtil("strings").getMensagem("consulta.vazia_titulo"));
            informacao.setTipo(TipoMensagem.INFORMACAO);
        } else {
            informacao.setFuncionalidades(lista);
            informacao.setTipo(TipoMensagem.SUCESSO);
        }
        return informacao;
    }

    public InformacaoConsultaFuncionalidade listar(Projeto projeto) throws Exception {
        List<Funcionalidade> lista = dao.listar(projeto);
        InformacaoConsultaFuncionalidade informacao = new InformacaoConsultaFuncionalidade();
        if (lista.isEmpty()) {
            informacao.setConteudo(new ResourcesUtil("strings").getMensagem("consulta.vazia"));
            informacao.setTitulo(new ResourcesUtil("strings").getMensagem("consulta.vazia_titulo"));
            informacao.setTipo(TipoMensagem.INFORMACAO);
        } else {
            informacao.setFuncionalidades(lista);
            informacao.setTipo(TipoMensagem.SUCESSO);
        }
        return informacao;
    }

    public InformacaoConsultaFuncionalidade listar(Modulo modulo) throws Exception {
        List<Funcionalidade> lista = dao.listar(modulo);
        InformacaoConsultaFuncionalidade informacao = new InformacaoConsultaFuncionalidade();
        if (lista.isEmpty()) {
            informacao.setConteudo(new ResourcesUtil("strings").getMensagem("consulta.vazia"));
            informacao.setTitulo(new ResourcesUtil("strings").getMensagem("consulta.vazia_titulo"));
            informacao.setTipo(TipoMensagem.INFORMACAO);
        } else {
            informacao.setFuncionalidades(lista);
            informacao.setTipo(TipoMensagem.SUCESSO);
        }
        return informacao;
    }

    public InformacaoConsultaFuncionalidade listar(Atividade atividade) throws Exception {
        List<Funcionalidade> lista = dao.listar(atividade);
        InformacaoConsultaFuncionalidade informacao = new InformacaoConsultaFuncionalidade();
        if (lista.isEmpty()) {
            informacao.setConteudo(new ResourcesUtil("strings").getMensagem("consulta.vazia"));
            informacao.setTitulo(new ResourcesUtil("strings").getMensagem("consulta.vazia_titulo"));
            informacao.setTipo(TipoMensagem.INFORMACAO);
        } else {
            informacao.setFuncionalidades(lista);
            informacao.setTipo(TipoMensagem.SUCESSO);
        }
        return informacao;
    }

}
