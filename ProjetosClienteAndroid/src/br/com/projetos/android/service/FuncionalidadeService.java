/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetos.android.service;

import br.com.projetos.android.modelos.Atividade;
import br.com.projetos.android.modelos.Funcionalidade;
import br.com.projetos.android.modelos.InformacaoConsultaFuncionalidade;
import br.com.projetos.android.modelos.InformacaoFuncionalidade;
import br.com.projetos.android.modelos.Modulo;
import br.com.projetos.android.modelos.Projeto;
import br.com.projetos.android.util.anotacoes.XmlConverter;

/**
 *
 * @author gilmario
 */
public class FuncionalidadeService extends Service {

    public FuncionalidadeService(String servidor) {
        super(servidor + "funcionalidade?wsdl");
    }

    public InformacaoFuncionalidade criarFuncionalidade(Funcionalidade funcionalidade) throws Exception {
        return (InformacaoFuncionalidade) executaRequisicao("criarFuncionalidade", "projetos", InformacaoFuncionalidade.class, new XmlConverter().parseToXml(funcionalidade));
    }

    public InformacaoConsultaFuncionalidade listarFuncionalidade(Atividade atividade) throws Exception {
        return (InformacaoConsultaFuncionalidade) executaRequisicao("listarFuncionalidadeAtividade", "projetos", InformacaoConsultaFuncionalidade.class, new XmlConverter().parseToXml(atividade));
    }

    public InformacaoConsultaFuncionalidade listarFuncionalidade(Modulo modulo) throws Exception {
        return (InformacaoConsultaFuncionalidade) executaRequisicao("listarFuncionalidadeModulo", "projetos", InformacaoConsultaFuncionalidade.class, new XmlConverter().parseToXml(modulo));
    }

    public InformacaoConsultaFuncionalidade listarFuncionalidade(Projeto projeto) throws Exception {
        return (InformacaoConsultaFuncionalidade) executaRequisicao("listarFuncionalidadeProjeto", "projetos", InformacaoConsultaFuncionalidade.class, new XmlConverter().parseToXml(projeto));
    }
}
