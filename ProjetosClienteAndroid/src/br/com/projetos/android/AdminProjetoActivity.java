package br.com.projetos.android;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import br.com.projetos.android.modelos.InformacaoConsultaProjeto;
import br.com.projetos.android.modelos.Projeto;
import br.com.projetos.android.modelos.Responsavel;
import br.com.projetos.android.modelos.TipoMensagem;
import br.com.projetos.android.service.ProjetoService;
import br.com.projetos.android.util.DialogMensagem;
import java.util.ArrayList;

/**
 *
 * @author gilmario
 */
public class AdminProjetoActivity extends ServerActivity {

    public static final String RESPONSAVEL = "responsavel";
    private Responsavel reponsavel;
    private ProjetoService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        service = new ProjetoService(getServidor());
        this.reponsavel = (Responsavel) getIntent().getSerializableExtra(RESPONSAVEL);
        this.setContentView(R.layout.projeto_main);
        TextView text = (TextView) findViewById(R.id.usuario_nome);
        text.setText(reponsavel.getNomeCompleto());
    }

    public void novo(View view) {
        startActivity(new Intent(this, ProjetoActivity.class));
    }

    public void consultar(View view) {
        setContentView(R.layout.projeto_consulta);
    }

    private void mostraLista(ArrayList<Projeto> projetos) {
        if (projetos.isEmpty()) {
            new DialogMensagem().mensagemDialogOK(this, "Nenhum resultado encontrado", "Atenção", "");
        } else {
            setContentView(R.layout.projeto_consulta);
            Intent intent = new Intent(this, ProjetoListActivity.class);
            intent.putExtra(ProjetoListActivity.LISTA_DE_PROJETOS, projetos);
            startActivity(intent);
        }
    }

    public void listar(View view) {
        new AsyncTask<Void, Void, InformacaoConsultaProjeto>() {

            @Override
            protected InformacaoConsultaProjeto doInBackground(Void... on) {
                try {
                    return service.listarProjeto();
                } catch (Exception e) {
                    Log.e("ERROX", "Erro ao salvar", e);
                    return new InformacaoConsultaProjeto(TipoMensagem.ERRO, "ERRO", e.toString());
                }
            }

            @Override
            protected void onPostExecute(InformacaoConsultaProjeto informacao) {
                if (TipoMensagem.SUCESSO.equals(informacao.getTipo())) {
                    mostraLista(informacao.getProjeto());
                } else {
                    new DialogMensagem().mensagemDialogOK(AdminProjetoActivity.this, informacao.getConteudo(), informacao.getTitulo(), "sucesso");
                }
            }
        }.execute();
    }
}
