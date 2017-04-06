package hu.pat604.dogschool.ejbservice.facade;

import hu.pat604.dogschool.ejbservice.converter.CourseConverter;
import hu.pat604.dogschool.ejbservice.converter.DogSchoolConverter;
import hu.pat604.dogschool.ejbservice.converter.InstructorConverter;
import hu.pat604.dogschool.ejbservice.domain.*;
import hu.pat604.dogschool.ejbservice.exception.FacadeException;
import hu.pat604.dogschool.persistence.entity.Course;
import hu.pat604.dogschool.persistence.entity.DogSchool;
import hu.pat604.dogschool.persistence.entity.Instructor;
import hu.pat604.dogschool.persistence.entity.trunk.CourseType;
import hu.pat604.dogschool.persistence.entity.trunk.DogSize;
import hu.pat604.dogschool.persistence.exception.PersistenceServiceException;
import hu.pat604.dogschool.persistence.service.CourseService;
import org.apache.log4j.Logger;

import javax.ejb.EJB;
import java.util.Date;
import java.util.List;

/**
 * Created by pat on 2017.04.03..
 */
public class CourseFacadeImpl implements CourseFacade {

    private static final Logger LOGGER = Logger.getLogger(DogSchoolFacadeImpl.class);

    @EJB
    private CourseService service;

    @EJB
    private CourseConverter converter;

    @EJB
    private DogSchoolConverter dogSchoolConverter;

    @EJB
    private InstructorConverter instructorConverter;

    @Override
    public CourseStub getCourse(Long id) throws FacadeException {
        try {
            final CourseStub stub = converter.to(service.read(id));
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Get course by id (" + id + ") --> " + stub.toString());
            }
            return stub;
        } catch (final PersistenceServiceException e) {
            LOGGER.error(e, e);
            throw new FacadeException(e.getLocalizedMessage());
        }
    }


    @Override
    public List<CourseStub> getCourses(DogSchoolStub dogSchoolStub) throws FacadeException {
        try {
            DogSchool dogSchool = dogSchoolConverter.to(dogSchoolStub);
            final List<CourseStub> stubs = converter.to(service.read(dogSchool));
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Get courses by dog school (" + dogSchool.toString() + "): " + stubs.toString());
            }
            return stubs;
        } catch (final PersistenceServiceException e) {
            LOGGER.error(e, e);
            throw new FacadeException(e.getLocalizedMessage());
        }
    }

    @Override
    public List<CourseStub> getCourses(DogSchoolStub dogSchoolStub, Date startDate) throws FacadeException {
        try {
            DogSchool dogSchool = dogSchoolConverter.to(dogSchoolStub);
            final List<CourseStub> stubs = converter.to(service.read(dogSchool, startDate));
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Get courses by dog school and start date (" + dogSchool.toString() + ", " + startDate.toString() + "): " + stubs.toString());
            }
            return stubs;
        } catch (final PersistenceServiceException e) {
            LOGGER.error(e, e);
            throw new FacadeException(e.getLocalizedMessage());
        }
    }

    @Override
    public List<CourseStub> getCourses(DogSchoolStub dogSchoolStub, InstructorStub instructorStub) throws FacadeException {
        try {
            Instructor instructor = instructorConverter.to(instructorStub);
            DogSchool dogSchool = dogSchoolConverter.to(dogSchoolStub);
            final List<CourseStub> stubs = converter.to(service.read(dogSchool, instructor));
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Get courses by dog school and group leader (" + dogSchool.toString() + ", " + instructorStub.toString() + "): " + stubs.toString());
            }
            return stubs;
        } catch (final PersistenceServiceException e) {
            LOGGER.error(e, e);
            throw new FacadeException(e.getLocalizedMessage());
        }
    }

    @Override
    public List<CourseStub> getCourses(InstructorStub instructorStub) throws FacadeException {
        try {
            Instructor instructor = instructorConverter.to(instructorStub);
            final List<CourseStub> stubs = converter.to(service.read(instructor));
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Get courses by group leader (" + instructorStub.toString() + "): " + stubs.toString());
            }
            return stubs;
        } catch (final PersistenceServiceException e) {
            LOGGER.error(e, e);
            throw new FacadeException(e.getLocalizedMessage());
        }
    }

    @Override
    public List<CourseStub> getCourses() throws FacadeException {
        try {
            final List<CourseStub> stubs = converter.to(service.readAll());
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Get all of the courses:" + stubs.toString());
            }
            return stubs;
        } catch (final PersistenceServiceException e) {
            LOGGER.error(e, e);
            throw new FacadeException(e.getLocalizedMessage());
        }
    }

    @Override
    public CourseStub saveCourse(Long id, DogSchoolStub dogSchoolStub, Date startDate, CourseTypeStub courseTypeStub, DogSizeStub sizeStub,
                                 InstructorStub groupLeaderStub, InstructorStub assistantPrimaryStub, InstructorStub assistantSecondaryStub) throws FacadeException {
        try {

            Course course;
            CourseStub courseStub;
            Instructor groupLeader = instructorConverter.to(groupLeaderStub);
            Instructor assistantPrimary = instructorConverter.to(assistantPrimaryStub);
            Instructor assistantSecondary = instructorConverter.to(assistantSecondaryStub);
            DogSchool dogSchool = dogSchoolConverter.to(dogSchoolStub);

            if (service.exists(id)) {
                course = service.update(id, dogSchool, startDate, CourseType.valueOf(courseTypeStub.toString()), DogSize.valueOf(sizeStub.toString()), groupLeader, assistantPrimary, assistantSecondary);
            } else {
                course = service.create(dogSchool, startDate, CourseType.valueOf(courseTypeStub.toString()), DogSize.valueOf(sizeStub.toString()), groupLeader, assistantPrimary, assistantSecondary);
            }
            courseStub = converter.to(course);

            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Save course: " + courseStub.toString()); }

            return courseStub;

        } catch (final PersistenceServiceException e) {
            LOGGER.error(e, e);
            throw new FacadeException(e.getLocalizedMessage());
        }
    }

    @Override
    public CourseStub saveCourse(DogSchoolStub dogSchoolStub, Date startDate, CourseTypeStub courseTypeStub, DogSizeStub sizeStub,
                                 InstructorStub groupLeaderStub, InstructorStub assistantPrimaryStub, InstructorStub assistantSecondaryStub) throws FacadeException {
        try {

            Course course;
            CourseStub courseStub;
            Instructor groupLeader = instructorConverter.to(groupLeaderStub);
            Instructor assistantPrimary = instructorConverter.to(assistantPrimaryStub);
            Instructor assistantSecondary = instructorConverter.to(assistantSecondaryStub);
            DogSchool dogSchool = dogSchoolConverter.to(dogSchoolStub);

            course = service.create(dogSchool, startDate, CourseType.valueOf(courseTypeStub.toString()), DogSize.valueOf(sizeStub.toString()), groupLeader, assistantPrimary, assistantSecondary);
            courseStub = converter.to(course);

            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Save course: " + courseStub.toString()); }

            return courseStub;

        } catch (final PersistenceServiceException e) {
            LOGGER.error(e, e);
            throw new FacadeException(e.getLocalizedMessage());
        }
    }

    @Override
    public void deleteCourse(Long id) throws FacadeException {
        try {
            service.delete(id);
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Delete course by id: " + id); }
        } catch (PersistenceServiceException e) {
            LOGGER.error(e, e);
            throw new FacadeException(e.getLocalizedMessage());
        }
    }

}
