package hu.gyigorpeter.anglerregistry.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;

import hu.gyigorpeter.anglerregistry.ejbservice.pojo.Diary;
import hu.gyigorpeter.anglerregistry.persistence.entity.DiaryEntity;

@Local
public class DiaryConverterImpl implements DiaryConverter {

	@EJB
	private LicenseConverter LicenseConverter;

	@EJB
	private FishConverter fishConverter;

	@EJB
	private LakeConverter lakeConverter;

	@Override
	public Diary to(DiaryEntity fogasiNaploEntity) {
		Diary fogasiNaplo = null;
		if (fogasiNaploEntity != null) {
			fogasiNaplo = new Diary(fogasiNaploEntity.getId(), this.LicenseConverter.to(fogasiNaploEntity.getLicenseEntity()), fogasiNaploEntity.getTimestamp(),
					fogasiNaploEntity.getQuantity());
		}
		return fogasiNaplo;
	}

	@Override
	public List<Diary> to(List<DiaryEntity> diaryEntityList) {
		List<Diary> diaryList = new ArrayList<Diary>();
		if (diaryEntityList != null && diaryEntityList.size() > 0) {
			for (DiaryEntity diaryEntity : diaryEntityList) {
				diaryList.add(this.to(diaryEntity));
			}
		}
		return diaryList;
	}

}
