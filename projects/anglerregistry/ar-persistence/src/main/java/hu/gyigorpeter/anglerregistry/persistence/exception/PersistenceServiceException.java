package hu.gyigorpeter.anglerregistry.persistence.exception;

public class PersistenceServiceException extends Exception {

	private static final long serialVersionUID = -8129921246542914477L;

	public PersistenceServiceException(String message) {
		super(message);
	}

	public PersistenceServiceException(String message, Throwable cause) {
		super(message, cause);
	}

}
