package teste;

import dao.UsuarioDAO;
import model.Usuario;

public class InsercaoAdmin {

	public static void main(String[] args) {
		Usuario admin = new Usuario();
		UsuarioDAO dao = new UsuarioDAO();
		
		admin.setLogin("admin");
		admin.setSenha("12345");
		admin.setTipo(1);
		
		dao.inserirUsuario(admin);
	}

}
