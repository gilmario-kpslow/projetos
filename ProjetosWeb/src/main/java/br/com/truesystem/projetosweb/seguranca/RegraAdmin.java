package br.com.truesystem.projetosweb.seguranca;

/**
 *
 * @author gilmario
 */
public class RegraAdmin implements RegraInterface {

    @Override
    public String[] getRegras() {
        return new String[]{"responsavel"};
    }

}
