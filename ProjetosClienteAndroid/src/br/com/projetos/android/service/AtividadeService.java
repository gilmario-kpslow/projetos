/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetos.android.service;

import br.com.projetos.android.modelos.Atividade;
import br.com.projetos.android.modelos.InformacaoAtividade;
import br.com.projetos.android.modelos.InformacaoConsultaAtividade;
import br.com.projetos.android.modelos.Modulo;
import br.com.projetos.android.modelos.Projeto;
import br.com.projetos.android.util.anotacoes.XmlConverter;

/**
 *
 * @author gilmario
 */
public class AtividadeService extends Service {

    public AtividadeService(String servidor) {
        super(servidor + "atividade?wsdl");
    }

    public InformacaoAtividade criarAtividade(Atividade atividade) throws Exception {
        return (InformacaoAtividade) executaRequisicao("criarAtividade", "projetos", InformacaoAtividade.class, new XmlConverter().parseToXml(atividade));
    }

    public InformacaoConsultaAtividade listarAtividade(Modulo modulo) throws Exception {
        return (InformacaoConsultaAtividade) executaRequisicao("listarAtividadeModulo", "projetos", InformacaoConsultaAtividade.class, new XmlConverter().parseToXml(modulo));
    }

    public InformacaoConsultaAtividade listarAtividade(Projeto projeto) throws Exception {
        return (InformacaoConsultaAtividade) executaRequisicao("listarAtividadeProjeto", "projetos", InformacaoConsultaAtividade.class, new XmlConverter().parseToXml(projeto));
    }
}
