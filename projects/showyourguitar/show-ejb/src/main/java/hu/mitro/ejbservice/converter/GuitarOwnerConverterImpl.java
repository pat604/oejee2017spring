package hu.mitro.ejbservice.converter;

import javax.ejb.Stateless;

import hu.mitro.ejbservice.domain.GuitarOwnerStub;
import hu.mitro.persistence.entity.GuitarOwner;

@Stateless
public class GuitarOwnerConverterImpl implements GuitarOwnerConverter {

	@Override
	public GuitarOwnerStub to(GuitarOwner guitarOwner) {
		GuitarOwnerStub guitarOwnerStub = new GuitarOwnerStub(guitarOwner.getOwnerUsername(),
				guitarOwner.getOwnerEmail(), guitarOwner.getOwnerPassword());
		return guitarOwnerStub;
	}

}
