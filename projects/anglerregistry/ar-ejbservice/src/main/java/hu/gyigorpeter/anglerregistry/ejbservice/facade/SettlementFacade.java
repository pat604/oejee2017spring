package hu.gyigorpeter.anglerregistry.ejbservice.facade;

import java.util.List;

import javax.ejb.Local;

import hu.gyigorpeter.anglerregistry.ejbservice.pojo.Settlement;

@Local
public interface SettlementFacade {

	List<Settlement> getAll();

	Settlement edit(Settlement settlement);

	void delete(long id);
}
