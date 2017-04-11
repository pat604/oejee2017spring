package com.kota.stratagem.ejbservice.converter;

import java.util.List;

import javax.ejb.Local;

import com.kota.stratagem.ejbservice.domain.AppUserRepresentor;
import com.kota.stratagem.persistence.entity.AppUser;

@Local
public interface AppUserConverter {

	AppUserRepresentor to(AppUser user);

	List<AppUserRepresentor> to(List<AppUser> users);

}
