package br.com.projetos.android.activity.projeto;

import static android.content.Context.NSD_SERVICE;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import br.com.projetos.android.R;
import br.com.projetos.android.ServerActivity;
import br.com.projetos.android.lista.ModuloListFragment;
import br.com.projetos.android.modelos.Informacao;
import br.com.projetos.android.modelos.InformacaoConsultaModulo;
import br.com.projetos.android.modelos.Modulo;
import br.com.projetos.android.modelos.Projeto;
import br.com.projetos.android.modelos.TipoMensagem;
import br.com.projetos.android.modelos.converter.ConverterModulo;
import br.com.projetos.android.service.ExecutaService;
import br.com.projetos.android.service.ModuloService;
import br.com.projetos.android.util.DialogMensagem;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author gilmario
 */
public class ModuloConsultaActivity extends ServerActivity implements AdapterView.OnItemClickListener {

    private Projeto projeto;
    private ModuloService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        service = new ModuloService(getServidor());
        projeto = new Projeto();
        projeto.setId(getVariavelLong(AdminProjetoActivity.PROJETO_SELECIONADO_ID));
        projeto.setNome(getVariavelString(AdminProjetoActivity.PROJETO_SELECIONADO_NOME));
        this.setContentView(R.layout.modulo_consulta);
        listar(null);
    }

    private void novo() {
        startActivity(new Intent(this, ModuloActivity.class));
    }

    private void mostraLista(ArrayList<Modulo> modulos) {
        if (modulos.isEmpty()) {
            new DialogMensagem().mensagemDialogOK(this, "Nenhum resultado encontrado", "Atenção", "");
        } else {
            ModuloListFragment fragment = (ModuloListFragment) getFragmentManager().findFragmentByTag("lista");
            fragment.listar(modulos);
        }
    }

    public void listar(View view) {
        new ExecutaService<InformacaoConsultaModulo>(this) {

            @Override
            protected InformacaoConsultaModulo doInBackground(Void... on) {
                try {
                    return service.listarModulo(projeto);
                } catch (Exception e) {
                    Log.e("ERRO", "Erro ao Listar", e);
                    return new InformacaoConsultaModulo(TipoMensagem.ERRO, "ERRO", e.toString());
                }
            }

            @Override
            protected void onPostExecute(InformacaoConsultaModulo informacao) {
                if (TipoMensagem.SUCESSO.equals(informacao.getTipo())) {
                    mostraLista(informacao.getModulos());
                } else {
                    new DialogMensagem().mensagemDialogOK(ModuloConsultaActivity.this, informacao.getConteudo(), informacao.getTitulo(), "sucesso");
                }
            }
        }.execute();
    }

    public void onItemClick(AdapterView<?> adapter, View arg1, int arg2, long arg3) {
        final Map<String, Object> map = (Map<String, Object>) adapter.getAdapter().getItem(arg2);
        final Modulo modulo = new ConverterModulo().converter(map);
        new DialogMensagem().optionDialog(this, new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface arg0, int opcao) {
                switch (opcao) {
                    case 0:
                        inicializaModulo(modulo);
                        break;
                    case 1:
                        editarModulo(modulo);
                        break;
                    case 2:
                        desejaRemoverModulo(modulo);
                        break;
                }
            }

        }, getResources().getStringArray(R.array.opcoes_dialog), getResources().getString(R.string.opcoes_dialog_titulo));
    }

    private void inicializaModulo(Modulo modulo) {
        setVariavel(AdminModuloActivity.MODULO_SELECIONADO_NOME, modulo.getNome());
        setVariavel(AdminModuloActivity.MODULO_SELECIONADO_ID, modulo.getId());
        startActivity(new Intent(this, AdminModuloActivity.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.projeto_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        if (item.getItemId() == R.id.menu_novo_projeto) {
            novo();
        } else if (item.getItemId() == R.id.menu_sair) {
            finish();
        }
        return super.onMenuItemSelected(featureId, item);
    }

    private void editarModulo(Modulo modulo) {
        Intent intent = new Intent(this, ModuloActivity.class);
        intent.putExtra(ModuloActivity.MODULO_ID, modulo);
        startActivity(intent);
    }

    private void desejaRemoverModulo(final Modulo modulo) {
        new DialogMensagem().mensagemDialogConfirmacao(this, getResources().getString(R.string.mensagem_excluir_registro), new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface arg0, int arg1) {
                if (arg1 == DialogInterface.BUTTON_POSITIVE) {
                    removerModulo(modulo);
                }
            }
        });
    }

    private void removerModulo(final Modulo modulo) {
        new ExecutaService<Informacao>(this) {

            @Override
            protected Informacao doInBackground(Void... arg0) {
                try {
                    return service.removeModulo(modulo);
                } catch (Exception e) {
                    Log.e("ERROX", "Erro ao Listar", e);
                    return new Informacao(TipoMensagem.ERRO, "ERRO", e.toString());
                }
            }
        }.execute();
    }

}
