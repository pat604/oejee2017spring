package hu.gyigorpeter.anglerregistry.ejbservice.converter;

import java.util.List;

import javax.ejb.Local;

import hu.gyigorpeter.anglerregistry.ejbservice.pojo.Angler;
import hu.gyigorpeter.anglerregistry.persistence.entity.AnglerEntity;

@Local
public interface AnglerConverter {

	Angler to(AnglerEntity anglerEntity);

	List<Angler> to(List<AnglerEntity> anglerEntityList);

	AnglerEntity to(Angler angler);

}
