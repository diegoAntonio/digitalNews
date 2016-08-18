package br.dantonio808.beans;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.dantonio808.fachadas.FachadaTopico;
import br.dantonio808.model.Topico;

/**
 *
 * @author Andy
 */
@Named
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
