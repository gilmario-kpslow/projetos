/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetos.android.util.anotacoes;

import br.com.projetos.android.util.ObjectUtil;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 *
 * @author gilmario
 */
public class XmlConverter {

    public String parseToXml(Object objeto) throws XmlConverterException, IllegalAccessException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException {
        StringBuilder xmlFinal = new StringBuilder();
        XmlObject xmlObject = objeto.getClass().getAnnotation(XmlObject.class);
        if (xmlObject == null) {
            throw new XmlConverterException("Classe não serializavel.");
        }
        xmlFinal.append("<");
        xmlFinal.append(xmlObject.tagName());
        xmlFinal.append(">");
        Field[] campos = objeto.getClass().getDeclaredFields();
        for (Field campo : campos) {
            XmlObject elemento = campo.getAnnotation(XmlObject.class);
            Object valor = ObjectUtil.getValorCampo(campo.getName(), objeto);
            if (valor != null) {
                if (elemento.tagTipo().equals(XmlObject.TipoDadoXML.COMPLEXO)) {
                    xmlFinal.append(parseToXml(valor));
                } else {
                    xmlFinal.append("<");
                    xmlFinal.append(elemento.tagName());
                    xmlFinal.append(">");
                    xmlFinal.append(ObjectUtil.getValorCampo(campo.getName(), objeto));
                    xmlFinal.append("</");
                    xmlFinal.append(elemento.tagName());
                    xmlFinal.append(">");
                }
            }
        }
        xmlFinal.append("</");
        xmlFinal.append(xmlObject.tagName());
        xmlFinal.append(">");
        return xmlFinal.toString();
    }

    public String parseToXml(Map<String, String> entrada) throws XmlConverterException, IllegalAccessException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException {
        StringBuilder xmlFinal = new StringBuilder();
        for (Map.Entry<String, String> valores : entrada.entrySet()) {
            String parametro = valores.getKey();
            String valor = valores.getValue();
            xmlFinal.append("<");
            xmlFinal.append(parametro);
            xmlFinal.append(">");
            xmlFinal.append(valor);
            xmlFinal.append("</");
            xmlFinal.append(parametro);
            xmlFinal.append(">");
        }
        return xmlFinal.toString();
    }

}
