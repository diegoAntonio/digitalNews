package br.dantonio808.fachadas;

import br.dantonio808.dao.DenunciaDAO;
import br.dantonio808.model.Denuncia;

/**
 *
 * @author Andy
 */
public class FachadaDenuncia {
    
    private final DenunciaDAO dao;
    private static FachadaDenuncia fachada;
    
    public FachadaDenuncia() {
        super();
        dao = new DenunciaDAO();
    }

    public static FachadaDenuncia getInstance() {
        if (fachada == null) {
            fachada = new FachadaDenuncia();
        }
        return fachada;
    }
    
    public void denunciarNoticia(Denuncia denuncia){
       fachada.dao.denunciarNoticia(denuncia);
    }
    
    public void retirarDenuncia(int identificador) {
        fachada.dao.retirarDenuncia(identificador);
    }
    
}
