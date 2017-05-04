package com.kota.stratagem.ejbservice.converter;

import java.util.List;

import javax.ejb.Local;

import com.kota.stratagem.ejbserviceclient.domain.ObjectiveRepresentor;
import com.kota.stratagem.persistence.entity.Objective;

@Local
public interface ObjectiveConverter {

	ObjectiveRepresentor to(Objective objective);

	List<ObjectiveRepresentor> to(List<Objective> objectives);

}
