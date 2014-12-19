/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetos.android.service;

import br.com.projetos.android.util.ObjectConverter;
import br.com.projetos.android.wsdl.SoapXmlGerador;
import br.com.projetos.android.wsdl.WebService;

/**
 *
 * @author gilmario
 */
public abstract class Service {

    private SoapXmlGerador gerador;
    private WebService webService;
    private ObjectConverter converter;
    private String servidor;

    public Service(String servidor) {
        this.servidor = servidor;
        gerador = new SoapXmlGerador();
        webService = new WebService();
        converter = new ObjectConverter();
    }

    public String getServidor() {
        return servidor;
    }

    public Object executaRequisicao(String operacao, String nameSpace, Class tipoRetorno) throws Exception {
        return converter.processaResposta(webService.executaRequisicao(getServidor(), gerador.geraXmlSoap(operacao, nameSpace)), tipoRetorno, "return");
    }

    public Object executaRequisicao(String operacao, String nameSpace, Class tipoRetorno, String conteudo) throws Exception {
        return converter.processaResposta(webService.executaRequisicao(getServidor(), gerador.geraXmlSoap(operacao, nameSpace, conteudo)), tipoRetorno, "return");
    }

    public SoapXmlGerador getGerador() {
        return gerador;
    }

    public WebService getWebService() {
        return webService;
    }

    public ObjectConverter getConverter() {
        return converter;
    }

}
