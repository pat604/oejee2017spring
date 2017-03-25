package hu.mitro.facade;

import java.util.List;

import javax.ejb.Local;

import hu.mitro.domain.GuitarBrandStub;
import hu.mitro.domain.GuitarOwnerStub;
import hu.mitro.domain.GuitarStub;

@Local
public interface GuitarFacade {

	List<GuitarStub> getGuitars(GuitarOwnerStub owner);

	List<GuitarStub> getGuitars(GuitarBrandStub brand);

}
