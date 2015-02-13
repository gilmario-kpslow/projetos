/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.util;

import br.com.projeto.modelo.projeto.Atividade;
import java.util.List;

/**
 *
 * @author gilmario
 */
public class InformacaoConsultaAtividade extends Informacao {

    private List<Atividade> atividades;

    public InformacaoConsultaAtividade() {
    }

    public InformacaoConsultaAtividade(TipoMensagem tipo, String titulo, String conteudo) {
        super(tipo, titulo, conteudo);
    }

    public List<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(List<Atividade> atividades) {
        this.atividades = atividades;
    }

}
