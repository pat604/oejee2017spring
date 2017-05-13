package hu.mitro.ejbservice.facade;

import java.util.List;

import javax.ejb.Local;

import hu.mitro.ejbservice.domain.GuitarInputStub;
import hu.mitro.ejbservice.domain.GuitarPriceUpdateStub;
import hu.mitro.ejbservice.domain.GuitarStub;
import hu.mitro.ejbservice.exception.FacadeException;

@Local
public interface GuitarFacade {

	GuitarStub getGuitar(Long guitarId) throws FacadeException;

	GuitarStub getGuitar(String serial) throws FacadeException;

	List<GuitarStub> getGuitars() throws FacadeException;

	void addGuitar(GuitarInputStub guitar) throws FacadeException;

	void updateGuitarPrice(GuitarPriceUpdateStub guitar) throws FacadeException;
}
