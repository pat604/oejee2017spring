package hu.qwaevisz.tickethandling.ejbservice.facade;

import java.util.List;

import javax.ejb.Local;

import hu.qwaevisz.tickethandling.ejbservice.domain.SystemStub;
import hu.qwaevisz.tickethandling.ejbservice.exception.FacadeException;

@Local
public interface SystemFacade {

	SystemStub getSystem(String id) throws FacadeException;

	List<SystemStub> getSystems() throws FacadeException;
}
