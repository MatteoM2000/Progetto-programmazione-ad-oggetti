package univpm.progettoOOP.exception;

/**
 * Classe che gestisce le richieste che non producono risultato
 * @author Matteo Meloni
 * @author Alex Rinaldi
 * @version 1.0.0
 *
 */
public class APIunreachable extends Exception{
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore APIunreachable()
	 */
	public APIunreachable() {
		super("Sembra che i filtri applicati non producano risultati... provare la rotta /domains per verificare stato API");
	}
}
