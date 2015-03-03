/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetos.android.service;

import br.com.projetos.android.modelos.Atividade;
import br.com.projetos.android.modelos.Funcionalidade;
import br.com.projetos.android.modelos.InformacaoConsultaFuncionalidade;
import br.com.projetos.android.modelos.InformacaoConsultaRegraNegocio;
import br.com.projetos.android.modelos.InformacaoFuncionalidade;
import br.com.projetos.android.modelos.InformacaoRegraNegocio;
import br.com.projetos.android.modelos.Modulo;
import br.com.projetos.android.modelos.Projeto;
import br.com.projetos.android.modelos.RegraNegocio;
import br.com.projetos.android.util.anotacoes.XmlConverter;

/**
 *
 * @author gilmario
 */
public class RegraNegocioService extends Service {

    public RegraNegocioService(String servidor) {
        super(servidor + "regranegocio?wsdl");
    }

    public InformacaoRegraNegocio criarRegraNegocio(RegraNegocio regraNegocio) throws Exception {
        return (InformacaoRegraNegocio) executaRequisicao("criarRegraNegocio", "projetos", InformacaoRegraNegocio.class, new XmlConverter().parseToXml(regraNegocio));
    }

    public InformacaoConsultaRegraNegocio listarRegraNegocio(Funcionalidade funcionalidade) throws Exception {
        return (InformacaoConsultaRegraNegocio) executaRequisicao("listarRegraNegocioFuncionalidade", "projetos", InformacaoConsultaRegraNegocio.class, new XmlConverter().parseToXml(funcionalidade));
    }

    public InformacaoConsultaRegraNegocio listarRegraNegocio(Projeto projeto) throws Exception {
        return (InformacaoConsultaRegraNegocio) executaRequisicao("listarRegraNegocioProjeto", "projetos", InformacaoConsultaRegraNegocio.class, new XmlConverter().parseToXml(projeto));
    }
}
