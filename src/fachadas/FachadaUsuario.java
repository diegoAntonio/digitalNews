package fachadas;

import java.util.List;

import model.Topico;
import model.Usuario;
import dao.TopicoDAO;
import dao.UsuarioDAO;


/**
 * @author Diego
 * Classe singleton que realiza os métodos que interagem com o banco
 * via DAO's
 */
public class FachadaUsuario {
	private UsuarioDAO usuarios;//dao que faz o processo de inserção dos usuarios.
	private TopicoDAO topicos;
	private static FachadaUsuario f;
	
	private FachadaUsuario(){
		super();
		usuarios = new UsuarioDAO();
		topicos = new TopicoDAO();
	}
	
	
	/**
	 * Método que passa a fachada para quem deseje utiliza-la.
	 * 
	 * @return f
	 */
	public static FachadaUsuario getInstance(){
		if(f == null){
			f = new FachadaUsuario();
		}
		
		return f;
	}
	
	/**
	 * @param login
	 * @param senha
	 * @return true ou false
	 * 
	 * metodo que faz a chamada para a funcao que autentica um usuario
	 * retorna true caso o usuario e senha estejam certo ou false
	 * caso o contrario.
	 */
	public boolean logar(String login,String senha){
		if(f.usuarios.buscar(login, senha) != null){
			 return true;
		 }else{
			 return false;
		 }
	}
	
	/**
	 * @param u
	 * @return true ou false
	 *  
	 *  Metodo que realiza o processo de insercao de um usuario no banco
	 *  faz a chamada no DAO e caso sucesso retorna true,senao false.
	 */
	public boolean inserirUsuario(Usuario u){
			if(u != null){
				return f.usuarios.inserirUsuario(u);
			}else{
				return false;
			}
	}
	
	
	public Usuario encontrarUsuario(String login,String senha){
		return usuarios.buscar(login, senha);
	}
	


}
