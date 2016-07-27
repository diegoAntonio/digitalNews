package fachadas;

import dao.NoticiaDAO;
import java.sql.SQLException;
import java.util.List;
import model.Noticia;

/**
 *
 * @author Andy
 */
public class FachadaNoticia {
    
    private NoticiaDAO dao;
    private static FachadaNoticia fachada;
    
    public FachadaNoticia() {
        super();
        dao = new NoticiaDAO();        
    }
    
    public static FachadaNoticia getInstance() {
        if (fachada == null) {
            fachada = new FachadaNoticia();
        }
        return fachada;
    }
    
    public boolean inserirNoticia(Noticia noticia){
        return (fachada.dao.inserir(noticia));
    }
    
    public boolean deletarNoticia(int codigoNoticia) throws SQLException {
    			FachadaComentario.getInstance().excluirComentariosDaNoticia(codigoNoticia);
				FachadaDenuncia.getInstance().retirarDenuncia(codigoNoticia);
    			return (fachada.dao.deletarNoticia(codigoNoticia));
    }
    
    public List<Noticia> listarTodasAsNoticiasDoUsuario(int codigoUsuario) {
        List<Noticia> lista;
        lista = fachada.dao.listarTodasAsNoticiasDoUsuario(codigoUsuario);
        
        for(int i = 0;i < lista.size(); i++){
        	corrigirAvaliacoes(lista.get(i));
        }
        
        return lista;
    }
    
    public List<Noticia> listarNoticiasBloqueadas() {
        List<Noticia> lista;
        lista = fachada.dao.listarNoticiasBloqueadas();
        return lista;
    }
    
    public List<Noticia> listarNoticiasMaisBemAvaliadas() {
        List<Noticia> lista;
        lista = fachada.dao.listarNoticiasMaisBemAvaliadas();
        
        for(int i = 0;i < lista.size(); i++){
        	corrigirAvaliacoes(lista.get(i));
        }
        return lista;
    }
    
    public boolean desbloquearNoticia(int identificador){
        return (fachada.dao.desbloquearNoticia(identificador));
    }
    
    public Noticia buscarNoticiaUsuarioLogado(int identificador) {
        Noticia n = fachada.dao.buscarNoticiaUsuarioLogado(identificador);
        corrigirAvaliacoes(n);        
        return n;
    }
    
    
    public boolean editarNoticia(Noticia noticia){
    	return (fachada.dao.editarNoticia(noticia));
    }
    
    public List<Noticia> listarTodasAsNoticias(){
        List<Noticia> lista = fachada.dao.listarTodasAsNoticias();
        
        for(int i = 0;i < lista.size(); i++){
        	corrigirAvaliacoes(lista.get(i));
        }
        
        return lista;
    }
    
    public List<Noticia> listarNoticiasDenunciadas() {
    	 List<Noticia> lista = fachada.dao.listarNoticiasDenunciadas();
    	 
    	 for(int i = 0;i < lista.size(); i++){
         	corrigirAvaliacoes(lista.get(i));
         }
         
         return lista;
    }
    
    public boolean avaliarNoticia(int codigoNoticia,int avaliacao){
    	return (fachada.dao.atualizarAvaliacao(codigoNoticia, avaliacao));
    }
    
    private void corrigirAvaliacoes(Noticia noticia){
    	if(noticia != null){
	    	if(noticia.getAvaliacao() > 5){
	    		noticia.setAvaliacao(noticia.getAvaliacao()/5);
	    	}
    	}
    }
}