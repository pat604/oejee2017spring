package hu.qwaevisz.tickethandling.ejbserviceclient.exception;

import java.io.Serializable;

public class ServiceException extends Exception implements Serializable {

	private static final long serialVersionUID = 6791823269155412515L;

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

}
