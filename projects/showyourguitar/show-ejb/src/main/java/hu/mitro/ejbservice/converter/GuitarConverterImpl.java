package hu.mitro.ejbservice.converter;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import hu.mitro.ejbservice.domain.GuitarBrandStub;
import hu.mitro.ejbservice.domain.GuitarOwnerStub;
import hu.mitro.ejbservice.domain.GuitarStub;
import hu.mitro.persistence.entity.Guitar;

@Stateless
public class GuitarConverterImpl implements GuitarConverter {

	@EJB
	GuitarOwnerConverter converter;

	@Override
	public GuitarStub to(Guitar guitar) {
		GuitarBrandStub guitarBrandStub = GuitarBrandStub.valueOf(guitar.getGuitarbrand().toString());
		GuitarOwnerStub guitarOwnerStub = this.converter.to(guitar.getGuitarOwner());

		return new GuitarStub(guitarBrandStub, guitar.getGuitartype(), guitar.getGuitarColor(),
				guitar.getGuitarVintage(), guitar.getGuitarPrice(), guitarOwnerStub);
	}

}
