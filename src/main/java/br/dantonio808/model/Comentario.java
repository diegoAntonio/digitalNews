package br.dantonio808.model;

import java.util.Date;

/**
 *
 * @author Andy
 */

public class Comentario {

    private int identificador;
    private int idUsuario;
    private int idNoticia;
    private String conteudo;
    private Date dataDePublicacao;
    private boolean estaBloqueado;
    
    
    /**
     * Creates a new instance of Comentario
     */
    public Comentario() {
        super();
    }
    
    public Comentario(int identificador, int idUsuario, int idNoticia, 
            String conteudo, Date dataDePublicacao, boolean estaBloqueado) {
        this.identificador = identificador;
        this.idUsuario = idUsuario;
        this.idNoticia = idNoticia;
        this.conteudo = conteudo;
        this.dataDePublicacao = dataDePublicacao;
        this.estaBloqueado = estaBloqueado;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdNoticia() {
        return idNoticia;
    }

    public void setIdNoticia(int idNoticia) {
        this.idNoticia = idNoticia;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Date getDataDePublicacao() {
        return dataDePublicacao;
    }

    public void setDataDePublicacao(Date dataDePublicacao) {
        this.dataDePublicacao = dataDePublicacao;
    }

    public boolean isEstaBloqueado() {
        return estaBloqueado;
    }

    public void setEstaBloqueado(boolean estaBloqueado) {
        this.estaBloqueado = estaBloqueado;
    }

}
