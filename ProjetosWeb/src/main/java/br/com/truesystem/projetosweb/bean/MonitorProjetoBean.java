package br.com.truesystem.projetosweb.bean;

import br.com.truesystem.projetosweb.dominio.gerenciador.Atividade;
import br.com.truesystem.projetosweb.dominio.gerenciador.Funcionalidade;
import br.com.truesystem.projetosweb.dominio.gerenciador.Modulo;
import br.com.truesystem.projetosweb.dominio.gerenciador.Projeto;
import br.com.truesystem.projetosweb.dominio.gerenciador.RegraNegocio;
import br.com.truesystem.projetosweb.negocio.AtividadeNegocio;
import br.com.truesystem.projetosweb.negocio.FuncionalidadeNegocio;
import br.com.truesystem.projetosweb.negocio.ModuloNegocio;
import br.com.truesystem.projetosweb.negocio.RegraNegocioNegocio;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author gilmario
 */
@Named
@SessionScoped
public class MonitorProjetoBean implements Serializable {

    private Projeto projeto;
    private Modulo modulo;
    private Atividade atividade;
    private Funcionalidade funcionalidade;
    private List<Modulo> listaDeModulos;
    private List<Atividade> listaDeAtividades;
    private List<Funcionalidade> listaDeFuncionalidades;
    private List<RegraNegocio> pendentes;
    private List<RegraNegocio> andamento;
    private List<RegraNegocio> concluidas;
    @EJB
    private RegraNegocioNegocio regraNegocioNegocio;
    @EJB
    private ModuloNegocio moduloNegocio;
    @EJB
    private AtividadeNegocio atividadeNegocio;
    @EJB
    private FuncionalidadeNegocio funcionalidadeNegocio;

    public void iniciar() {
        listaDeModulos = moduloNegocio.buscar(projeto);
        listaDeAtividades = new ArrayList<>();
        listaDeFuncionalidades = new ArrayList<>();
    }

    public void selecionaModulo() {
        listaDeAtividades = atividadeNegocio.buscar(modulo);
        listaDeFuncionalidades.clear();
    }

    public void selecionaAtividade() {
        listaDeFuncionalidades = funcionalidadeNegocio.buscar(atividade);
    }

    public void selecionaFuncionalidade() {

    }

    public void listar() {
        pendentes = regraNegocioNegocio.regrasPendentes(projeto, modulo, atividade, funcionalidade);
        andamento = regraNegocioNegocio.regrasEmAndamento(projeto, modulo, atividade, funcionalidade);
        concluidas = regraNegocioNegocio.regrasConcluidas(projeto, modulo, atividade, funcionalidade);
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
        iniciar();
    }

    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

    public Funcionalidade getFuncionalidade() {
        return funcionalidade;
    }

    public void setFuncionalidade(Funcionalidade funcionalidade) {
        this.funcionalidade = funcionalidade;
    }

    public List<Modulo> getListaDeModulos() {
        return listaDeModulos;
    }

    public void setListaDeModulos(List<Modulo> listaDeModulos) {
        this.listaDeModulos = listaDeModulos;
    }

    public List<Atividade> getListaDeAtividades() {
        return listaDeAtividades;
    }

    public void setListaDeAtividades(List<Atividade> listaDeAtividades) {
        this.listaDeAtividades = listaDeAtividades;
    }

    public List<Funcionalidade> getListaDeFuncionalidades() {
        return listaDeFuncionalidades;
    }

    public void setListaDeFuncionalidades(List<Funcionalidade> listaDeFuncionalidades) {
        this.listaDeFuncionalidades = listaDeFuncionalidades;
    }

    public List<RegraNegocio> getPendentes() {
        return pendentes;
    }

    public void setPendentes(List<RegraNegocio> pendentes) {
        this.pendentes = pendentes;
    }

    public List<RegraNegocio> getAndamento() {
        return andamento;
    }

    public void setAndamento(List<RegraNegocio> andamento) {
        this.andamento = andamento;
    }

    public List<RegraNegocio> getConcluidas() {
        return concluidas;
    }

    public void setConcluidas(List<RegraNegocio> concluidas) {
        this.concluidas = concluidas;
    }

}
