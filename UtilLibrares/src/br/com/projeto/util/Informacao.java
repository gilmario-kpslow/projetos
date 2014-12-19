package br.com.projeto.util;

/**
 *
 * @author gilmario
 * @param <T>
 */
public class Informacao<T> {

    private TipoMensagem tipo;
    private String titulo;
    private String conteudo;
    private T complemento;

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

    public T getComplemento() {
        return complemento;
    }

    public void setComplemento(T complemento) {
        this.complemento = complemento;
    }

}
