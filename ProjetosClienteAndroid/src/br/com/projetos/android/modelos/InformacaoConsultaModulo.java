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
public class InformacaoConsultaModulo extends Informacao {

    @XmlObject(tagTipo = XmlObject.TipoDadoXML.LISTA, tagName = "modulos")
    private ArrayList<Modulo> modulos;

    public InformacaoConsultaModulo() {
    }

    public InformacaoConsultaModulo(String titulo) {
        super(titulo);
    }

    public InformacaoConsultaModulo(String titulo, String conteudo) {
        super(titulo, conteudo);
    }

    public InformacaoConsultaModulo(TipoMensagem tipo, String titulo, String conteudo) {
        super(tipo, titulo, conteudo);
    }

    public ArrayList<Modulo> getModulos() {
        return modulos;
    }

    public void setModulos(ArrayList<Modulo> modulos) {
        this.modulos = modulos;
    }

}
