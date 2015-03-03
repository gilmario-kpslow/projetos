/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.controller;

import br.com.projeto.dao.DAO;
import br.com.projeto.dao.FuncionalidadeDAO;
import br.com.projeto.dao.RegraNegocioDAO;
import br.com.projeto.modelo.projeto.Atividade;
import br.com.projeto.modelo.projeto.Funcionalidade;
import br.com.projeto.modelo.projeto.Modulo;
import br.com.projeto.modelo.projeto.Projeto;
import br.com.projeto.modelo.projeto.RegraNegocio;
import br.com.projeto.util.Informacao;
import br.com.projeto.util.InformacaoConsultaRegraNegocio;
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
public class RegraNegocioController extends Controller<RegraNegocio, Long> implements Serializable {

    @EJB
    private RegraNegocioDAO dao;
    @EJB
    private FuncionalidadeDAO funcionalidadeDAO;

    public RegraNegocioController() {
    }

    @Override
    protected DAO<RegraNegocio, Long> getDao() {
        return dao;
    }

    @Override
    protected void registra(RegraNegocio t) throws Exception {
        t.setFuncionalidade(funcionalidadeDAO.carregar(t.getFuncionalidade().getId()));
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
    public Informacao valida(RegraNegocio t) throws Exception {
        Informacao resposta = new Informacao();
        if (t.getFuncionalidade() == null) {
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
    public InformacaoConsultaRegraNegocio listar(Integer inicio) throws Exception {
        List<RegraNegocio> lista = getDao().listar(inicio);
        InformacaoConsultaRegraNegocio informacao = new InformacaoConsultaRegraNegocio();
        if (lista.isEmpty()) {
            informacao.setConteudo(new ResourcesUtil("strings").getMensagem("consulta.vazia"));
            informacao.setTitulo(new ResourcesUtil("strings").getMensagem("consulta.vazia_titulo"));
            informacao.setTipo(TipoMensagem.INFORMACAO);
        } else {
            informacao.setRegraNegocios(lista);
            informacao.setTipo(TipoMensagem.SUCESSO);
        }
        return informacao;
    }

    public InformacaoConsultaRegraNegocio listar(Projeto projeto) throws Exception {
        List<RegraNegocio> lista = dao.listar(projeto);
        InformacaoConsultaRegraNegocio informacao = new InformacaoConsultaRegraNegocio();
        if (lista.isEmpty()) {
            informacao.setConteudo(new ResourcesUtil("strings").getMensagem("consulta.vazia"));
            informacao.setTitulo(new ResourcesUtil("strings").getMensagem("consulta.vazia_titulo"));
            informacao.setTipo(TipoMensagem.INFORMACAO);
        } else {
            informacao.setRegraNegocios(lista);
            informacao.setTipo(TipoMensagem.SUCESSO);
        }
        return informacao;
    }

    public InformacaoConsultaRegraNegocio listar(Modulo modulo) throws Exception {
        List<RegraNegocio> lista = dao.listar(modulo);
        InformacaoConsultaRegraNegocio informacao = new InformacaoConsultaRegraNegocio();
        if (lista.isEmpty()) {
            informacao.setConteudo(new ResourcesUtil("strings").getMensagem("consulta.vazia"));
            informacao.setTitulo(new ResourcesUtil("strings").getMensagem("consulta.vazia_titulo"));
            informacao.setTipo(TipoMensagem.INFORMACAO);
        } else {
            informacao.setRegraNegocios(lista);
            informacao.setTipo(TipoMensagem.SUCESSO);
        }
        return informacao;
    }

    public InformacaoConsultaRegraNegocio listar(Atividade atividade) throws Exception {
        List<RegraNegocio> lista = dao.listar(atividade);
        InformacaoConsultaRegraNegocio informacao = new InformacaoConsultaRegraNegocio();
        if (lista.isEmpty()) {
            informacao.setConteudo(new ResourcesUtil("strings").getMensagem("consulta.vazia"));
            informacao.setTitulo(new ResourcesUtil("strings").getMensagem("consulta.vazia_titulo"));
            informacao.setTipo(TipoMensagem.INFORMACAO);
        } else {
            informacao.setRegraNegocios(lista);
            informacao.setTipo(TipoMensagem.SUCESSO);
        }
        return informacao;
    }

    public InformacaoConsultaRegraNegocio listar(Funcionalidade funcionalidade) throws Exception {
        List<RegraNegocio> lista = dao.listar(funcionalidade);
        InformacaoConsultaRegraNegocio informacao = new InformacaoConsultaRegraNegocio();
        if (lista.isEmpty()) {
            informacao.setConteudo(new ResourcesUtil("strings").getMensagem("consulta.vazia"));
            informacao.setTitulo(new ResourcesUtil("strings").getMensagem("consulta.vazia_titulo"));
            informacao.setTipo(TipoMensagem.INFORMACAO);
        } else {
            informacao.setRegraNegocios(lista);
            informacao.setTipo(TipoMensagem.SUCESSO);
        }
        return informacao;
    }

}
