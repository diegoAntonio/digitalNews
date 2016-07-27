package model;
import java.util.Date;

/**
 *
 * @author Andy
 */
public class Noticia {
    
    private int identificador;
    private int codigoTopico;
    private int codigoUsuario;
    private String titulo;
    private String conteudo;
    private Date dataDePublicacao;
    private boolean bloqueio;
    private int avaliacao;

    public Noticia() {
        
    }
    
    public Noticia(int identificador, int codigoTopico, int codigoUsuario, String titulo,
            String conteudo, Date dataDePublicacao, boolean bloqueio, int avaliacao) {
        this.identificador = identificador;
        this.codigoTopico = codigoTopico;
        this.codigoUsuario = codigoUsuario;
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.dataDePublicacao = dataDePublicacao;
        this.bloqueio = bloqueio;
        this.avaliacao = avaliacao;
    }
    
    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public int getCodigoTopico() {
        return this.codigoTopico;
    }

    public void setCodigoTopico(int codigoTopico) {
        this.codigoTopico = codigoTopico;
    }

    public int getCodigoUsuario() {
        return this.codigoUsuario;
    }

    public void setCodigoUsuario(int codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return this.conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Date getDataDePublicacao() {
        return this.dataDePublicacao;
    }

    public void setDataDePublicacao(Date dataDePublicacao) {
        this.dataDePublicacao = dataDePublicacao;
    }

    public boolean isBloqueio() {
        return this.bloqueio;
    }

    public void setBloqueio(boolean bloqueio) {
        this.bloqueio = bloqueio;
    }

    public int getAvaliacao() {
        return this.avaliacao;
    }

    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }
    
}
