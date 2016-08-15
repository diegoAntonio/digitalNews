package br.dantonio808.beans;

import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.dantonio808.fachadas.FachadaNoticia;
import br.dantonio808.model.Noticia;

/**
 *
 * @author Andy
 */
@ManagedBean
@RequestScoped
public class EditarNoticiaBean {

    private int identificador;
    private final FachadaNoticia fachada;
    private Noticia noticiaEdicao;
        
    /**
     * Creates a new instance of EditarNoticia
     */
    public EditarNoticiaBean() {
        super();
        this.fachada = FachadaNoticia.getInstance();
    }
    
    public int getIdentificador() {
        return this.identificador;
    }
    
    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public Noticia getNoticiaEdicao() {
        return this.noticiaEdicao;
    }

    public void setNoticiaEdicao(Noticia noticiaEdicao) {
        this.noticiaEdicao = noticiaEdicao;
    }
    
    public boolean desbloquearNoticia() {
        return (fachada.desbloquearNoticia(this.identificador));
    }
    
    public boolean deletarNoticia() throws SQLException {
        return (fachada.deletarNoticia(this.identificador));
    }
    
    public void localizarNoticia() throws SQLException {
        this.noticiaEdicao = fachada.buscarNoticiaUsuarioLogado(this.identificador);
        System.out.println(noticiaEdicao.getConteudo());
    }
    
    //edicao de noticias novo
    public boolean editarNoticia() {
          return (this.fachada.editarNoticia(this.noticiaEdicao));  
    }
}

