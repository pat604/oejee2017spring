package hu.mitro.ejbservice.facade;

import java.util.List;

import javax.ejb.Local;

import hu.mitro.ejbservice.domain.GuitarStub;
import hu.mitro.ejbservice.exception.FacadeException;

@Local
public interface GuitarFacade {

	GuitarStub getGuitar(Long guitarId) throws FacadeException;

	List<GuitarStub> getGuitars() throws FacadeException;

	GuitarStub getGuitar(String serial) throws FacadeException;

}
