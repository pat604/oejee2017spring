package facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import domain.GuitarBrandStub;
import domain.GuitarOwnerStub;
import domain.GuitarStub;

@Stateless
public class GuitarFacadeImpl implements GuitarFacade {

	@Override
	public List<GuitarStub> getGuitars(GuitarOwnerStub owner) {
		List<GuitarStub> guitars = new ArrayList<GuitarStub>();
		GuitarOwnerStub guitarOwner = new GuitarOwnerStub(1L, "tamas.mitro", "blacktom73@gmail.com",
				"tamas1234");
		guitars.add(new GuitarStub(1L, GuitarBrandStub.GIBSON, "Les Paul Standard", "Ebony", 1990,
				550000.0, guitarOwner));
		return guitars;
	}

	@Override
	public List<GuitarStub> getGuitars(GuitarBrandStub brand) {
		List<GuitarStub> guitars = new ArrayList<GuitarStub>();
		GuitarOwnerStub guitarOwner = new GuitarOwnerStub(1L, "tamas.mitro", "blacktom73@gmail.com",
				"tamas1234");
		guitars.add(new GuitarStub(1L, GuitarBrandStub.GIBSON, "Les Paul Standard", "Ebony", 1990,
				550000.0, guitarOwner));
		return guitars;
	}

}
