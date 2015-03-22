/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetos.android.modelos.converter;

import br.com.projetos.android.modelos.Modulo;
import java.util.Map;

/**
 *
 * @author gilmario
 */
public class ConverterModulo {

    public Modulo converter(Map<String, Object> map) {
        Modulo modulo = new Modulo();
        modulo.setId((Long) map.get("id"));
        modulo.setDescricao((String) map.get("descricao"));
        modulo.setNome((String) map.get("nome"));
        return modulo;
    }
}
