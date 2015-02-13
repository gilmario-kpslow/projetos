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
public class InformacaoModulo extends Informacao {

    @XmlObject(tagName = "modulo", tagTipo = XmlObject.TipoDadoXML.COMPLEXO)
    private Modulo complemento;

    public InformacaoModulo() {
    }

    public InformacaoModulo(String titulo) {
        super(titulo);
    }

    public InformacaoModulo(String titulo, String conteudo) {
        super(titulo, conteudo);
    }

    public InformacaoModulo(TipoMensagem tipo, String titulo, String conteudo) {
        super(tipo, titulo, conteudo);
    }

    public Modulo getComplemento() {
        return complemento;
    }

    public void setComplemento(Modulo complemento) {
        this.complemento = complemento;
    }

}
