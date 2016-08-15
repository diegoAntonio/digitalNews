package br.dantonio808.beans;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.dantonio808.fachadas.FachadaNoticia;

@ManagedBean(name="avMB")
public class AvaliacaoMB {
	private int avaliacao;
	private ResourceBundle bundle;

	/**
	 * Creates a new instance of AvaliacaoBean
	 */
	public AvaliacaoMB() {
		this.avaliacao = 0;
		this.bundle = this.carregarBundle();
	}

	public String avaliarNoticia(int codigoDanoticia){
		String resultado = "";
		FacesContext contexto = FacesContext.getCurrentInstance();
		String mensagem = "";
		String label = "";
		
		label = getKey("voto.label");
		FacesMessage msg;
		
		if(codigoDanoticia != 14 && 
		   FachadaNoticia.getInstance().avaliarNoticia(codigoDanoticia, avaliacao)){
				mensagem = getKey("voto.sucesso");
				msg = new FacesMessage(label,mensagem);
				contexto.addMessage("growl", msg);
				
		}else{
			mensagem = getKey("voto.erro");
			msg = new FacesMessage(label,mensagem);
			contexto.addMessage("growl", msg);
		}
		
		return resultado;
	}
	
	public int  getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(int avaliacao) {
		this.avaliacao = avaliacao;
	}
	
	private ResourceBundle carregarBundle(){
		FacesContext contexto = FacesContext.getCurrentInstance();
		ResourceBundle bundle = null;
		
		bundle = contexto.getApplication().getResourceBundle(contexto, "errorMsg");
				
		return bundle;
	}
	
	private String getKey(String codigoDaChave){
		String msg = "";
		
		try{
			msg = this.bundle.getString(codigoDaChave);
		}catch(MissingResourceException m){
			msg = "???" + "msg not found" + "???";
		}
		
		return msg;
	}

}
