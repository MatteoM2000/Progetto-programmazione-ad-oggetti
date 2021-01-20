package univpm.progettoOOP.exception;

/**
 * Classe che gestisce il malfunzionamento dell'API
 * @author Matteo Meloni
 * @author Alex Rinaldi
 * @version 1.0.0
 *
 */
public class APInotworking extends Exception{
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore APInotworking()
	 */
	public APInotworking() {
		super("L'API sembra non essere attualmente funzionante...");
	}
}
