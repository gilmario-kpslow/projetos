package br.com.truesystem.projetosweb.negocio;

import java.io.Serializable;

/**
 *
 * @author gilmario
 * @param <T>
 */
public interface NegocioInterface<T> {

    public void excluir(T t) throws Exception;

    public T atualizar(T t) throws Exception;

    public void salvar(T t) throws Exception;

    public T carregar(Serializable pk);

    public T gerenciar(Serializable pk);

    public void refresh(T t);

}
