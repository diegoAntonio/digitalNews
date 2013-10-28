package fachadas;

import model.Usuario;
import dao.UsuarioDAO;

public class FachadaUsuario {
	private UsuarioDAO dao;
	private static FachadaUsuario f;
	
	private FachadaUsuario(){
		super();
		dao = new UsuarioDAO();
	}
	
	
	public static FachadaUsuario getInstance(){
		if(f == null){
			f = new FachadaUsuario();
		}
		
		return f;
	}
	
	
	
	public boolean logar(String login,String senha){
		if(f.dao.buscar(login, senha) != null){
			 return true;
		 }else{
			 return false;
		 }
	}
	
	public boolean inserirUsuario(Usuario u){
			if(u != null){
				return f.dao.inserirUsuario(u);
			}else{
				return false;
			}
	}	
}
