package hu.gyigorpeter.anglerregistry.ejbservice.facade;

import java.util.List;

import javax.ejb.Local;

import hu.gyigorpeter.anglerregistry.ejbservice.pojo.Diary;

@Local
public interface DiaryFacade {

	List<Diary> getAll();

	Diary edit(Diary diary);

	void delete(long id);
}
