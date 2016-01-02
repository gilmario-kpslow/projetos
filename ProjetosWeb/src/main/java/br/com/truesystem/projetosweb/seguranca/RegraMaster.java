package br.com.truesystem.projetosweb.seguranca;

/**
 *
 * @author gilmario
 */
public class RegraMaster implements RegraInterface {

    @Override
    public String[] getRegras() {
        return new String[]{"configuracoes"};
    }

}
