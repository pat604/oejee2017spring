package hu.gyigorpeter.anglerregistry.ejbservice.converter;

import java.util.List;

import hu.gyigorpeter.anglerregistry.ejbservice.pojo.Lake;
import hu.gyigorpeter.anglerregistry.persistence.entity.LakeEntity;

public interface LakeConverter {

	Lake to(LakeEntity lakeEntity);

	List<Lake> to(List<LakeEntity> lakeEntityList);
}
