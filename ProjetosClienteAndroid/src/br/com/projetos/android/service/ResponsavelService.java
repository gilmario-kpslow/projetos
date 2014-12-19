/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetos.android.service;

import br.com.projetos.android.modelos.InformacaoResponsavel;
import br.com.projetos.android.modelos.Responsavel;
import br.com.projetos.android.util.anotacoes.XmlConverter;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author gilmario
 */
public class ResponsavelService extends Service {

    public ResponsavelService(String servidor) {
        super(servidor + "/projetos/responsavel?wsdl");
    }

    public InformacaoResponsavel registrarResponsavel(Responsavel reponsavel) throws Exception {
        return (InformacaoResponsavel) executaRequisicao("registrarResponsavel", "projetos", InformacaoResponsavel.class, new XmlConverter().parseToXml(reponsavel));
    }

    public InformacaoResponsavel loginResponsavel(String login, String senha) throws Exception {
        Map<String, String> parametros = new HashMap<String, String>();
        parametros.put("login", login);
        parametros.put("senha", senha);
        return (InformacaoResponsavel) executaRequisicao("loginResponsavel", "projetos", InformacaoResponsavel.class, new XmlConverter().parseToXml(parametros));
    }

}
