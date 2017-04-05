package hu.smiklos.stmm.pers.service;

import hu.smiklos.stmm.pers.entity.RegistrationPerDay;
import hu.smiklos.stmm.pers.exception.PersistenceServiceException;

import javax.ejb.Local;

/**
 * Created by SebestyenMiklos on 2017. 04. 02..
 */
@Local
public interface RegistrationPerDayInterface {
    boolean exists(String day) throws PersistenceServiceException;

    RegistrationPerDay read(String day) throws PersistenceServiceException;

    RegistrationPerDay update(RegistrationPerDay day) throws PersistenceServiceException;

    RegistrationPerDay create(RegistrationPerDay day) throws PersistenceServiceException;


}
