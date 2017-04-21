package hu.mitro.persistence.service;

import java.util.List;

import javax.ejb.Local;
import javax.persistence.PersistenceException;

import hu.mitro.persistence.entity.Guitar;

@Local
public interface GuitarService {

	Guitar read(Long id) throws PersistenceException;

	Guitar readBySerialNumber(String serialNumber) throws PersistenceException;

	List<Guitar> readAll() throws PersistenceException;
}
