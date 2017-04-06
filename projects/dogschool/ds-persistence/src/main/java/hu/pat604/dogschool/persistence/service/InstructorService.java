package hu.pat604.dogschool.persistence.service;

import hu.pat604.dogschool.persistence.entity.DogSchool;
import hu.pat604.dogschool.persistence.entity.Instructor;
import hu.pat604.dogschool.persistence.entity.trunk.Level;
import hu.pat604.dogschool.persistence.exception.PersistenceServiceException;

import java.util.List;

/**
 * Created by pati on 2017-04-01.
 */
public interface InstructorService {

    boolean exists(String name, String telephone) throws PersistenceServiceException;

    Instructor create(String name, String birthYear, Level level, DogSchool schoolPrimary, DogSchool schoolSecondary,
                      String telephone, String zipCode) throws PersistenceServiceException;

    Instructor read(Long id) throws PersistenceServiceException;

    Instructor read(String name, String telephone) throws PersistenceServiceException;

    List<Instructor> read(Level level) throws PersistenceServiceException;

    List<Instructor> read(DogSchool dogSchool) throws PersistenceServiceException;

    List<Instructor> readAll() throws PersistenceServiceException;

    Instructor update(Long id, String name, String birthYear, Level level, DogSchool schoolPrimary, DogSchool schoolSecondary,
                      String telephone, String zipCode) throws PersistenceServiceException;

    Instructor update(String name, String birthYear, Level level, DogSchool schoolPrimary, DogSchool schoolSecondary,
                      String telephone, String zipCode) throws PersistenceServiceException;


    void delete(Long id) throws PersistenceServiceException;

    void delete(String name, String telephone) throws PersistenceServiceException;
}
