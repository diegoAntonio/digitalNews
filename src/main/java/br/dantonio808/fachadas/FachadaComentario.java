package br.dantonio808.fachadas;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.dantonio808.dao.ComentarioDAO;
import br.dantonio808.model.Comentario;

/**
 *
 * @author Andy
 */
public class FachadaComentario {
    
    private final ComentarioDAO dao;
    private static FachadaComentario fachada;
    
    public FachadaComentario() {
        super();
        dao = new ComentarioDAO();
    }
    
    public static FachadaComentario getInstance() {
        if (fachada == null) {
            fachada = new FachadaComentario();
        }
        return fachada;
    }
    
    public boolean inserirComentario(Comentario comentario) {
        try {
            fachada.dao.inserirComentario(comentario);
        } catch (SQLException excecao) {
            Logger.getLogger(FachadaComentario.class.getName()).log(Level.SEVERE, null, excecao);
        }
        return true;
    }
    
    public List<Comentario> listarComentarios(int identificadorDaNoticia) {
        return (fachada.dao.listarComentarios(identificadorDaNoticia));
    }
    
    public boolean excluirComentario(int identificador) {
        return (fachada.dao.excluirComentario(identificador));
    }
    
    public boolean excluirComentariosDaNoticia(int identificadorDaNoticia) {
        return (fachada.dao.excluirComentariosDaNoticia(identificadorDaNoticia));
    }
    
    public List<Comentario> listarTodosOsComentarios() {
        return (fachada.dao.listarTodosOsComentarios());
    }
    
    public List<Comentario> listarTodosOsComentariosBloqueados() {
        return(fachada.dao.listarTodosOsComentariosBloqueados());
    }
    
}
