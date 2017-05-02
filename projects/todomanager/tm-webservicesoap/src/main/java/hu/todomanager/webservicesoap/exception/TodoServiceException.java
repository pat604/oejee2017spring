package hu.todomanager.webservicesoap.exception;

import javax.xml.ws.WebFault;

import hu.todomanager.ejbservice.domain.ServiceError;

@WebFault(name = "TodoServiceFault", targetNamespace = "http://localhost:8080/tm-weblayer/todoList")
public class TodoServiceException extends Exception {

	private static final long serialVersionUID = 536014448507939548L;

	private final ServiceError faultInfo;

	public TodoServiceException(String message, ServiceError faultInfo) {
		super(message);
		this.faultInfo = faultInfo;
	}

	public TodoServiceException(String message, ServiceError faultInfo, Throwable cause) {
		super(message, cause);
		this.faultInfo = faultInfo;
	}

	public ServiceError getFaultInfo() {
		return this.faultInfo;
	}

}
