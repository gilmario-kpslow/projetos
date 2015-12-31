package br.com.truesystem.projetosweb.bean;

/**
 *
 * @author gilmario
 * @param <T>
 */
public interface BeanCadastroInterface<T> {

    public void salvar();

    public void atualizar();

    public void excluir();

}
