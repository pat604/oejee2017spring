package hu.gyigorpeter.anglerregistry.ejbservice.converter;

import java.util.List;

import javax.ejb.Local;

import hu.gyigorpeter.anglerregistry.ejbservice.pojo.Fish;
import hu.gyigorpeter.anglerregistry.persistence.entity.FishEntity;

@Local
public class FishConverterImpl implements FishConverter {

	@Override
	public Fish to(FishEntity fishEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Fish> to(List<FishEntity> fishEntityList) {
		// TODO Auto-generated method stub
		return null;
	}

}
