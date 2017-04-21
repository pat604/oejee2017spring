package hu.mitro.ejbservice.facade;

import java.util.List;

import javax.ejb.Local;

import hu.mitro.ejbservice.domain.GuitarStub;

@Local
public interface GuitarFacade {

	GuitarStub getGuitar(Long guitarId);

	List<GuitarStub> getGuitars();

	GuitarStub getGuitar(String serial);

}
