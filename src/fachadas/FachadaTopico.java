package fachadas;

import dao.TopicoDAO;
import java.util.List;
import model.Topico;

/**
 *
 * @author Andy
 */
public class FachadaTopico {
    
    private TopicoDAO dao;
    private static FachadaTopico fachada;
    
    public FachadaTopico() {
        super();
        dao = new TopicoDAO();
    }
    
    public static FachadaTopico getInstance() {
        if(fachada == null){
            fachada = new FachadaTopico();
        }
        return fachada;
    }
    
    public List<Topico> listarTodasOsTopicos(){
        List<Topico> lista;
        lista = fachada.dao.listaDeTopicos();
        return lista;
    }
    
}

