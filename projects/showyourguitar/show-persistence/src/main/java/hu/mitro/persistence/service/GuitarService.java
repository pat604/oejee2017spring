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

	void insertGuitar(String guitarBrand, String guitarType, String color, String serialNumber, Integer vintage,
			double price, String ownername) throws PersistenceException;

	void updateGuitarPrice(String serialNumber, double newPrice) throws PersistenceException;

	void updateGuitarOwner(String serialNumber, String newOwnerName) throws PersistenceException;
}
