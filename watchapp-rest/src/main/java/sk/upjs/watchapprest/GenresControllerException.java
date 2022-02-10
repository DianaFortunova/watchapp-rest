package sk.upjs.watchapprest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class GenresControllerException extends RuntimeException {

	private static final long serialVersionUID = -979072515788171793L;

	public GenresControllerException(String message, Throwable cause) {
		super(message, cause);
	}

	public GenresControllerException(String message) {
		super(message);
	}

}
