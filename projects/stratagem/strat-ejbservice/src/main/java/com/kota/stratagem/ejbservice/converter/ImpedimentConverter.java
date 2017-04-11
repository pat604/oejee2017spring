package com.kota.stratagem.ejbservice.converter;

import java.util.List;

import com.kota.stratagem.ejbservice.domain.ImpedimentRepresentor;
import com.kota.stratagem.persistence.entity.Impediment;

public interface ImpedimentConverter {

	ImpedimentRepresentor to(Impediment impediment);

	List<ImpedimentRepresentor> to(List<Impediment> impediments);

}
