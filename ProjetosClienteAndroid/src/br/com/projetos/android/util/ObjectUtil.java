/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetos.android.util;

import br.com.projetos.android.util.anotacoes.XmlObject;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author gilmario
 */
public class ObjectUtil {

    public static Object getValorCampo(String campo, Object objeto) throws IllegalAccessException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException {
        String nomeMethodo = "get" + campo.substring(0, 1).toUpperCase() + campo.substring(1);
        Method method = objeto.getClass().getMethod(nomeMethodo);
        return method.invoke(objeto);
    }

    public static void setValorCampo(String campo, Object valor, Object objeto) throws IllegalAccessException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException {
        String nomeMethodo = "set" + campo.substring(0, 1).toUpperCase() + campo.substring(1);
        Method method = objeto.getClass().getMethod(nomeMethodo, valor.getClass());
        method.invoke(objeto, valor);
    }

    public static List<Field> listaCampos(Class classe) {
        List<Field> campos = new ArrayList<Field>();
        campos.addAll(Arrays.asList(classe.getDeclaredFields()));
        Class superClasse = classe.getSuperclass();
        if (superClasse != null) {
            XmlObject anotacao = (XmlObject) superClasse.getAnnotation(XmlObject.class);
            if (anotacao != null) {
                campos.addAll(listaCampos(classe.getSuperclass()));
            }
        }
        return campos;
    }

    public static Class tipoLista(Class entidade, String nomeVar) throws NoSuchFieldException, ClassNotFoundException {
        Field f = entidade.getDeclaredField(nomeVar);
        Type t = ((ParameterizedType) f.getGenericType()).getActualTypeArguments()[0];
        return Class.forName(t.toString().replace("class ", ""));
    }
}
