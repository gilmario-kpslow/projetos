package br.com.truesystem.projetosweb.dominio;

/**
 *
 * @author gilmario
 */
public enum Papel {

    ROLE_USUARIO("carteira", "credito", "dashboard", "despesa", "competencias"), ROLE_ADMIN("usuario"), ROLE_MASTER("configuracoes");

    private final String[] regra;

    private Papel(String... regra) {
        this.regra = regra;
    }

    public String[] getRegra() {
        return regra;
    }

}
