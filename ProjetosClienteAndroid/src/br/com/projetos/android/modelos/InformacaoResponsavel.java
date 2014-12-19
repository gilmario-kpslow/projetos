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
public class InformacaoResponsavel extends Informacao {

    @XmlObject(tagName = "complemento", tagTipo = XmlObject.TipoDadoXML.COMPLEXO)
    private Responsavel complemento;

    public InformacaoResponsavel() {
    }

    public InformacaoResponsavel(String titulo) {
        super(titulo);
    }

    public InformacaoResponsavel(String titulo, String conteudo) {
        super(titulo, conteudo);
    }

    public InformacaoResponsavel(TipoMensagem tipo, String titulo, String conteudo) {
        super(tipo, titulo, conteudo);
    }

    public Responsavel getComplemento() {
        return complemento;
    }

    public void setComplemento(Responsavel complemento) {
        this.complemento = complemento;
    }

}
