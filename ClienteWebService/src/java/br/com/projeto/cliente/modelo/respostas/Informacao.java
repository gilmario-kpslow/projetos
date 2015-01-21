package br.com.projeto.cliente.modelo.respostas;

/**
 *
 * @author gilmario
 */
public class Informacao {

    private TipoMensagem tipo;
    private String titulo;
    private String conteudo;

    public Informacao() {
    }

    public Informacao(String titulo) {
        this.titulo = titulo;
        this.tipo = TipoMensagem.INFORMACAO;
    }

    public Informacao(String titulo, String conteudo) {
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.tipo = TipoMensagem.INFORMACAO;
    }

    public Informacao(TipoMensagem tipo, String titulo, String conteudo) {
        this.tipo = tipo;
        this.titulo = titulo;
        this.conteudo = conteudo;
    }

    public TipoMensagem getTipo() {
        return tipo;
    }

    public void setTipo(TipoMensagem tipo) {
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

}
