package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Andy
 */
@ManagedBean
@RequestScoped
public class AvaliacaoBean {

    
    private int avaliacao;
    
    /**
     * Creates a new instance of AvaliacaoBean
     */
    public AvaliacaoBean() {
        
    }
    
    public int getAvaliacao() {
        return this.avaliacao;
    }
    
    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }
    
    
    
}

