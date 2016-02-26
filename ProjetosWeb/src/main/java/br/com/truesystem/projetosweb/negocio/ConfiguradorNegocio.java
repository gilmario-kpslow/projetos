package br.com.truesystem.projetosweb.negocio;

import br.com.truesystem.projetosweb.dominio.Papel;
import br.com.truesystem.projetosweb.dominio.Responsavel;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author gilmario
 */
@Singleton
@Startup
public class ConfiguradorNegocio implements Serializable {

    @EJB
    private ResponsavelNegocio responsavelServico;
    private static final String ADMIN_LOGIN = "ProjetosAdmin";
    private static final String ADMIN_SENHA = "projetos";

    @PostConstruct
    private void iniciaConfiguracao() {
        Responsavel admin = responsavelServico.buscarPorLogin(ADMIN_LOGIN);
        if (admin == null) {
            admin = new Responsavel();
            admin.setLogin(ADMIN_LOGIN);
            admin.setEmail("");
            admin.setNomeCompleto("Administrador");
            admin.setSenha(ADMIN_SENHA);
            admin.addPapel(Papel.ROLE_ADMIN);
            admin.addPapel(Papel.ROLE_MASTER);
            responsavelServico.salvar(admin);
        }
    }

}
