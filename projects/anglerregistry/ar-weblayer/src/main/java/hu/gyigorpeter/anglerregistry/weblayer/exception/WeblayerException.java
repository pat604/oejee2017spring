package hu.gyigorpeter.anglerregistry.weblayer.exception;

public class WeblayerException extends Exception {

	private static final long serialVersionUID = 4001936511593305029L;

	public WeblayerException(String message) {
		super(message);
	}

	public WeblayerException(String message, Throwable cause) {
		super(message, cause);
	}
}
