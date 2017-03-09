package hu.gyigorpeter.anglerregistry.ejbservice.converter;

import java.util.List;

import javax.ejb.Local;

import hu.gyigorpeter.anglerregistry.ejbservice.pojo.Settlement;
import hu.gyigorpeter.anglerregistry.persistence.entity.SettlementEntity;

@Local
public class SettlementConverterImpl implements SettlementConverter {

	@Override
	public Settlement to(SettlementEntity settlementEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Settlement> to(List<SettlementEntity> settlementEntityList) {
		// TODO Auto-generated method stub
		return null;
	}

}
