/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetos.android.util;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/**
 *
 * @author gilmario
 */
public class MascaraUtil {

    public static String criaMascaraCPF(String cpf) {
        return criaMarcara(cpf, "###.###.###-##");
    }

    public static String criaMascaraCNPJ(String cnpj) {
        return criaMarcara(cnpj, "##.###.###/####-##");
    }

    public static String criaMarcara(String valor, String mascara) {
        valor = removeMascara(valor);
        String retorno = "";
        int j = 0;
        if (valor.length() < mascara.replaceAll("[^#]", "").length()) {
            return valor;
        } else {
            for (int i = 0; i < mascara.length(); i++) {
                if (mascara.charAt(i) == '#') {
                    retorno = retorno.concat(valor.substring(j, ++j));
                } else {
                    retorno = retorno.concat(Character.toString(mascara.charAt(i)));
                }
            }
            return retorno;
        }
    }

    public static String removeMascara(String valor) {
        return valor.replaceAll("[^0-9 || ^a-z || ^A-Z ]", "");
    }

    public static TextWatcher getEditMascaraCnpj(final EditText edit) {
        return new TextWatcher() {
            boolean atualizado;

            public void beforeTextChanged(CharSequence cs, int i, int i1, int i2) {
            }

            public void onTextChanged(CharSequence cs, int i, int i1, int i2) {
                if (atualizado) {
                    atualizado = false;
                    return;
                }
                atualizado = true;
                String res = MascaraUtil.criaMascaraCNPJ(cs.toString());
                edit.setText(res);
                edit.setSelection(res.length());
            }

            public void afterTextChanged(Editable edtbl) {
            }
        };

    }
}
