package com.kota.stratagem.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;

import com.kota.stratagem.ejbservice.domain.AppUserRepresentor;
import com.kota.stratagem.ejbservice.domain.RoleRepresentor;
import com.kota.stratagem.persistence.entity.AppUser;
import com.kota.stratagem.persistence.entity.Project;

public class AppUserConverterImplementation implements AppUserConverter {

	private ProjectConverter projectConverter = new ProjectConverterImplementation();

	@Override
	public AppUserRepresentor to(AppUser user) {
		final RoleRepresentor role = RoleRepresentor.valueOf(user.getRole().toString());
		final AppUserRepresentor representor = user.getId() != null ? new AppUserRepresentor(user.getId(), user.getName(), user.getPasswordHash(), user.getEmail(), role)
				: new AppUserRepresentor(user.getName(), user.getPasswordHash(), user.getEmail(), role);
		if(user.getProjects() != null) {
			for(Project project : user.getProjects()) {
				representor.addProject(projectConverter.to(project));
			}
		}
		return representor;
	}

	@Override
	public List<AppUserRepresentor> to(List<AppUser> users) {
		final List<AppUserRepresentor> representors = new ArrayList<>();
		for(final AppUser user : users) {
			representors.add(this.to(user));
		}
		return representors;
	}

}
