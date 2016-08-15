package br.dantonio808.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.dantonio808.model.Usuario;

/**
 * @author Diego
 * Classe que implementa os m�todos de inser��o e busca de usuarios
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
	 * M�todo que faz a inser��o de usuarios no banco.
	 * Retorna true caso a inser��o tenha ocorrido com sucesso
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
	 * caso n�o encontre,retorna null.
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
				u.setId(rs.getInt("idUsuario"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 
		 return u;
	}
	
}
