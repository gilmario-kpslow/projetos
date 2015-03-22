/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.cliente.modelo.respostas;

import br.com.projeto.cliente.modelo.projeto.RegraNegocio;
import java.util.List;

/**
 *
 * @author gilmario
 */
public class InformacaoConsultaRegraNegocio extends Informacao {

    public InformacaoConsultaRegraNegocio() {
    }

    public InformacaoConsultaRegraNegocio(TipoMensagem tipo, String titulo, String conteudo) {
        super(tipo, titulo, conteudo);
    }

    private List<RegraNegocio> regraNegocios;

    public List<RegraNegocio> getRegraNegocios() {
        return regraNegocios;
    }

    public void setRegraNegocios(List<RegraNegocio> regraNegocios) {
        this.regraNegocios = regraNegocios;
    }

}
