package br.com.truesystem.projetosweb.dominio;

import br.com.truesystem.projetosweb.seguranca.RegraAdmin;
import br.com.truesystem.projetosweb.seguranca.RegraInterface;
import br.com.truesystem.projetosweb.seguranca.RegraMaster;
import br.com.truesystem.projetosweb.seguranca.RegraUsuario;

/**
 *
 * @author gilmario
 */
public enum Papel {

    ROLE_USUARIO(new RegraUsuario()), ROLE_ADMIN(new RegraAdmin()), ROLE_MASTER(new RegraMaster());

    private final RegraInterface regra;

    private Papel(RegraInterface regra) {
        this.regra = regra;
    }

    public String[] getRegras() {
        return regra.getRegras();
    }

}
