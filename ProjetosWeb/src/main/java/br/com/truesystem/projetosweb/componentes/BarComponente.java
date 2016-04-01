package br.com.truesystem.projetosweb.componentes;

import java.io.IOException;
import java.util.Map;
import javax.el.ValueExpression;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

/**
 *
 * @author gilmario
 */
@FacesComponent(createTag = true, namespace = "http://truesystem.com.br", tagName = "barComponente", value = "legenda")
public class BarComponente extends UIComponentBase {

    private String legenda;
    private String percentual;

    public BarComponente() {
    }

    public String getLegenda() {
        return legenda;
    }

    public void setLegenda(String legenda) {
        this.legenda = legenda;
    }

    public String getPercentual() {
        return percentual;
    }

    public void setPercentual(String percentual) {
        this.percentual = percentual;
    }

    @Override
    public String getFamily() {
        return "br.com.truesystem";
    }

    @Override
    public void encodeBegin(FacesContext context) throws IOException {

        legenda = (String) getAttributes().get("legenda");
        percentual = (String) getAttributes().get("percentual").toString();

    }

    @Override
    public void encodeEnd(FacesContext context) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        writer.startElement("div", this);
        writer.writeAttribute("class", "progress", "class");
        writer.startElement("div", this);
        writer.writeAttribute("class", "progress-bar progress-bar-striped ".concat(getCor(Integer.parseInt(percentual))).concat(getActive()), "class");
        writer.writeAttribute("style", "width:".concat(percentual).concat("%"), "style");
        writer.startElement("span", this);
        writer.write(legenda);
        writer.endElement("span");
        writer.endElement("div");
        writer.endElement("div");
        writer.flush();
    }

    @Override
    public Object saveState(FacesContext context) {
        Object values[] = new Object[3];
        values[0] = super.saveState(context);
        values[1] = legenda;
        values[2] = percentual;
        return (values);
    }

    @Override
    public void restoreState(FacesContext context, Object state) {
        Object values[] = (Object[]) state;
        super.restoreState(context, values[0]);
        legenda = (String) values[1];
        percentual = (String) values[2];
    }

    private String getCor(Integer percentual) {
        if (percentual < 50) {
            return "progress-bar-danger";
        } else if (percentual < 100) {
            return "progress-bar-warning";
        } else {
            return "progress-bar-success";
        }
    }

    private String getActive() {
        return Integer.parseInt(percentual) < 100 ? " active " : "";
    }

    @Override
    public void decode(FacesContext context) {
        String key = "legenda";
        String value = (String) context.getExternalContext().getRequestParameterMap().get(key);
        if (value != null) {
            this.setLegenda(value);
        }
    }

    enum PropertyKeys {
        legenda, percentual;
    }

    public String getAlt() {
        return (String) getStateHelper().eval(PropertyKeys.legenda, null);
    }

    public void setAlt(String alt) {
        getStateHelper().put(PropertyKeys.legenda, alt);
    }

    public boolean isImmediate() {

        ValueExpression ve = getValueExpression("immediate");
        if (ve != null) {
            Boolean value = (Boolean) ve.getValue(
                    getFacesContext().getELContext());
            return (value.booleanValue());
        } else {
            return (false);
        }
    }
}
