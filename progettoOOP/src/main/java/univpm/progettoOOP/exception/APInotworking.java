package univpm.progettoOOP.exception;

public class APInotworking extends Exception{
	public APInotworking() {
		super("Sembra che i filtri applicati non producano risultati...");
	}
}
