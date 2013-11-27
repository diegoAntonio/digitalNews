package beans;

import java.util.List;

import fachadas.FachadaNoticia;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import model.Noticia;

/**
 *
 * @author Andy
 */
@ManagedBean
@RequestScoped
public class VisualizarNoticiaBean {

    private FachadaNoticia fachada;
    private int identificador;
    private Noticia lista;
    
    /**
     * Creates a new instance of VisualizarNoticiaBean
     */
    public VisualizarNoticiaBean() {
        super();
        this.fachada = FachadaNoticia.getInstance();
    }
    
    public FachadaNoticia getFachada() {
        return this.fachada;
    }
    
    public void setFachada(FachadaNoticia fachada) {
        this.fachada = fachada;
    }
    
    public int getIdentificador(){
        return this.identificador;
    }
    
    public void setIdentificador(int identificador){
        this.identificador = identificador;
    }
    
    public Noticia buscarNoticiaUsuarioLogado() {
        Noticia noticia;
        noticia = fachada.buscarNoticiaUsuarioLogado(this.identificador);
        return noticia;
    }

    public Noticia getLista() {
        return lista;
    }

    public void setLista(Noticia lista) {
       this.lista = lista;
    }
    
    public List<Noticia> buscarTodasAsNoticias() {
        List<Noticia> listaDeNoticias;
        listaDeNoticias = fachada.listarTodasAsNoticias();
        return listaDeNoticias;
    }
    
    
}
