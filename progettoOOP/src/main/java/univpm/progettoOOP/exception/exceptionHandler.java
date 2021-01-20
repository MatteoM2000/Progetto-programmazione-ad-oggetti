package univpm.progettoOOP.exception;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Classe che si occupa di gestire le eccezioni lanciate
 * @author Matteo Meloni
 * @author Alex Rinaldi
 * @version 1.0.0
 *
 */
@ControllerAdvice
public class exceptionHandler {
	
	/**
	 * Metodo che gestisce eccezioni di tipo APIunreachable
	 * @param e Eccezione da gestire
	 * @return Eccezione gestita
	 * @see APIunreachable
	 */
	@ExceptionHandler(value = {APIunreachable.class})
	public ResponseEntity<Object> handleAPIunreachable(APIunreachable e){
		exceptionModel exc = new exceptionModel(e.getMessage(), HttpStatus.NO_CONTENT, ZonedDateTime.now());
		return new ResponseEntity<>(exc,HttpStatus.OK);
	}
	
	
	/**
	 * Metodo che gestisce eccezioni di tipo APInotworking 
	 * @param e Eccezione da gestire
	 * @return Eccezione gestita
	 * @see APInotworking 
	 */
	@ExceptionHandler(value = {APInotworking.class})
	public ResponseEntity<Object> handleAPInotworking(APInotworking e){
		exceptionModel exc = new exceptionModel(e.getMessage(), HttpStatus.SERVICE_UNAVAILABLE, ZonedDateTime.now());
		return new ResponseEntity<>(exc,HttpStatus.SERVICE_UNAVAILABLE);
	}
	
	
	/**
	 * Metodo che gestisce eccezioni di tipo wrongRequest 
	 * @param e Eccezione da gestire
	 * @return Eccezione gestita
	 * @see wrongRequest
	 */
	@ExceptionHandler(value = {wrongRequest.class})
	public ResponseEntity<Object> handlewrongRequest(wrongRequest e){
		exceptionModel exc = new exceptionModel(e.getMessage(), HttpStatus.BAD_REQUEST, ZonedDateTime.now());
		return new ResponseEntity<>(exc,HttpStatus.BAD_REQUEST);
	}
}
