/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetos.android.util.anotacoes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author gilmario
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.TYPE})
public @interface XmlObject {

    String tagName() default "##default";

    TipoDadoXML tagTipo() default TipoDadoXML.TEXTO;

    public enum TipoDadoXML {

        TEXTO, DATA, DATA_TEMPO, BOOLEANO, TEMPO, INTEIRO, LONG, DECIMAL, LISTA, ENUMERADO, COMPLEXO
    }
}
