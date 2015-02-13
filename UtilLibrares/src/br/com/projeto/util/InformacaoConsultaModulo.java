/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.util;

import br.com.projeto.modelo.projeto.Modulo;
import java.util.List;

/**
 *
 * @author gilmario
 */
public class InformacaoConsultaModulo extends Informacao {

    private List<Modulo> modulos;

    public InformacaoConsultaModulo() {
    }

    public InformacaoConsultaModulo(TipoMensagem tipo, String titulo, String conteudo) {
        super(tipo, titulo, conteudo);
    }

    public List<Modulo> getModulos() {
        return modulos;
    }

    public void setModulos(List<Modulo> modulos) {
        this.modulos = modulos;
    }

}
