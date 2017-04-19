package hu.qwaevisz.tickethandling.persistence.service;

import java.util.List;

import javax.ejb.Local;

import hu.qwaevisz.tickethandling.persistence.entity.CompInSystem;
import hu.qwaevisz.tickethandling.persistence.exception.PersistenceServiceException;

@Local
public interface CompInSystemService {

	boolean count(String id) throws PersistenceServiceException;

	CompInSystem read(String id) throws PersistenceServiceException;

	List<CompInSystem> readAll() throws PersistenceServiceException;
}
