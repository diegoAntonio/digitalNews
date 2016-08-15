package br.dantonio808.listeners;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;



/**
 * @author Diego
 * PhaseListener que funciona como uma ajuda para debugar problemas no sistema,
 * ele apenas retorna a fase do ciclo de vida do JSF onde a requisi��o se encontra.
 * Tudo o que faz � imprimir o id da fase onde ele se encontra.
 */
public class PhaseList implements PhaseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void afterPhase(PhaseEvent arg0) {
		System.out.println("Depois da fase: "
				+ arg0.getPhaseId());
		
	}

	@Override
	public void beforePhase(PhaseEvent arg0) {
		System.out.println("Antes da fase: "
				+ arg0.getPhaseId());
		
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

}
