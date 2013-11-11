package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Usuario;

/**
 * @author Diego
 * Classe que implementa os métodos de inserção e busca de usuarios
 * no banco.
 */
public class UsuarioDAO {
	private Connection con;//conexao com o Banco
	
	public UsuarioDAO(){
		super();
		this.con = DAO.getConnection();
	}
	
	/**
	 * @param u
	 * @return resultado
	 * 
	 * Método que faz a inserção de usuarios no banco.
	 * Retorna true caso a inserção tenha ocorrido com sucesso
	 * ou false em caso de problemas.
	 */
	public boolean inserirUsuario(Usuario u){
		PreparedStatement state = null;
		boolean resultado = true;
		try {
			state = con.prepareStatement("INSERT INTO usuario (login,senha,cod_tipo) VALUES (?,MD5(?),?)"
										,Statement.RETURN_GENERATED_KEYS);
			state.setString(1,u.getLogin());
			state.setString(2, u.getSenha());
			state.setInt(3, u.getTipo());
			
			state.executeUpdate();
			
		} catch (SQLException e ) {
			// TODO Auto-generated catch block
			resultado = false;
			e.printStackTrace();
		}
		return resultado;
	}
	
	
	/**
	 * @param login
	 * @param senha
	 * @return u
	 * 
	 * Metodo que faz a busca de um usario
	 * de acordo com o login e senha passado.
	 * caso não encontre,retorna null.
	 */
	public Usuario buscar(String login, String senha){
		 Usuario u = null;
		 PreparedStatement state = null;
		 ResultSet rs = null;
		 
		 try {
			state = con.prepareStatement("SELECT * FROM usuario WHERE login = ? AND SENHA = MD5(?)"
					 					 ,Statement.RETURN_GENERATED_KEYS);
			
			state.setString(1, login);
			state.setString(2, senha);
			
			rs = state.executeQuery();
			
			if(rs.next()){
				u = new Usuario(rs.getNString("login"),rs.getNString("senha"));
				u.setTipo(rs.getInt("cod_tipo"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 return u;
	}
	
}
