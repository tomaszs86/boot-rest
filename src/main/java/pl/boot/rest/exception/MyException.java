package pl.boot.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MyException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public MyException(String message) {
		super(message);
	}
	
	
}

