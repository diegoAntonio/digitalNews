package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import model.Topico;
import fachadas.FachadaTopico;
import java.util.List;

/**
 *
 * @author Andy
 */
@ManagedBean
@RequestScoped
public class TopicoBean {
        
    private Topico topico;
    private FachadaTopico fachada;
    
    /**
     * Creates a new instance of TopicoBean
     */
    public TopicoBean() {
        super();
        this.topico = new Topico();
        this.fachada = FachadaTopico.getInstance();
    }

    public Topico getTopico() {
        return topico;
    }

    public void setTopico(Topico topico) {
        this.topico = topico;
    }

    public FachadaTopico getFachada() {
        return fachada;
    }

    public void setFachada(FachadaTopico fachada) {
        this.fachada = fachada;
    }

    public List<Topico> listaDeTopicos(){
        List<Topico> lista;
        lista = fachada.listarTodasOsTopicos();
        return lista;
    }
    
    
}
