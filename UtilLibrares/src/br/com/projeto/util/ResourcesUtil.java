/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.util;

import java.util.ResourceBundle;

/**
 *
 * @author gilmario
 */
public class ResourcesUtil {

    private final ResourceBundle budle;

    public ResourcesUtil(String arqu) {
        budle = ResourceBundle.getBundle(arqu);
    }

    public String getMensagem(String key) {
        if (budle.containsKey(key)) {
            return budle.getString(key);
        } else {
            return budle.getString("mensagem.padrao");
        }
    }
}
