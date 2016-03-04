/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.truesystem.projetosweb.converter;

import br.com.truesystem.projetosweb.negocio.NegocioInterface;
import java.io.Serializable;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author gilmario
 * @param <T>
 */
public abstract class DefaultConverter<T> implements Converter {

    @Override
    public T getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            T t = (T) getServico().carregar(getChave(value));
            return t;
        } catch (Exception e) {
            return null;
        }
    }

    protected abstract Serializable getChave(String value);

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        try {
            return getId(value);
        } catch (Exception e) {
            return null;

        }
    }

    protected abstract String getId(Object value);

    protected abstract NegocioInterface<T> getServico();

}
