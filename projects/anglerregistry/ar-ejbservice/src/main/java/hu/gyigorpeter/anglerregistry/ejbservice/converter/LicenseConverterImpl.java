package hu.gyigorpeter.anglerregistry.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;

import hu.gyigorpeter.anglerregistry.ejbservice.pojo.License;
import hu.gyigorpeter.anglerregistry.persistence.entity.LicenseEntity;

@Local
public class LicenseConverterImpl implements LicenseConverter {

	@EJB
	private AnglerConverter anglerConverter;

	@Override
	public License to(LicenseEntity licenseEntity) {
		License engedely = null;
		if (licenseEntity != null) {
			engedely = new License(licenseEntity.getId(), this.anglerConverter.to(licenseEntity.getAnglerEntity()), licenseEntity.getNationalTicketId(),
					licenseEntity.getLicenseType());
		}
		return engedely;
	}

	@Override
	public List<License> to(List<LicenseEntity> licenseEntityList) {
		List<License> licenseList = new ArrayList<License>();
		if (licenseEntityList != null && licenseEntityList.size() > 0) {
			for (LicenseEntity licenseEntity : licenseEntityList) {
				licenseList.add(this.to(licenseEntity));
			}
		}
		return licenseList;
	}

}
