package hu.gyigorpeter.anglerregistry.ejbservice.converter;

import java.util.List;

import javax.ejb.Local;

import hu.gyigorpeter.anglerregistry.ejbservice.pojo.License;
import hu.gyigorpeter.anglerregistry.persistence.entity.LicenseEntity;

@Local
public interface LicenseConverter {

	License to(LicenseEntity licenseEntity);

	List<License> to(List<LicenseEntity> licenseEntityList);
}
