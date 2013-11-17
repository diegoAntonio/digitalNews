package beans;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fachadas.FachadaUsuario;
import model.Usuario;



/**
 * @author Diego
 * Managed Bean que realiza o processo do login do usuario.
 * Possui um usuario para utilizar no processo
 * e dois métodos logar e deslogar
 */

@ManagedBean(name="LoginMB")
public class LoginBean {
	private Usuario user;
	private ResourceBundle bundle;
	
	public LoginBean() {
		super();
		this.user = new Usuario();
		this.bundle = this.carregarBundle();
	}


	/**
	 * @author Diego
	 * @return resultado
	 *
	 * Método que faz o procedimento de logar,
	 * primeiro checa se o usuario digitou valores válidos 
	 * e solicita a fachada para que autentique,
	 * é responsável pelas mensagens de erro que voltarão à página de login
	 * em casos de erros.
	 */
	public String logarUsuario(){
		String resultado = "";
		boolean erro = false;
		FacesMessage msg = null;
		FacesContext contexto = FacesContext.getCurrentInstance();
		
		if(!validarCampo(user.getLogin())){
			//carregar msg de erro de login
			msg = new FacesMessage(this.getKey("login.vazio"));
			FacesContext.getCurrentInstance().addMessage(null, msg);
			erro = true;
		}
		
		if(!validarCampo(user.getSenha())){
			//carregar mensagem de erro de senha
			msg = new FacesMessage(this.getKey("senha.vazia"));
			FacesContext.getCurrentInstance().addMessage(null, msg);
			erro = true;
		}
		
		if(!erro){//logar e redirecionar para o index certo.
			erro = FachadaUsuario.getInstance().logar(user.getLogin(), user.getSenha());
			
			if(erro){
					HttpSession sessao = (HttpSession) contexto.getExternalContext().getSession(true);
					user = FachadaUsuario.getInstance().encontrarUsuario(user.getLogin(), user.getSenha());
					
					sessao.setAttribute("usuario", user);
					
					//redirecionamento.
					resultado ="/pages";
					switch(user.getTipo()){
						case 1:
						 resultado += "/admin/index.xhtml";
						break;
						
						case 2:
						 resultado += "/moderador/index.xhtml";
						break;
						
						default:
						 resultado += "/commom/main.xhtml";
					}
			}else{
				//carregar msg de falha no login/senha
				msg = new FacesMessage(this.getKey("login.invalido"));
				contexto.addMessage(null, msg);
				resultado = "erro";
			}
			
		}else{
			
			resultado = "erro";
		}
		
		this.user = new Usuario();
		return resultado;
	}
	
	
	/**
	 * @author Diego
	 * @return retorno
	 * 
	 *Método que faz o processo de deslogar.
	 *Basicamente retira o usuario da sessão e redireciona pro home.
	 */
	public String deslogar(){
		String retorno = "loginP";
		FacesContext contexto = FacesContext.getCurrentInstance();
		HttpSession sessao = (HttpSession) contexto.getExternalContext().getSession(true);
		
		sessao.invalidate();
		
		return retorno;
	}
	
	
	
	/**
	 * Método que faz a carga do ResourceBundle de onde as mensagens de erro virão
	 * Ele pega o bundle e simplesmente retorna.
	 * 
	 * @return bundle
	 */
	private ResourceBundle carregarBundle(){
		FacesContext contexto = FacesContext.getCurrentInstance();
		ResourceBundle bundle = null;
		
		bundle = contexto.getApplication().getResourceBundle(contexto, "errorMsg");
				
		return bundle;
	}
	
	
	private boolean validarCampo(String campoInformado){
		boolean resultado = true;
		
		if(campoInformado == null || campoInformado.trim().equals("") || campoInformado.toString().isEmpty()){
			resultado = false;
		}
		
		return resultado;
	}
	
	/**
	 * @param codigoDaChave
	 * @return msg
	 * 
	 * Método que carrega a mensagem apropriada de acordo com
	 * o erro que aconteceu.
	 */
	private String getKey(String codigoDaChave){
		String msg = "";
		
		try{
			msg = this.bundle.getString(codigoDaChave);
			System.out.println("a mensagem eh " + msg);
		}catch(MissingResourceException m){
			msg = "???" + "msg not found" + "???";
		}
		
		return msg;
	}
	
	
	//Getters e Setters
	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}


	public ResourceBundle getBundle() {
		return bundle;
	}


	public void setBundle(ResourceBundle bundle) {
		this.bundle = bundle;
	}

	
}
