package listeners;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;


public class PhaseList implements PhaseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void afterPhase(PhaseEvent arg0) {
		System.out.println("Depois da fase: "
				+ getPhaseId().toString());
		
	}

	@Override
	public void beforePhase(PhaseEvent arg0) {
		System.out.println("Antes da fase: "
				+ getPhaseId().toString());
		
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
