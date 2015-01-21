/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.cliente.modelo.respostas;

import br.com.projeto.cliente.modelo.Responsavel;
import java.util.List;

/**
 *
 * @author gilmario
 */
public class InformacaoConsultaResponsavel extends Informacao {

    public InformacaoConsultaResponsavel() {
    }

    public InformacaoConsultaResponsavel(TipoMensagem tipo, String titulo, String conteudo) {
        super(tipo, titulo, conteudo);
    }

    private List<Responsavel> responsaveis;

    public List<Responsavel> getResponsaveis() {
        return responsaveis;
    }

    public void setResponsaveis(List<Responsavel> responsaveis) {
        this.responsaveis = responsaveis;
    }

}
