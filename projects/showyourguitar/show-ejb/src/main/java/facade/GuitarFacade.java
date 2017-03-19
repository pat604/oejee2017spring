package facade;

import java.util.List;

import javax.ejb.Local;

import domain.GuitarBrandStub;
import domain.GuitarOwnerStub;
import domain.GuitarStub;

@Local
public interface GuitarFacade {

	List<GuitarStub> getGuitars(GuitarOwnerStub owner);

	List<GuitarStub> getGuitars(GuitarBrandStub brand);

}
