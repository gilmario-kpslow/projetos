/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetos.android.util;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author gilmario
 */
public class FormaterUtil {

    private static final SimpleDateFormat formataData;
    private static final SimpleDateFormat formataDataTempo;

    static {
        formataData = new SimpleDateFormat("dd/MM/yyyy", new Locale("pt", "BR"));
        formataDataTempo = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", new Locale("pt", "BR"));

    }

    public static Date converteData(String texto) throws ParseException {
        if (texto == null) {
            return null;
        } else if (texto.equals("")) {
            return null;
        } else {
            return formataData.parse(texto);
        }
    }

    public static String dataParaString(Date data) throws ParseException {
        if (data == null) {
            return "";
        } else {
            return formataData.format(data);
        }
    }

    public static Date converteDataTime(String texto) throws ParseException {
        if (texto == null) {
            return null;
        } else if (texto.equals("")) {
            return null;
        } else {
            return formataDataTempo.parse(texto);
        }
    }

    public static String dataTimeParaString(Date data) throws ParseException {
        if (data == null) {
            return "";
        } else {
            return formataDataTempo.format(data);
        }
    }
}
