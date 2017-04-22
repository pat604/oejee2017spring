package hu.mitro.ejbservice.exception;

public class FacadeException extends Exception {

	public FacadeException(String message) {
		super(message);
	}

	public FacadeException(String message, Throwable cause) {
		super(message, cause);
	}
}
