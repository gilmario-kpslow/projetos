package br.com.truesystem.projetosweb.servico;

import java.io.Serializable;

/**
 *
 * @author gilmario
 * @param <T>
 */
public interface ServicoInterface<T> {

    public void excluir(T t) throws Exception;

    public void atualizar(T t) throws Exception;

    public void salvar(T t) throws Exception;

    public T carregar(Serializable pk);

}
