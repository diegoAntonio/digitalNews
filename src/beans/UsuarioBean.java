package beans;

import javax.faces.bean.ManagedBean;

import fachadas.FachadaUsuario;
import model.Usuario;


/**
 * @author Diego
 *
 * Managed Bean que realiza o processo de cadastro de um usuário.
 * Ele Recebe parametros de uma página e insere de acordo com o  que foi passado e chama 
 * a fachada que insere os dados no banco.
 * 
 */
@ManagedBean(name="userB")
public class UsuarioBean {
	private Usuario user;//usuario que representa o usuario do sistema.
	private FachadaUsuario f;//fachada que irá inserir os dados no banco
	
	public UsuarioBean() {
		super();
		this.user = new Usuario();
		this. f = FachadaUsuario.getInstance();
	}
	
	
	/**
	 * Método que inicia o processo de cadastro de um usuario
	 * no sistema.Faz as devidas validações e passa os dados
	 * para a camada inferior.
	 * 
	 * @return resultado
	 */
	public String cadastrarUsuario(){
			String resultado = "";
			
			if(user.getTipo() == 0){
				user.setTipo(3);
			}
			
			if(f.inserirUsuario(user)){
				resultado = "sucesso";
			}else{
				resultado = "falha";
				
			}
			
			return resultado;
	}
	

	public Usuario getUser() {
		return user;
	}


	public void setUser(Usuario user) {
		this.user = user;
	}


	public FachadaUsuario getF() {
		return f;
	}


	public void setF(FachadaUsuario f) {
		this.f = f;
	}
	
	
	
	
}
