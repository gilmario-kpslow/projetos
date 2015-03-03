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
public class InformacaoConsultaRegraNegocio extends Informacao {

    @XmlObject(tagTipo = XmlObject.TipoDadoXML.LISTA, tagName = "regraNegocios")
    private ArrayList<RegraNegocio> regraNegocios;

    public InformacaoConsultaRegraNegocio() {
    }

    public InformacaoConsultaRegraNegocio(String titulo) {
        super(titulo);
    }

    public InformacaoConsultaRegraNegocio(String titulo, String conteudo) {
        super(titulo, conteudo);
    }

    public InformacaoConsultaRegraNegocio(TipoMensagem tipo, String titulo, String conteudo) {
        super(tipo, titulo, conteudo);
    }

    public ArrayList<RegraNegocio> getRegraNegocios() {
        return regraNegocios;
    }

    public void setRegraNegocios(ArrayList<RegraNegocio> regraNegocios) {
        this.regraNegocios = regraNegocios;
    }

}
