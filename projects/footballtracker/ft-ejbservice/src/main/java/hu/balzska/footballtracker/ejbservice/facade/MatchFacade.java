package hu.balzska.footballtracker.ejbservice.facade;

import java.util.List;

import javax.ejb.Local;

import hu.balzska.footballtracker.ejbservice.domain.MatchStub;
import hu.balzska.footballtracker.ejbservice.exception.FacadeException;

@Local
public interface MatchFacade {
	MatchStub getMatch(int id) throws FacadeException;
}
