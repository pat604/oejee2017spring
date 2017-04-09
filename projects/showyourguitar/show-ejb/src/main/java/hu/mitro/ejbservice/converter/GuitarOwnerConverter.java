package hu.mitro.ejbservice.converter;

import javax.ejb.Local;

import hu.mitro.ejbservice.domain.GuitarOwnerStub;
import hu.mitro.persistence.entity.GuitarOwner;

@Local
public interface GuitarOwnerConverter {

	GuitarOwnerStub to(GuitarOwner guitarOwner);

}
