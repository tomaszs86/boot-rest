package pl.boot.rest.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EventNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EventNotFoundException(String message) {
		super("could not find event '" + message + "'.");
	}
	
	public EventNotFoundException(Throwable cause) {
        super(cause);
    }
	
	public EventNotFoundException() {
        super();
    }
	
	public EventNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
