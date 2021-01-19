package univpm.progettoOOP.exception;

public class APIunreachable extends RuntimeException{
	public APIunreachable() {
		super("L'API sembra non essere attualmente funzionante...");
	}
}
