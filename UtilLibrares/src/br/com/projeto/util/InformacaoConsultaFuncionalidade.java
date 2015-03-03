/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.util;

import br.com.projeto.modelo.Responsavel;
import br.com.projeto.modelo.projeto.Funcionalidade;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gilmario
 */
@XmlRootElement
public class InformacaoConsultaFuncionalidade extends Informacao {

    public InformacaoConsultaFuncionalidade() {
    }

    public InformacaoConsultaFuncionalidade(TipoMensagem tipo, String titulo, String conteudo) {
        super(tipo, titulo, conteudo);
    }

    private List<Funcionalidade> funcionalidades;

    public List<Funcionalidade> getFuncionalidades() {
        return funcionalidades;
    }

    public void setFuncionalidades(List<Funcionalidade> funcionalidades) {
        this.funcionalidades = funcionalidades;
    }

}
