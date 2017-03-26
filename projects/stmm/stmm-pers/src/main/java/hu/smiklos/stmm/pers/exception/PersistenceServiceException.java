package hu.smiklos.stmm.pers.exception;

public class PersistenceServiceException extends Exception {


	public PersistenceServiceException(String message) {
		super(message);
	}

	public PersistenceServiceException(String message, Throwable cause) {
		super(message, cause);
	}

}