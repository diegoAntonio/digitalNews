package beans;

import javax.faces.bean.ManagedBean;

import model.Usuario;


@ManagedBean
public class AdminBean {
	private Usuario admin;
	
	
	public AdminBean(){
		
	}


	public Usuario getAdmin() {
		return admin;
	}


	public void setAdmin(Usuario admin) {
		this.admin = admin;
	}
	
	
}
