package hu.gyigorpeter.anglerregistry.ejbservice.converter;

import java.util.List;

import javax.ejb.Local;

import hu.gyigorpeter.anglerregistry.ejbservice.pojo.Lake;
import hu.gyigorpeter.anglerregistry.persistence.entity.LakeEntity;

@Local
public class LakeConverterImpl implements LakeConverter {

	@Override
	public Lake to(LakeEntity lakeEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Lake> to(List<LakeEntity> lakeEntityList) {
		// TODO Auto-generated method stub
		return null;
	}

}
