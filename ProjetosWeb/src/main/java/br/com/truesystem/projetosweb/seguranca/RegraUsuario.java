package br.com.truesystem.projetosweb.seguranca;

/**
 *
 * @author gilmario
 */
public class RegraUsuario implements RegraInterface {

    @Override
    public String[] getRegras() {
        return new String[]{"projeto", "gerenciar", "dashboard", "despesa", "competencias"};
    }

}
