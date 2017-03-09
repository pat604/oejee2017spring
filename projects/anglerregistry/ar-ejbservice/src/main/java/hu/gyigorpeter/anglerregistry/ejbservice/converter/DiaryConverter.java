package hu.gyigorpeter.anglerregistry.ejbservice.converter;

import java.util.List;

import javax.ejb.Local;

import hu.gyigorpeter.anglerregistry.ejbservice.pojo.Diary;
import hu.gyigorpeter.anglerregistry.persistence.entity.DiaryEntity;

@Local
public interface DiaryConverter {

	Diary to(DiaryEntity fogasiNaploEntity);

	List<Diary> to(List<DiaryEntity> fogasiNaploEntityList);
}
