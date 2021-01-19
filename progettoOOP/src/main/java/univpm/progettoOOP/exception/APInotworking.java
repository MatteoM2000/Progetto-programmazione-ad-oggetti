package univpm.progettoOOP.exception;

public class APInotworking extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public APInotworking() {
		super("L'API sembra non essere attualmente funzionante...");
	}
}
