/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetos.android.modelos.converter;

import br.com.projetos.android.modelos.Projeto;
import java.util.Map;

/**
 *
 * @author gilmario
 */
public class ConverterProjeto {

    public Projeto converterProjeto(Map<String, Object> map) {
        Projeto projeto = new Projeto();
        projeto.setId((Long) map.get("id"));
        projeto.setDescricao((String) map.get("descricao"));
        projeto.setNome((String) map.get("nome"));
        return projeto;
    }
}
