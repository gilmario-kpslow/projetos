/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversores;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

/**
 *
 * @author gilmario
 */
@Named
@RequestScoped
public class ConversorData implements Converter {

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", new Locale("pt", "BR"));

    @Override
    public Calendar getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            Calendar c = Calendar.getInstance();
            c.setTime(dateFormat.parse(value));
            return c;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        try {
            return dateFormat.format(((Calendar) value).getTime());
        } catch (Exception e) {
            return null;
        }
    }

}
