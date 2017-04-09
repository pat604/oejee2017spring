package hu.pat604.dogschool.ejbservice.facade;

import hu.pat604.dogschool.ejbservice.converter.DogSchoolConverter;
import hu.pat604.dogschool.ejbservice.converter.InstructorConverter;
import hu.pat604.dogschool.ejbservice.domain.DogSchoolStub;
import hu.pat604.dogschool.ejbservice.domain.InstructorStub;
import hu.pat604.dogschool.ejbservice.domain.LevelStub;
import hu.pat604.dogschool.ejbservice.exception.FacadeException;
import hu.pat604.dogschool.persistence.entity.DogSchool;
import hu.pat604.dogschool.persistence.entity.Instructor;
import hu.pat604.dogschool.persistence.entity.trunk.Level;
import hu.pat604.dogschool.persistence.exception.PersistenceServiceException;
import hu.pat604.dogschool.persistence.service.InstructorService;
import org.apache.log4j.Logger;

import javax.ejb.EJB;
import java.util.List;

/**
 * Created by pat on 2017.04.03..
 */
public class InstructorFacadeImpl implements  InstructorFacade {

    private static final Logger LOGGER = Logger.getLogger(DogSchoolFacadeImpl.class);

    @EJB
    private InstructorService service;

    @EJB
    private InstructorConverter converter;

    @EJB
    private DogSchoolConverter dogSchoolConverter;


    @Override
    public InstructorStub getInstructor(String name, String telephone) throws FacadeException {
        try {
            final InstructorStub stub = converter.to(service.read(name, telephone));
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Get instructor by name and telephone (" + name + ", " + telephone + ") --> " + stub.toString());
            }
            return stub;
        } catch (final PersistenceServiceException e) {
            LOGGER.error(e, e);
            throw new FacadeException(e.getLocalizedMessage());
        }
    }

    @Override
    public List<InstructorStub> getInstructors(LevelStub levelStub) throws FacadeException {
        try {
            final List<InstructorStub> stubs = converter.to(service.read(Level.valueOf(levelStub.toString())));
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Get instructors by level (" + levelStub + "): " + stubs.toString());
            }
            return stubs;
        } catch (final PersistenceServiceException e) {
            LOGGER.error(e, e);
            throw new FacadeException(e.getLocalizedMessage());
        }
    }

    @Override
    public List<InstructorStub> getInstructors(DogSchoolStub dogSchoolStub) throws FacadeException {
        try {
            DogSchool dogSchool = dogSchoolConverter.to(dogSchoolStub);
            final List<InstructorStub> stubs = converter.to(service.read(dogSchool));
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Get instructors by dog school (" + dogSchool.toString() + "): " + stubs.toString());
            }
            return stubs;
        } catch (final PersistenceServiceException e) {
            LOGGER.error(e, e);
            throw new FacadeException(e.getLocalizedMessage());
        }
    }

    @Override
    public List<InstructorStub> getInstructors() throws FacadeException {
        try {
            final List<InstructorStub> stubs = converter.to(service.readAll());
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Get instructors: " + stubs.toString());
            }
            return stubs;
        } catch (final PersistenceServiceException e) {
            LOGGER.error(e, e);
            throw new FacadeException(e.getLocalizedMessage());
        }
    }

    @Override
    public InstructorStub saveInstructor(String name, String birthYear, LevelStub levelStub, DogSchoolStub schoolPrimaryStub, DogSchoolStub schoolSecondaryStub, String telephone, String zipCode)
            throws FacadeException {
        try {
            Instructor instructor;
            InstructorStub instructorStub;
            DogSchool schoolPrimary = dogSchoolConverter.to(schoolPrimaryStub);
            DogSchool schoolSecondary = dogSchoolConverter.to(schoolSecondaryStub);

            if (service.exists(name, telephone)) {
                instructor = service.update(name, birthYear, Level.valueOf(levelStub.toString()), schoolPrimary, schoolSecondary, telephone, zipCode);
            } else {
                instructor = service.create(name, birthYear, Level.valueOf(levelStub.toString()), schoolPrimary, schoolSecondary, telephone, zipCode);
            }
            instructorStub = converter.to(instructor);
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Save instructor: " + instructorStub.toString()); }
            return instructorStub;

        } catch (final PersistenceServiceException e) {
            LOGGER.error(e, e);
            throw new FacadeException(e.getLocalizedMessage());
        }
    }

    @Override
    public void deleteInstructor(String name, String telephone) throws FacadeException {
        try {
            service.delete(name, telephone);
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Delete instructor: " + name + ", " + telephone); }
        } catch (PersistenceServiceException e) {
            LOGGER.error(e, e);
            throw new FacadeException(e.getLocalizedMessage());
        }
    }
}
