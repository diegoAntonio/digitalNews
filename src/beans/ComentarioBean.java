package beans;

import fachadas.FachadaComentario;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import model.Comentario;
import model.Usuario;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Andy
 */
@ManagedBean
@RequestScoped
public class ComentarioBean {

    private int id;
    private Comentario comentario;
    private final FachadaComentario fachada;
    private Usuario usuario;
        
    /**
     * Creates a new instance of Comentario
     */
    public ComentarioBean() {
        super();
        this.comentario = new Comentario();
        HttpSession sessao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        this.usuario = ((Usuario) sessao.getAttribute("usuario"));
        comentario.setIdUsuario(2);        
        //comentario.setIdUsuario(usuario.getId());
        this.fachada = FachadaComentario.getInstance();
    }

    public Comentario getComentario() {
        return comentario;
    }

    public void setComentario(Comentario comentario) {
        this.comentario = comentario;
    }

    public FachadaComentario getFachada() {
        return fachada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
   
    public boolean inserirComentario() {
        return (this.fachada.inserirComentario(comentario));
    }
    
    public boolean excluirComentario() {
        return (this.fachada.excluirComentario(id));
    }
    
    public List<Comentario> listarComentariosDaNoticia(int identificadorNoticia) {
        List<Comentario> lista;
        lista = this.fachada.listarComentarios(identificadorNoticia);
        return lista;
    }
    
    public boolean excluirComentariosDaNoticia(int identificadorNoticia) {
        return (this.fachada.excluirComentariosDaNoticia(identificadorNoticia));
    }
    
    public List<Comentario> listarTodosOsComentarios() {
        List<Comentario> lista;
        lista = this.fachada.listarTodosOsComentarios();
        return lista;
    }
    
    public List<Comentario> listarTodosOsComentariosBloqueados() {
        List<Comentario> lista;
        lista = this.fachada.listarTodosOsComentariosBloqueados();
        return lista;
    }
    
    
}