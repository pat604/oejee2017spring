package com.kota.stratagem.ejbservice.converter;

import java.util.List;

import com.kota.stratagem.ejbservice.domain.TeamRepresentor;
import com.kota.stratagem.persistence.entity.Team;

public interface TeamConverter {

	TeamRepresentor to(Team team);

	List<TeamRepresentor> to(List<Team> teams);

}
