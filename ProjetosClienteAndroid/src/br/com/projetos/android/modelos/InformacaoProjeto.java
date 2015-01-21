/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetos.android.modelos;

import br.com.projetos.android.util.anotacoes.XmlObject;

/**
 *
 * @author gilmario
 */
@XmlObject(tagName = "mensagem", tagTipo = XmlObject.TipoDadoXML.COMPLEXO)
public class InformacaoProjeto extends Informacao {

    @XmlObject(tagName = "projeto", tagTipo = XmlObject.TipoDadoXML.COMPLEXO)
    private Projeto complemento;

    public InformacaoProjeto() {
    }

    public InformacaoProjeto(String titulo) {
        super(titulo);
    }

    public InformacaoProjeto(String titulo, String conteudo) {
        super(titulo, conteudo);
    }

    public InformacaoProjeto(TipoMensagem tipo, String titulo, String conteudo) {
        super(tipo, titulo, conteudo);
    }

    public Projeto getComplemento() {
        return complemento;
    }

    public void setComplemento(Projeto complemento) {
        this.complemento = complemento;
    }

}
