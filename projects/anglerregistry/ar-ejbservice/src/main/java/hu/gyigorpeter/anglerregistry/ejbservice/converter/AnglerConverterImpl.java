package hu.gyigorpeter.anglerregistry.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import hu.gyigorpeter.anglerregistry.ejbservice.pojo.Angler;
import hu.gyigorpeter.anglerregistry.persistence.entity.AnglerEntity;

@Stateless
public class AnglerConverterImpl implements AnglerConverter {

	@Override
	public Angler to(AnglerEntity anglerEntity) {
		Angler angler = null;
		if (anglerEntity != null) {
			angler = new Angler(anglerEntity.getId(), anglerEntity.getName(), anglerEntity.getMotherName(), anglerEntity.getBirthDay(),
					anglerEntity.getBirthPlace(), anglerEntity.getZipCode(), anglerEntity.getCity(), anglerEntity.getAddress(), anglerEntity.getSocialWork(),
					anglerEntity.getBanTime(), anglerEntity.isMember());
		}
		return angler;
	}

	@Override
	public List<Angler> to(List<AnglerEntity> anglerEntityList) {
		List<Angler> anglerList = new ArrayList<Angler>();

		if (anglerEntityList != null && anglerEntityList.size() != 0) {
			for (AnglerEntity anglerEntity : anglerEntityList) {
				anglerList.add(this.to(anglerEntity));
			}
		}

		return anglerList;
	}

}
