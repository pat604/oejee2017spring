package com.kota.stratagem.ejbservice.converter;

import java.util.List;

import com.kota.stratagem.ejbservice.domain.ObjectiveRepresentor;
import com.kota.stratagem.persistence.entity.Objective;

public interface ObjectiveConverter {

	ObjectiveRepresentor to(Objective objective);

	List<ObjectiveRepresentor> to(List<Objective> objectives);

}
