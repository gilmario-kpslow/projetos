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
public class InformacaoConsultaFuncionalidade extends Informacao {

    @XmlObject(tagTipo = XmlObject.TipoDadoXML.LISTA, tagName = "funcionalidades")
    private ArrayList<Funcionalidade> funcionalidades;

    public InformacaoConsultaFuncionalidade() {
    }

    public InformacaoConsultaFuncionalidade(String titulo) {
        super(titulo);
    }

    public InformacaoConsultaFuncionalidade(String titulo, String conteudo) {
        super(titulo, conteudo);
    }

    public InformacaoConsultaFuncionalidade(TipoMensagem tipo, String titulo, String conteudo) {
        super(tipo, titulo, conteudo);
    }

    public ArrayList<Funcionalidade> getFuncionalidades() {
        return funcionalidades;
    }

    public void setFuncionalidades(ArrayList<Funcionalidade> funcionalidades) {
        this.funcionalidades = funcionalidades;
    }

}
