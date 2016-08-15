package br.dantonio808.listeners;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

import br.dantonio808.model.Usuario;

/**
* @author Diego
*	Classe que funciona como um filtro padr�o dos servlets
*	para cuidar do acesso n�o autorizado.E caso detecte
*	que houve um acesso n�o autorizado,redireciona para o login.
*/
public class ControleDeAcesso implements PhaseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	/** 
	 * M�todo que checa se a p�gina que o usuario solicita
	 *  � o login ou cadastrar (unicas p�ginas que podem ser acessadas por
	 *  usuarios n�o identificados).Caso n�o sejam elas,ele testa se h�
	 *  um usuario na sess�o,caso n�o haja ocorre o redirecionamento.
	 */
	@Override
	public void afterPhase(PhaseEvent arg0) {
		boolean isInsider = false;
		FacesContext contexto =  FacesContext.getCurrentInstance();
		HttpSession sessao = (HttpSession) contexto.getExternalContext().getSession(true);
		String paginaAtual = contexto.getViewRoot().getViewId();
		Usuario u = null;
		
		isInsider = (paginaAtual.lastIndexOf("/pages/") > -1);
		
		u = (Usuario) sessao.getAttribute("usuario");
		
		if(isInsider && u == null){
			NavigationHandler navegador = contexto.getApplication().getNavigationHandler();
			
			navegador.handleNavigation(contexto, null, "loginP");
			
		}
		
	}
	
	
//	/**
//	 * @param u
//	 * @param paginaEscolhida
//	 * @return true ou false
//	 * 
//	 * metodo que analisa se o usuario tem acesso � pagina solicitada.
//	 * ele testa o tipo de usuario que � e depois checa se a p�gina escolhida esta
//	 * dentro da pasta certa.
//	 * 
//	 */
//	private boolean liberarAcesso(Usuario u,String paginaEscolhida){
//		boolean erro = false;
//		
//		
//		
//		
//		return erro;
//	}

	@Override
	public void beforePhase(PhaseEvent arg0) {
		
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
