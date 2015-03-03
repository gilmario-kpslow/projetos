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
public class InformacaoRegraNegocio extends Informacao {

    @XmlObject(tagName = "regraNegocio", tagTipo = XmlObject.TipoDadoXML.COMPLEXO)
    private RegraNegocio complemento;

    public InformacaoRegraNegocio() {
    }

    public InformacaoRegraNegocio(String titulo) {
        super(titulo);
    }

    public InformacaoRegraNegocio(String titulo, String conteudo) {
        super(titulo, conteudo);
    }

    public InformacaoRegraNegocio(TipoMensagem tipo, String titulo, String conteudo) {
        super(tipo, titulo, conteudo);
    }

    public RegraNegocio getComplemento() {
        return complemento;
    }

    public void setComplemento(RegraNegocio complemento) {
        this.complemento = complemento;
    }

}
