package hu.mitro.ejbservice.converter;

import javax.ejb.Local;

import hu.mitro.ejbservice.domain.GuitarStub;
import hu.mitro.persistence.entity.Guitar;

@Local
public interface GuitarConverter {

	GuitarStub to(Guitar guitar);

}
