package univpm.progettoOOP.exception;

public class APIunreachable extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public APIunreachable() {
		super("Sembra che i filtri applicati non producano risultati... provare la rotta /domains per verificare stato API");
	}
}
