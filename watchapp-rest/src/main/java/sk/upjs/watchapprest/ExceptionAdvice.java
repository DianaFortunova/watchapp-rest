package sk.upjs.watchapprest;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import sk.upjs.watchapp.storage.EntityNotFoundException;
import sk.upjs.watchapp.storage.EntityUndeletableException;

@RestControllerAdvice
public class ExceptionAdvice {
	
	@ExceptionHandler(EntityNotFoundException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ApiError handleEntityNotFoundException(EntityNotFoundException e) {
		return new ApiError("ENFE");
	}
	
	
	@ExceptionHandler(NullPointerException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiError handleNullPointerException(NullPointerException e) {
		return new ApiError("NPE");
	}
	
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiError handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
		return new ApiError("HMNRE");
	}
	
	@ExceptionHandler(EntityUndeletableException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiError handleEntityUndeletableException(EntityUndeletableException e) {
		return new ApiError("EUE");
	}
	

	@ExceptionHandler(	NumberFormatException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiError handleNumberFormatException(NumberFormatException e) {
		return new ApiError("Cannot convert id from URL to number");
	}

	
	

}
