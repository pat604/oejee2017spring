package hu.qwaevisz.tickethandling.ejbservice.facade;

import java.util.List;

import javax.ejb.Local;

import hu.qwaevisz.tickethandling.ejbservice.exception.FacadeException;
import hu.qwaevisz.tickethandling.ejbserviceclient.domain.EmployeeStub;

@Local
public interface EmployeeFacade {

	EmployeeStub getEmployee(String id) throws FacadeException;

	List<EmployeeStub> getEmployees() throws FacadeException;
}
