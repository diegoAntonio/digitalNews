package beans;

import java.io.IOException;
import javax.faces.context.FacesContext;

/**
 *
 * @author Andy
 */
public class Redirecionamento {

    /**
     * Creates a new instance of Redirecionamento
     */
    public Redirecionamento() {
        
    }
    
    public void RedirecionarNoticias() throws IOException {
    	
        FacesContext.getCurrentInstance().getExternalContext().redirect("noticias.jsf");
    }
    
    public void redirecionarBloqueadas() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("noticiasBloqueadas.jsf");
    }
    
    public void RedirecionarEdicao() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("noticiasEditar.jsf");
    }
    
    public void redirecionarComentarios() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("comentariosTodos.jsf");
    }    
    
    public void redirecionarNoticiasDenunciadas() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("noticiasDenunciadas.jsf");
    }
    
    public void redirecionarNoticiasTodas() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("noticiasTodas.jsf");
    }
}
