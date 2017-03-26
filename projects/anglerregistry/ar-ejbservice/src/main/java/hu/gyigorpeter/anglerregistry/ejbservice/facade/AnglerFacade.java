package hu.gyigorpeter.anglerregistry.ejbservice.facade;

import java.util.List;

import javax.ejb.Local;

import hu.gyigorpeter.anglerregistry.ejbservice.exception.FacadeException;
import hu.gyigorpeter.anglerregistry.ejbservice.pojo.Angler;

@Local
public interface AnglerFacade {

	void addAngler(Angler angler) throws FacadeException;

	Angler getAnglerById(long id) throws FacadeException;

	Angler getAnglerByNationalTicket(long nationalTicketId) throws FacadeException;

	List<Angler> getAllAnglers() throws FacadeException;

	void delete(long id) throws FacadeException;

}
