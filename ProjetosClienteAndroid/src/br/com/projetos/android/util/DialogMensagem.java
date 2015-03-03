/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetos.android.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;

/**
 * @author gilmario
 */
public class DialogMensagem {

    public void mensagemSimples(Context context, String mensagem) {
        Toast.makeText(context, mensagem, Toast.LENGTH_SHORT).show();
    }

    public void mensagemDialogConfirmacao(Context context, String mensagem, DialogInterface.OnClickListener listener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(mensagem);
        builder.setTitle("Confirmação");
        builder.setPositiveButton("Sim", listener);
        builder.setNegativeButton("Não", listener);
        builder.create().show();
    }

    public void mensagemDialogOK(Context context, String mensagem, DialogInterface.OnClickListener listener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(mensagem);
        builder.setTitle("Informação");
        builder.setPositiveButton("OK", listener);
        builder.create().show();
    }

    public void mensagemDialogOK(Context context, String mensagem, String titulo, String tipo) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(mensagem).setTitle(titulo).setPositiveButton("OK", null).create().show();
    }

    public void mensagemDialogOK(Context context, String titulo, String mensagem, DialogInterface.OnClickListener listener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(mensagem);
        builder.setTitle(titulo);
        builder.setPositiveButton("OK", listener);
        builder.create().show();
    }

    public void optionDialog(Context c, DialogInterface.OnClickListener listener, String[] itens, String titulo) {
        new AlertDialog.Builder(c)
                .setTitle(titulo)
                .setItems(itens, listener)
                .create().show();
    }
}
