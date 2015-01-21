/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetos.android.util;

import br.com.projetos.android.util.anotacoes.XmlObject;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author gilmario
 */
public class ObjectConverter {

    public Object processaResposta(StringBuilder xml, Class classe, String tag) throws ParserConfigurationException, SAXException, IOException, InstantiationException, IllegalAccessException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException, ParseException, NoSuchFieldException, ClassNotFoundException, Exception {
        Map<ConverterAux, Object> metodoValor = extrairMetodosComValor(xml, classe, tag);
        Object o = classe.newInstance();
        for (Map.Entry<ConverterAux, Object> entrySet : metodoValor.entrySet()) {
            ConverterAux converter = entrySet.getKey();
            Object valor = entrySet.getValue();
            ObjectUtil.setValorCampo(converter.getCampo().getName(), valor, o);
        }
        return o;
    }

    private Map<ConverterAux, Object> extrairMetodosComValor(StringBuilder xml, Class classe, String tag) throws ParseException, ParserConfigurationException, SAXException, IOException, InstantiationException, IllegalAccessException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException, ClassNotFoundException, Exception {
        Map<ConverterAux, Object> map = new HashMap<ConverterAux, Object>();
        String initTag = "<" + tag;
        String endTag = "</" + tag + ">";
        String retorno = xml.substring(xml.indexOf(initTag), xml.indexOf(endTag) + endTag.length());
        for (Field campo : ObjectUtil.listaCampos(classe)) {
            XmlObject descritor = campo.getAnnotation(XmlObject.class);
            // Verifivar se o retorno contem a tag
            if (retorno.contains(descritor.tagName())) {
                String tagA = "<" + descritor.tagName();
                String tagB = "</" + descritor.tagName() + ">";
                int i = retorno.indexOf(tagA);
                int f = retorno.indexOf(tagB) + tagB.length();
                String valor = retorno.substring(i, f);
                Object setar;
                switch (descritor.tagTipo()) {
                    // Reprocessar entidade
                    case COMPLEXO:
                        setar = processaResposta(new StringBuilder(valor), campo.getType(), descritor.tagName());
                        break;
                    case DATA:
                        setar = FormaterUtil.converteData(valor.replaceAll(tagA + ">", "").replaceAll(tagB, ""));
                        break;
                    case DATA_TEMPO:
                        setar = FormaterUtil.converteDataTime(valor.replaceAll(tagA + ">", "").replaceAll(tagB, ""));
                        break;
                    case INTEIRO:
                        setar = Integer.valueOf(valor.replaceAll(tagA + ">", "").replaceAll(tagB, ""));
                        break;
                    case LONG:
                        setar = Long.valueOf(valor.replaceAll(tagA + ">", "").replaceAll(tagB, ""));
                        break;
                    case DECIMAL:
                        setar = Double.valueOf(valor.replaceAll(tagA + ">", "").replaceAll(tagB, ""));
                        break;
                    case LISTA:
                        setar = processarLista(retorno.substring(i, retorno.lastIndexOf(tagB) + tagB.length()), ObjectUtil.tipoLista(classe, descritor.tagName()), descritor.tagName());
                        break;
                    case ENUMERADO:
                        setar = Enum.valueOf((Class) campo.getType(), valor.replaceAll(tagA + ">", "").replaceAll(tagB, ""));
                        break;
                    case BOOLEANO:
                        setar = Boolean.valueOf(valor.replaceAll(tagA + ">", "").replaceAll(tagB, ""));
                        break;
                    default:
                        setar = valor.replaceAll(tagA + ">", "").replaceAll(tagB, "");
                }
                ConverterAux aux = new ConverterAux(campo, descritor);
                map.put(aux, setar);
            }
        }
        return map;
    }

    private ArrayList<Object> processarLista(String xml, Class tipo, String tag) throws Exception {
        ArrayList<Object> lista = new ArrayList<Object>();
        String tagA = "<" + tag + ">";
        String tagB = "</" + tag + ">";
        int inicio = xml.indexOf(tagA);
        int fim = xml.indexOf(tagB);
        for (; inicio != -1;) {
            lista.add(processaResposta(new StringBuilder(xml.substring(inicio, fim + tagB.length())), tipo, tag));
            inicio = xml.indexOf(tagA, inicio + 1);
            fim = xml.indexOf(tagB, fim + 1);
        }
        return lista;
    }

    private class ConverterAux {

        Field campo;
        XmlObject descritor;

        public ConverterAux(Field campo, XmlObject descritor) {
            this.campo = campo;
            this.descritor = descritor;
        }

        public Field getCampo() {
            return campo;
        }

        public void setCampo(Field campo) {
            this.campo = campo;
        }

        public XmlObject getDescritor() {
            return descritor;
        }

        public void setDescritor(XmlObject descritor) {
            this.descritor = descritor;
        }

        @Override
        public int hashCode() {
            int hash = 3;
            hash = 97 * hash + (this.campo != null ? this.campo.hashCode() : 0);
            hash = 97 * hash + (this.descritor != null ? this.descritor.hashCode() : 0);
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final ConverterAux other = (ConverterAux) obj;
            if (this.campo != other.campo && (this.campo == null || !this.campo.equals(other.campo))) {
                return false;
            }
            return !(this.descritor != other.descritor && (this.descritor == null || !this.descritor.equals(other.descritor)));
        }

    }
}
