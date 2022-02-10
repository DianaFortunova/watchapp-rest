package sk.upjs.watchapprest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class GroupsControllerException extends RuntimeException {

	private static final long serialVersionUID = -3604197201577316221L;

	public GroupsControllerException(String message, Throwable cause) {
		super(message, cause);
	}

	public GroupsControllerException(String message) {
		super(message);
	}
	
	

}
