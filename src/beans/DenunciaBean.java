
package beans;

import fachadas.FachadaDenuncia;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import model.Denuncia;
import model.Usuario;

/**
 *
 * @author Andy
 */
@ManagedBean
@RequestScoped
public class DenunciaBean {

    private int identificadorNoticia;
    private Denuncia denuncia;
    private final FachadaDenuncia fachada;
    private Usuario usuario;
    
    /**
     * Creates a new instance of Denuncias
     */
    public DenunciaBean() {
        super();
        this.denuncia = new Denuncia();
        HttpSession sessao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        this.fachada = FachadaDenuncia.getInstance();
        this.usuario = ((Usuario) sessao.getAttribute("usuario"));
    }

    public Denuncia getDenuncia() {
        return this.denuncia;
    }

    public void setDenuncia(Denuncia denuncia) {
        this.denuncia = denuncia;
    }
    
    public FachadaDenuncia getFachada() {
        return this.fachada;
    }

    public int getIdentificadorNoticia() {
        return identificadorNoticia;
    }

    public void setIdentificadorNoticia(int identificadorNoticia) {
        this.identificadorNoticia = identificadorNoticia;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public void denunciarNoticia() {
        denuncia.setIdentificadorNoticia(identificadorNoticia);
        denuncia.setIdentificadorUsuario(usuario.getId());//valor anterior : 2.
        //denuncia.setIdentificadorUsuario(usuario.getId());
        this.fachada.denunciarNoticia(denuncia);
    }
    
    public void retirarDenuncia() {
        this.fachada.retirarDenuncia(identificadorNoticia);
    }
    
    
    
}
