package hu.gyigorpeter.anglerregistry.ejbservice.exception;

public class FacadeException extends Exception {

	private static final long serialVersionUID = 6676105450269779758L;

	public FacadeException(String message) {
		super(message);
	}

	public FacadeException(String message, Throwable cause) {
		super(message, cause);
	}
}
