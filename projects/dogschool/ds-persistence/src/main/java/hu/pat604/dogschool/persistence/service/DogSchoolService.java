package hu.pat604.dogschool.persistence.service;
import hu.pat604.dogschool.persistence.entity.DogSchool;
import hu.pat604.dogschool.persistence.entity.Instructor;
import hu.pat604.dogschool.persistence.exception.PersistenceServiceException;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by pati on 2017-04-01.
 */

@Local
public interface DogSchoolService {

    DogSchool read(Long id) throws PersistenceServiceException;

    DogSchool read(String name) throws PersistenceServiceException;

    List<DogSchool> readAll() throws PersistenceServiceException;

    DogSchool update(Long id, String name, String location, Instructor leader) throws PersistenceServiceException;
}
