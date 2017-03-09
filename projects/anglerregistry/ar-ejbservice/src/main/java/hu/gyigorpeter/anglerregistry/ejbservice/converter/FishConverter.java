package hu.gyigorpeter.anglerregistry.ejbservice.converter;

import java.util.List;

import javax.ejb.Local;

import hu.gyigorpeter.anglerregistry.ejbservice.pojo.Fish;
import hu.gyigorpeter.anglerregistry.persistence.entity.FishEntity;

@Local
public interface FishConverter {

	Fish to(FishEntity fishEntity);

	List<Fish> to(List<FishEntity> fishEntityList);
}
