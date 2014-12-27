/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetos.android.service;

import br.com.projetos.android.modelos.InformacaoLista;
import br.com.projetos.android.modelos.InformacaoProjeto;
import br.com.projetos.android.modelos.Projeto;
import br.com.projetos.android.util.anotacoes.XmlConverter;

/**
 *
 * @author gilmario
 */
public class ProjetoService extends Service {

    public ProjetoService(String servidor) {
        super(servidor + "/projetos/projeto?wsdl");
    }

    public InformacaoProjeto criarProjeto(Projeto projeto) throws Exception {
        return (InformacaoProjeto) executaRequisicao("criarProjeto", "projetos", InformacaoProjeto.class, new XmlConverter().parseToXml(projeto));
    }

    public InformacaoLista listarProjeto() throws Exception {
        return (InformacaoLista) executaRequisicao("listarProjeto", "projetos", InformacaoLista.class);
    }
}
