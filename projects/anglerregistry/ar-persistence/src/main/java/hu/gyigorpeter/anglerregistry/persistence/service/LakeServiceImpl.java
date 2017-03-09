package hu.gyigorpeter.anglerregistry.persistence.service;

import javax.ejb.Stateless;

import hu.gyigorpeter.anglerregistry.persistence.entity.LakeEntity;

@Stateless
public class LakeServiceImpl implements LakeService {

	@Override
	public LakeEntity readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LakeEntity create(String waterCode, int size, String typeOfLake, int maximumDepth, String owner, boolean anglerFarm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LakeEntity update(String waterCode, int size, String typeOfLake, int maximumDepth, String owner, boolean anglerFarm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub

	}

}
