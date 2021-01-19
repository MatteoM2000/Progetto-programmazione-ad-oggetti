package univpm.progettoOOP.exception;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class exceptionHandler {
	@ExceptionHandler(value = {APIunreachable.class})
	public ResponseEntity<Object> handleAPIunreachable(APIunreachable e){
		exceptionModel exc = new exceptionModel(e.getMessage(), HttpStatus.SERVICE_UNAVAILABLE, ZonedDateTime.now());
		return new ResponseEntity<>(exc,HttpStatus.SERVICE_UNAVAILABLE);
	}
	
	@ExceptionHandler(value = {APInotworking.class})
	public ResponseEntity<Object> handleAPInotworking(APInotworking e){
		exceptionModel exc = new exceptionModel(e.getMessage(), HttpStatus.NO_CONTENT, ZonedDateTime.now());
		return new ResponseEntity<>(exc,HttpStatus.NO_CONTENT);
	}
	
	@ExceptionHandler(value = {wrongRequest.class})
	public ResponseEntity<Object> handlewrongRequest(wrongRequest e){
		exceptionModel exc = new exceptionModel(e.getMessage(), HttpStatus.BAD_REQUEST, ZonedDateTime.now());
		return new ResponseEntity<>(exc,HttpStatus.BAD_REQUEST);
	}
}
