/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetos.android.service;

import br.com.projetos.android.modelos.InformacaoConsultaModulo;
import br.com.projetos.android.modelos.InformacaoModulo;
import br.com.projetos.android.modelos.Modulo;
import br.com.projetos.android.modelos.Projeto;
import br.com.projetos.android.util.anotacoes.XmlConverter;

/**
 *
 * @author gilmario
 */
public class ModuloService extends Service {

    public ModuloService(String servidor) {
        super(servidor + "modulo?wsdl");
    }

    public InformacaoModulo criarModulo(Modulo modulo) throws Exception {
        return (InformacaoModulo) executaRequisicao("criarModulo", "projetos", InformacaoModulo.class, new XmlConverter().parseToXml(modulo));
    }

    public InformacaoConsultaModulo listarModulo(Projeto projeto) throws Exception {
        return (InformacaoConsultaModulo) executaRequisicao("listarModulo", "projetos", InformacaoConsultaModulo.class, new XmlConverter().parseToXml(projeto));
    }
}
