package beans;

import javax.faces.bean.ManagedBean;

import model.Usuario;


/**
 * @author Diego
 *	Bean que atende �s solicita��es do admin como cadastrar novos usuarios
 *	e cadastro/listar t�picos.
 */
@ManagedBean(name="admMB")
public class AdminBean {
	private Usuario admin;//usuario que representa o pr�prio admin
	private String nomeTopico;//String para o novo t�pico
	private Usuario novoUsuario;//novoUsuario que pode ser cadastrado no sistema.
	
	
	public AdminBean(){
		this.admin = new Usuario();
		this.nomeTopico = "";
		this.novoUsuario = new Usuario();
	}


	
	//Getters e Setters.
	public Usuario getAdmin() {
		return admin;
	}


	public void setAdmin(Usuario admin) {
		this.admin = admin;
	}


	public String getNomeTopico() {
		return nomeTopico;
	}


	public void setNomeTopico(String nomeTopico) {
		this.nomeTopico = nomeTopico;
	}


	public Usuario getNovoUsuario() {
		return novoUsuario;
	}


	public void setNovoUsuario(Usuario novoUsuario) {
		this.novoUsuario = novoUsuario;
	}
}
