package univpm.progettoOOP.exception;

public class APIunreachable extends Exception{
	public APIunreachable() {
		super("Impossibile connettersi all'API...");
	}
}
