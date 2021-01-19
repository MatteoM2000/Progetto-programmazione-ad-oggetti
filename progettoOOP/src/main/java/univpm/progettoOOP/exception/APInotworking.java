package univpm.progettoOOP.exception;

public class APInotworking extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public APInotworking() {
		super("Sembra che i filtri applicati non producano risultati... provare la rotta /domains per verificare stato API");
	}
}
