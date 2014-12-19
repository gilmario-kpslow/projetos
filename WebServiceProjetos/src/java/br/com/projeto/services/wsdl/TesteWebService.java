package br.com.projeto.services.wsdl;

import br.com.projeto.util.Informacao;
import br.com.projeto.util.TipoMensagem;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author gilmario
 */
@WebService(targetNamespace = "projetos", name = "TesteWebService", serviceName = "teste")
public class TesteWebService {

    @WebMethod(operationName = "status")
    public Informacao status() {
        return new Informacao(TipoMensagem.INFORMACAO, "Status OK", "O Servidor se encontra acessivel. ");
    }

}
