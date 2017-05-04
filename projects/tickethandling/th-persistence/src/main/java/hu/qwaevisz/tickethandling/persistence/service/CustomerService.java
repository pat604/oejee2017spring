package hu.qwaevisz.tickethandling.persistence.service;

import java.util.List;

import javax.ejb.Local;

import hu.qwaevisz.tickethandling.persistence.entity.Customer;
import hu.qwaevisz.tickethandling.persistence.exception.PersistenceServiceException;

@Local
public interface CustomerService {

	boolean exists(String id) throws PersistenceServiceException;

	Customer read(String id) throws PersistenceServiceException;

	List<String> readSysLabels() throws PersistenceServiceException;

	List<Customer> readAll() throws PersistenceServiceException;
}
