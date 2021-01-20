package univpm.progettoOOP.exception;

/**
 * Classe che gestisce le richieste che non producono risultato
 * @author Matteo Meloni
 * @author Alex Rinaldi
 * @version 1.0.0
 *
 */
public class wrongRequest extends Exception{
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore wrongRequest()
	 */
	public wrongRequest() {
		super("Rotta non implementata!");
	}
}
