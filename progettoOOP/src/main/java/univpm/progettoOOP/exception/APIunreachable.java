package univpm.progettoOOP.exception;

public class APIunreachable extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public APIunreachable() {
		super("L'API sembra non essere attualmente funzionante...");
	}
}
