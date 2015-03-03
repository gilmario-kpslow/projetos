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
public class InformacaoFuncionalidade extends Informacao {

    @XmlObject(tagName = "funcionalidade", tagTipo = XmlObject.TipoDadoXML.COMPLEXO)
    private Funcionalidade complemento;

    public InformacaoFuncionalidade() {
    }

    public InformacaoFuncionalidade(String titulo) {
        super(titulo);
    }

    public InformacaoFuncionalidade(String titulo, String conteudo) {
        super(titulo, conteudo);
    }

    public InformacaoFuncionalidade(TipoMensagem tipo, String titulo, String conteudo) {
        super(tipo, titulo, conteudo);
    }

    public Funcionalidade getComplemento() {
        return complemento;
    }

    public void setComplemento(Funcionalidade complemento) {
        this.complemento = complemento;
    }

}
