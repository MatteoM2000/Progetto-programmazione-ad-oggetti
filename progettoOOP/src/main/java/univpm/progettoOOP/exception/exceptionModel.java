package univpm.progettoOOP.exception;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;


/**
 * Classe che modella le eccezioni da gestire
 * @author Matteo Meloni
 * @author Alex Rinaldi
 * @version 1.0.0
 *
 */
public class exceptionModel {
	/**
	 * Messaggio da visualizzare
	 */
	private final String message;
	/**
	 * HttpStatus legato all'errore
	 */
	private final HttpStatus httpStatus;
	/**
	 * timeStamp dell'errore
	 */
	private final ZonedDateTime timeStamp;
	
	
	
	/**
	 * Costruttore exceptionModel(String, HttpStatus, ZonedDateTime)
	 * @param message Messaggio da visualizzare
	 * @param httpStatus HttpStatus legato all'errore
	 * @param timeStamp timeStamp dell'errore
	 */
	public exceptionModel(String message, HttpStatus httpStatus, ZonedDateTime timeStamp) {
		this.message = message;
		this.httpStatus = httpStatus;
		this.timeStamp = timeStamp;
	}

	/**
	 * 
	 * @return message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * 
	 * @return httpStatus
	 */
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	/**
	 * 
	 * @return timeStamp
	 */
	public ZonedDateTime getTimeStamp() {
		return timeStamp;
	}

			
}
