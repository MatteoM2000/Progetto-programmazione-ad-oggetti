package univpm.progettoOOP.exception;

public class APInotworking extends Exception{
	public APInotworking() {
		super("Sembra che l'API DomainsDB non stia funzionando...");
	}
}
