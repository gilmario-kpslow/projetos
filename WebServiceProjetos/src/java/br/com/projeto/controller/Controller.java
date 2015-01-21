/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.controller;

import br.com.projeto.dao.DAO;
import br.com.projeto.util.Informacao;
import br.com.projeto.util.ResourcesUtil;
import br.com.projeto.util.TipoMensagem;
import br.com.projetos.interfaces.controller.ControllerWebService;

import java.io.Serializable;

/**
 *
 * @author gilmario
 * @param <T>
 * @param <Id>
 */
public abstract class Controller<T, Id extends Serializable> implements ControllerWebService<T, Id> {

    protected abstract DAO<T, Id> getDao();

    @Override
    public Informacao registrar(T t) throws Exception {
        Informacao resposta = valida(t);
        if (resposta.getTipo().equals(TipoMensagem.SUCESSO)) {
            registra(t);
            resposta.setConteudo(new ResourcesUtil("strings").getMensagem("mensagem.salvar"));
            resposta.setTitulo(new ResourcesUtil("strings").getMensagem("mensagem.salvar_titulo"));
        }
        return resposta;
    }

    protected void registra(T t) throws Exception {
        getDao().salvar(t);
    }

}