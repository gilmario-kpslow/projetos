/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.cliente.modelo.respostas;

import br.com.projeto.cliente.modelo.projeto.Atividade;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gilmario
 */
@XmlRootElement
public class InformacaoConsultaAtividade extends Informacao {

    public InformacaoConsultaAtividade() {
    }

    public InformacaoConsultaAtividade(TipoMensagem tipo, String titulo, String conteudo) {
        super(tipo, titulo, conteudo);
    }

    private List<Atividade> atividades;

    public List<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(List<Atividade> atividades) {
        this.atividades = atividades;
    }

}
