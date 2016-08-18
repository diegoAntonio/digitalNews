package br.dantonio808.beans;

import java.sql.SQLException;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import br.dantonio808.fachadas.FachadaNoticia;
import br.dantonio808.model.Noticia;
import br.dantonio808.model.Topico;
import br.dantonio808.model.Usuario;

/**
 *
 * @author Andy
 */
@Named
@RequestScoped
public class NoticiaBean {

    private Noticia noticia;
    private Topico topicoSelecionado;
    private FachadaNoticia fachada;
    private Usuario user;
    
    /**
     * Creates a new instance of NoticiaBean
     */
    public NoticiaBean() {
        super();
        this.noticia = new Noticia();
        this.fachada = FachadaNoticia.getInstance();
        HttpSession sessao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        this.setUser((Usuario) sessao.getAttribute("usuario"));
    }
    
    public Noticia getNoticia() {
        return this.noticia;
    }
    
    public void setNoticia(Noticia noticia) {
        this.noticia = noticia;
    }
    
    public FachadaNoticia getFachada(){
        return this.fachada;
    }
    
    public void setFachada(FachadaNoticia fachada){
        this.fachada = fachada;
    }
    
    public Topico getTopicoSelecionado() {
        return this.topicoSelecionado;
    }
    
    public void setTopicoSelecionado(Topico topicoSelecionado) {
        this.topicoSelecionado = topicoSelecionado;
    }
    
    public String inserirNoticia() {
        String retorno;
        
        noticia.setCodigoUsuario(user.getId());
        if (fachada.inserirNoticia(noticia)) {
            retorno = "noticiasDoUsuario.jsf";
        } else {
            retorno = "erro";
        }
        return retorno;
    }
    
    public List<Noticia> listarTodasAsNoticiasDoUsuario(int codigoUsuario) { 
        List<Noticia> lista;
        lista = fachada.listarTodasAsNoticiasDoUsuario(codigoUsuario);
        
        return lista;
    }
    
    public List<Noticia> listarNoticiasBloqueadas() throws SQLException {
        List<Noticia> lista;
        lista = fachada.listarNoticiasBloqueadas();
        return lista;
    }
    
    public List<Noticia> listarNoticiasMaisBemAvaliadas() throws SQLException {
        List<Noticia> lista;
        lista = fachada.listarNoticiasMaisBemAvaliadas();
        return lista;
    }
    
    public List<Noticia> listarNoticiasDenunciadas() throws SQLException {
        List<Noticia> lista;
        lista = fachada.listarNoticiasDenunciadas();
        return lista;
    }
    
    public String metodoTeste(){
		return "/main.jsf";
	}
   
	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}
	
}
