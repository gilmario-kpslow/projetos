/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.cliente.modelo.respostas;

import br.com.projeto.cliente.modelo.projeto.Modulo;
import br.com.projeto.cliente.modelo.projeto.Projeto;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gilmario
 */
@XmlRootElement
public class InformacaoConsultaModulo extends Informacao {

    public InformacaoConsultaModulo() {
    }

    public InformacaoConsultaModulo(TipoMensagem tipo, String titulo, String conteudo) {
        super(tipo, titulo, conteudo);
    }

    private List<Modulo> modulos;

    public List<Modulo> getModulos() {
        return modulos;
    }

    public void setModulos(List<Modulo> modulos) {
        this.modulos = modulos;
    }

}
