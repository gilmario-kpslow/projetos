package br.com.truesystem.projetosweb.dominio.gerenciador;

/**
 *
 * @author gilmario
 */
public enum StatusRegraNegocio {

    Pendente("bg-danger"), Andamento("bg-info"), Concluida("bg-success");

    private final String style;

    private StatusRegraNegocio(String style) {
        this.style = style;
    }

    public String getStyle() {
        return style;
    }

}
