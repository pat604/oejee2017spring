package com.kota.stratagem.ejbservice.protocol;

import java.util.List;
import java.util.Set;

import javax.ejb.Local;

import com.kota.stratagem.ejbservice.domain.AppUserRepresentor;
import com.kota.stratagem.ejbservice.domain.ImpedimentRepresentor;
import com.kota.stratagem.ejbservice.domain.ObjectiveRepresentor;
import com.kota.stratagem.ejbservice.domain.ProjectRepresentor;
import com.kota.stratagem.ejbservice.domain.RoleRepresentor;
import com.kota.stratagem.ejbservice.domain.TaskRepresentor;
import com.kota.stratagem.ejbservice.domain.TeamRepresentor;
import com.kota.stratagem.ejbservice.exception.AdaptorException;

@Local
public interface AppUserProtocol {

	AppUserRepresentor getAppUser(Long id) throws AdaptorException;

	List<AppUserRepresentor> getAllAppUsers() throws AdaptorException;

	AppUserRepresentor saveAppUser(Long id, String name, String passwordHash, String email, RoleRepresentor role, Set<ObjectiveRepresentor> objectives, Set<ProjectRepresentor> projects,
			Set<TaskRepresentor> tasks, Set<ImpedimentRepresentor> reportedImpediments, Set<ImpedimentRepresentor> processedImpediments, Set<TeamRepresentor> supervisedTeams,
			Set<TeamRepresentor> teamMemberships) throws AdaptorException;

	void removeAppUser(Long id) throws AdaptorException;

}
