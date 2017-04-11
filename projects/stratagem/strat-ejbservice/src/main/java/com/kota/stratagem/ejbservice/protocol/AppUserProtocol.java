package com.kota.stratagem.ejbservice.protocol;

import java.util.List;
import java.util.Set;

import javax.ejb.Local;

import com.kota.stratagem.ejbservice.domain.AppUserRepresentor;
import com.kota.stratagem.ejbservice.domain.ProjectRepresentor;
import com.kota.stratagem.ejbservice.domain.RoleRepresentor;
import com.kota.stratagem.ejbservice.exception.AdaptorException;

@Local
public interface AppUserProtocol {

	AppUserRepresentor getAppUser(Long id) throws AdaptorException;

	List<AppUserRepresentor> getAllAppUsers() throws AdaptorException;

	AppUserRepresentor saveAppUser(Long id, String name, String passwordHash, String email, RoleRepresentor role, Set<ProjectRepresentor> projects) throws AdaptorException;

	void removeAppUser(Long id) throws AdaptorException;

}
