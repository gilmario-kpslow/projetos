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
@XmlObject(tagName = "mensagem", tagTipo = XmlObject.TipoDadoXML.COMPLEXO)
public class InformacaoLista extends Informacao<ArrayList> {

    @XmlObject(tagName = "complemento", tagTipo = XmlObject.TipoDadoXML.LISTA)
    private ArrayList complemento;

    public InformacaoLista() {
    }

    public InformacaoLista(String titulo) {
        super(titulo);
    }

    public InformacaoLista(String titulo, String conteudo) {
        super(titulo, conteudo);
    }

    public InformacaoLista(TipoMensagem tipo, String titulo, String conteudo) {
        super(tipo, titulo, conteudo);
    }

    public ArrayList getComplemento() {
        return complemento;
    }

    public void setComplemento(ArrayList complemento) {
        this.complemento = complemento;
    }
}
