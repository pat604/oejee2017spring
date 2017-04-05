package hu.pat604.dogschool.persistence.service;

import hu.pat604.dogschool.persistence.entity.Course;
import hu.pat604.dogschool.persistence.entity.DogSchool;
import hu.pat604.dogschool.persistence.entity.Instructor;
import hu.pat604.dogschool.persistence.entity.trunk.CourseType;
import hu.pat604.dogschool.persistence.entity.trunk.DogSize;
import hu.pat604.dogschool.persistence.exception.PersistenceServiceException;

import java.util.Date;
import java.util.List;

/**
 * Created by pati on 2017-04-01.
 */
public interface CourseService {

    boolean exists(Long id) throws PersistenceServiceException;

    Course create(DogSchool dogSchool, Date startDate, CourseType courseType, DogSize size, Instructor groupLeader, Instructor assistantPrimary, Instructor assistantSecondary)
            throws PersistenceServiceException;

    Course read(Long id) throws PersistenceServiceException;

    List<Course> read(DogSchool dogSchool) throws PersistenceServiceException;

    List<Course> read(DogSchool dogSchool, Date startDate) throws PersistenceServiceException;

    List<Course> read(DogSchool dogSchool, Instructor groupLeader) throws PersistenceServiceException;

    List<Course> read(Instructor groupLeader) throws PersistenceServiceException;

    List<Course> readAll() throws PersistenceServiceException;

    Course update(Long id, DogSchool dogSchool, Date startDate, CourseType courseType, DogSize size, Instructor groupLeader, Instructor assistantPrimary, Instructor assistantSecondary)
            throws PersistenceServiceException;

    void delete(Long id) throws PersistenceServiceException;
}
