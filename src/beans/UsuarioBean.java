package beans;

import javax.faces.bean.ManagedBean;

import fachadas.FachadaUsuario;
import model.Usuario;


@ManagedBean(name="userB")
public class UsuarioBean {
	private Usuario user;
	private FachadaUsuario f;
	
	public UsuarioBean() {
		super();
		this.user = new Usuario();
		this. f = FachadaUsuario.getInstance();
		System.out.println("fim do construtor");
	}
	
	
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
	
	
	public String logar(){
			String retorno ="sucesso";
			
			return retorno;
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
