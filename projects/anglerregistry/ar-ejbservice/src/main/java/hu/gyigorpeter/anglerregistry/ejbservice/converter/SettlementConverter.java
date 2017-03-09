package hu.gyigorpeter.anglerregistry.ejbservice.converter;

import java.util.List;

import hu.gyigorpeter.anglerregistry.ejbservice.pojo.Settlement;
import hu.gyigorpeter.anglerregistry.persistence.entity.SettlementEntity;

public interface SettlementConverter {

	Settlement to(SettlementEntity settlementEntity);

	List<Settlement> to(List<SettlementEntity> settlementEntityList);
}
