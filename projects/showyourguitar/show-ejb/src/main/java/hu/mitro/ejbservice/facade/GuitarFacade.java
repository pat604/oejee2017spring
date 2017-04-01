package hu.mitro.ejbservice.facade;

import java.util.List;

import javax.ejb.Local;

import hu.mitro.ejbservice.domain.GuitarBrandStub;
import hu.mitro.ejbservice.domain.GuitarOwnerStub;
import hu.mitro.ejbservice.domain.GuitarStub;

@Local
public interface GuitarFacade {

	GuitarStub getGuitar(Long guitarId);

	List<GuitarStub> getGuitars(GuitarOwnerStub owner);

	List<GuitarStub> getGuitars(GuitarBrandStub brand);

}
