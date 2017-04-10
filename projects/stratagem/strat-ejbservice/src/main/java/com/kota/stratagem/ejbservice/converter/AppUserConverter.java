package com.kota.stratagem.ejbservice.converter;

import java.util.List;

import com.kota.stratagem.ejbservice.domain.AppUserRepresentor;
import com.kota.stratagem.persistence.entity.AppUser;

public interface AppUserConverter {

	AppUserRepresentor to(AppUser user);

	List<AppUserRepresentor> to(List<AppUser> users);

}
