package br.dantonio808.beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.dantonio808.fachadas.FachadaUsuario;
import br.dantonio808.model.Usuario;


/**
 * @author Diego
 *
 * Managed Bean que realiza o processo de cadastro de um usu�rio.
 * Ele Recebe parametros de uma p�gina e insere de acordo com o  que foi passado e chama 
 * a fachada que insere os dados no banco.
 * 
 */
@Named(value="userB")
@RequestScoped
public class UsuarioBean {
	private Usuario user;//usuario que representa o usuario do sistema.
	private FachadaUsuario f;//fachada que ir� inserir os dados no banco
	
	public UsuarioBean() {
		super();
		this.user = new Usuario();
		this. f = FachadaUsuario.getInstance();
	}
	
	
	/**
	 * M�todo que inicia o processo de cadastro de um usuario
	 * no sistema.Faz as devidas valida��es e passa os dados
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
