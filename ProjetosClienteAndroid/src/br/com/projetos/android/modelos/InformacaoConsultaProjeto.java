/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetos.android.modelos;

import br.com.projetos.android.util.anotacoes.XmlObject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gilmario
 */
@XmlObject(tagTipo = XmlObject.TipoDadoXML.COMPLEXO)
public class InformacaoConsultaProjeto extends Informacao {

    @XmlObject(tagTipo = XmlObject.TipoDadoXML.LISTA, tagName = "projetos")
    private ArrayList<Projeto> projetos;

    public InformacaoConsultaProjeto() {
    }

    public InformacaoConsultaProjeto(String titulo) {
        super(titulo);
    }

    public InformacaoConsultaProjeto(String titulo, String conteudo) {
        super(titulo, conteudo);
    }

    public InformacaoConsultaProjeto(TipoMensagem tipo, String titulo, String conteudo) {
        super(tipo, titulo, conteudo);
    }

    public ArrayList<Projeto> getProjetos() {
        return projetos;
    }

    public void setProjetos(ArrayList<Projeto> projetos) {
        this.projetos = projetos;
    }

}
