/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetos.android.service;

import br.com.projetos.android.modelos.InformacaoConsultaProjeto;
import br.com.projetos.android.modelos.InformacaoProjeto;
import br.com.projetos.android.modelos.Projeto;
import br.com.projetos.android.util.anotacoes.XmlConverter;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author gilmario
 */
public class ProjetoService extends Service {

    public ProjetoService(String servidor) {
        super(servidor + "projeto?wsdl");
    }

    public InformacaoProjeto criarProjeto(Projeto projeto) throws Exception {
        return (InformacaoProjeto) executaRequisicao("criarProjeto", "projetos", InformacaoProjeto.class, new XmlConverter().parseToXml(projeto));
    }

    public InformacaoProjeto editarProjeto(Projeto projeto) throws Exception {
        return (InformacaoProjeto) executaRequisicao("editaProjeto", "projetos", InformacaoProjeto.class, new XmlConverter().parseToXml(projeto));
    }

    public InformacaoProjeto removeProjeto(Projeto projeto) throws Exception {
        return (InformacaoProjeto) executaRequisicao("removeProjeto", "projetos", InformacaoProjeto.class, new XmlConverter().parseToXml(projeto));
    }

    public InformacaoConsultaProjeto listarProjeto() throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        map.put("inicio", Integer.toString(0));
        return (InformacaoConsultaProjeto) executaRequisicao("listarProjeto", "projetos", InformacaoConsultaProjeto.class, new XmlConverter().parseToXml(map));
    }
}
