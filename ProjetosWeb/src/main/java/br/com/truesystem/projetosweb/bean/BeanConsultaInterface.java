package br.com.truesystem.projetosweb.bean;

import java.util.List;

/**
 *
 * @author gilmario
 * @param <T>
 */
public interface BeanConsultaInterface<T> {

    public void setLista(List<T> lista);

    public List getLista();

    public void buscar();

    public void busca();
}
