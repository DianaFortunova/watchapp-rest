package sk.upjs.watchapprest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserControllerException extends RuntimeException {

	private static final long serialVersionUID = -2165180927927366183L;

	public UserControllerException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserControllerException(String message) {
		super(message);
	}

}
