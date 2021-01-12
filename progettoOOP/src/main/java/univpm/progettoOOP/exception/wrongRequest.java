package univpm.progettoOOP.exception;

public class wrongRequest extends Exception{
	public wrongRequest() {
		super("Uno o più parametri inseriti della query string non sono corretti!");
	}
}
