/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetos.android.service;

import android.content.Context;
import android.os.AsyncTask;
import br.com.projetos.android.activity.projeto.ProjetoConsultaActivity;
import br.com.projetos.android.modelos.Informacao;
import br.com.projetos.android.util.DialogMensagem;

/**
 *
 * @author gilmario
 * @param <Info>
 */
public abstract class ExecutaService<Info extends Informacao> extends AsyncTask<Void, Void, Info> {

    private final Context context;

    public ExecutaService(Context c) {
        super();
        context = c;
    }

    @Override
    protected void onPostExecute(Informacao informacao) {
        new DialogMensagem().mensagemDialogOK(context, informacao.getConteudo(), informacao.getTitulo(), "sucesso");
    }

}
