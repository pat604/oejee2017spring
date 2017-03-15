package hu.balzska.footballtracker.ejbservice.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import hu.balzska.footballtracker.ejbservice.domain.MatchStub;
import hu.balzska.footballtracker.ejbservice.exception.FacadeException;

@Stateless(mappedName = "ejb/matchFacade")
public class MatchFacadeImpl implements MatchFacade {

	@Override
	public MatchStub getMatch(int id) throws FacadeException {
		MatchStub match = new MatchStub(1, "Arsenal", "Chelsea");
		match.setRandomScore();
		return match;
	}


}
