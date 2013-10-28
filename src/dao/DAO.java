package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
	private static Connection con;
	
	static{
		iniciar();
	}
	
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
	
	public static Connection getConnection(){
			return con;
	}
	
	public static void fecharConnection(){
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
