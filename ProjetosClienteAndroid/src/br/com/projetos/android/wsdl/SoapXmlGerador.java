/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetos.android.wsdl;

/**
 *
 * @author gilmario
 */
public class SoapXmlGerador {

    public String geraXmlSoap(String operacao, String nameSpace, String conteudo) {
        StringBuilder builder = new StringBuilder();
        builder.append(geraCabecalho());
        builder.append("<S:Body><ns2:").append(operacao).append(" xmlns:ns2=\"").append(nameSpace).append("\">");
        builder.append(conteudo);
        builder.append("</ns2:").append(operacao).append(">");
        builder.append(geraRodape());
        return builder.toString();
    }

    public String geraXmlSoap(String operacao, String nameSpace) {
        StringBuilder builder = new StringBuilder();
        builder.append(geraCabecalho());
        builder.append("<S:Body><ns2:").append(operacao).append(" xmlns:ns2=\"").append(nameSpace).append("\"/>");
        builder.append(geraRodape());
        return builder.toString();
    }

    private StringBuilder geraRodape() {
        StringBuilder builder = new StringBuilder("</S:Body>");
        builder.append("</S:Envelope>");
        return builder;
    }

    private StringBuilder geraCabecalho() {
        StringBuilder builder = new StringBuilder();
        builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        builder.append("<S:Envelope xmlns:S=\"http://schemas.xmlsoap.org/soap/envelope/\" ");
        builder.append("xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\">");
        builder.append("<SOAP-ENV:Header/>");
        return builder;
    }

}
