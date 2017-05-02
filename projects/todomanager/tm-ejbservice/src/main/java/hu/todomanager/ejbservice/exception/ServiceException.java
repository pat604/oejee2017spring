package hu.todomanager.ejbservice.exception;

import hu.todomanager.ejbservice.domain.*;

public class ServiceException extends Exception {

	private static final long serialVersionUID = -6072617107159960432L;

	private final int code;

	public ServiceException(TodoError error, String message) {
		this(error.getCode(), message, null);
	}

	public ServiceException(int code, String message, Throwable cause) {
		super(message, cause);
		this.code = code;
	}

	public ServiceError getError() {
		return new ServiceError(this.code, this.getMessage());
	}

}
