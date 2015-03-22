/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.controller;

import br.com.projeto.dao.DAO;
import br.com.projeto.dao.ProjetoDAO;
import br.com.projeto.modelo.projeto.Projeto;
import br.com.projeto.util.Informacao;
import br.com.projeto.util.InformacaoConsultaProjeto;
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
public class ProjetoController extends Controller<Projeto, Long> implements Serializable {

    @EJB
    private ProjetoDAO dao;

    public ProjetoController() {
    }

    @Override
    protected DAO<Projeto, Long> getDao() {
        return dao;
    }

    @Override
    public Informacao carregar(Long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Informacao valida(Projeto t) throws Exception {
        Informacao resposta = new Informacao();
        if (t.getNome().trim().length() < 5) {
            resposta.setTipo(TipoMensagem.ALERTA);
            resposta.setConteudo(new ResourcesUtil("strings").getMensagem("projeto.invalido"));
            resposta.setTitulo(new ResourcesUtil("strings").getMensagem("projeto.invalido_titulo"));
        } else {
            resposta.setTipo(TipoMensagem.SUCESSO);
        }
        return resposta;
    }

    @Override
    public InformacaoConsultaProjeto listar(Integer inicio) throws Exception {
        List<Projeto> lista = getDao().listar(inicio);
        InformacaoConsultaProjeto informacao = new InformacaoConsultaProjeto();
        if (lista.isEmpty()) {
            informacao.setConteudo(new ResourcesUtil("strings").getMensagem("consulta.vazia"));
            informacao.setTitulo(new ResourcesUtil("strings").getMensagem("consulta.vazia_titulo"));
            informacao.setTipo(TipoMensagem.INFORMACAO);
        } else {
            informacao.setProjetos(lista);
            informacao.setTipo(TipoMensagem.SUCESSO);
        }
        return informacao;
    }

}
