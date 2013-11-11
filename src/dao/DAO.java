package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * @author Diego
 * Classe com metodos estaticos que cria a primeira conexao com o banco
 * para quem quiser utilizar solicitar a ela.
 */
public class DAO {
	private static Connection con;//variavel que representa a conexao com o banco.
	
	static{
		iniciar();
	}
	
	
	/**
	 * Metodo que inicia a conexao com o banco
	 * via JDBC.
	 */
	public static void iniciar(){
		String stringDeConexao = "jdbc:mysql://localhost/";
		String banco = "projetoweb3";
		String usuario = "root" ;
		String senha = "12345";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(stringDeConexao+banco,usuario,senha);
		} catch (ClassNotFoundException e) {
			System.out.println("Erro de Driver");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Erro de Conexao com o Banco");
			e.printStackTrace();
		}
	}
	
	
	/**
	 * @return con
	 * 
	 * Metodo que passa a conexao a qualquer classe DAO
	 * que precise se conectar ao banco.
	 */
	public static Connection getConnection(){
			return con;
	}
	
	
	/**
	 * Metodo que fecha a conexao com o banco
	 */
	public static void fecharConnection(){
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
