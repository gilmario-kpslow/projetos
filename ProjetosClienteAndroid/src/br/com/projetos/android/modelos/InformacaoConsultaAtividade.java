/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetos.android.modelos;

import br.com.projetos.android.util.anotacoes.XmlObject;
import java.util.ArrayList;

/**
 *
 * @author gilmario
 */
@XmlObject(tagTipo = XmlObject.TipoDadoXML.COMPLEXO)
public class InformacaoConsultaAtividade extends Informacao {

    @XmlObject(tagTipo = XmlObject.TipoDadoXML.LISTA, tagName = "atividades")
    private ArrayList<Atividade> atividades;

    public InformacaoConsultaAtividade() {
    }

    public InformacaoConsultaAtividade(String titulo) {
        super(titulo);
    }

    public InformacaoConsultaAtividade(String titulo, String conteudo) {
        super(titulo, conteudo);
    }

    public InformacaoConsultaAtividade(TipoMensagem tipo, String titulo, String conteudo) {
        super(tipo, titulo, conteudo);
    }

    public ArrayList<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(ArrayList<Atividade> atividades) {
        this.atividades = atividades;
    }

}
