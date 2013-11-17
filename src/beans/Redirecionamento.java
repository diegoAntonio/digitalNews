package beans;

import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
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
}
