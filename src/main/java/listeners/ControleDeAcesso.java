package listeners;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

import model.Usuario;

/**
* @author Diego
*	Classe que funciona como um filtro padrão dos servlets
*	para cuidar do acesso não autorizado.E caso detecte
*	que houve um acesso não autorizado,redireciona para o login.
*/
public class ControleDeAcesso implements PhaseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	/** 
	 * Método que checa se a página que o usuario solicita
	 *  é o login ou cadastrar (unicas páginas que podem ser acessadas por
	 *  usuarios não identificados).Caso não sejam elas,ele testa se há
	 *  um usuario na sessão,caso não haja ocorre o redirecionamento.
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
//	 * metodo que analisa se o usuario tem acesso à pagina solicitada.
//	 * ele testa o tipo de usuario que é e depois checa se a página escolhida esta
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
