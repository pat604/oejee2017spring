package hu.pat604.dogschool.ejbservice.facade;

import hu.pat604.dogschool.ejbservice.converter.DogSchoolConverter;
import hu.pat604.dogschool.ejbservice.converter.InstructorConverter;
import hu.pat604.dogschool.ejbservice.domain.DogSchoolStub;
import hu.pat604.dogschool.ejbservice.domain.InstructorStub;
import hu.pat604.dogschool.ejbservice.exception.FacadeException;
import hu.pat604.dogschool.persistence.entity.DogSchool;
import hu.pat604.dogschool.persistence.entity.Instructor;
import hu.pat604.dogschool.persistence.exception.PersistenceServiceException;
import hu.pat604.dogschool.persistence.service.DogSchoolService;

import org.apache.log4j.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by pat on 2017.04.03..
 */
@Stateless(mappedName = "ejb/dogSchoolFacade")
public class DogSchoolFacadeImpl implements DogSchoolFacade {

    private static final Logger LOGGER = Logger.getLogger(DogSchoolFacadeImpl.class);

    @EJB
    private DogSchoolService service;

    @EJB
    private DogSchoolConverter converter;

    @EJB
    private InstructorConverter instructorConverter;

    /*
    @Override
    public DogSchoolStub getDogSchool(Long id) throws FacadeException {
        try {
            final DogSchoolStub stub = converter.to(service.read(id));
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Get dog school by id (" + id + ") --> " + stub.toString());
            }
            return stub;
        } catch (final PersistenceServiceException e) {
            LOGGER.error(e, e);
            throw new FacadeException(e.getLocalizedMessage());
        }
    }

    */

    @Override
    public DogSchoolStub getDogSchool(String name) throws FacadeException {
        try {
            final DogSchoolStub stub = converter.to(service.read(name));
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Get dog school by name (" + name + ") --> " + stub.toString());
            }
            return stub;
        } catch (final PersistenceServiceException e) {
            LOGGER.error(e, e);
            throw new FacadeException(e.getLocalizedMessage());
        }
    }

    @Override
    public List<DogSchoolStub> getDogSchools() throws FacadeException {
        try {
            final List<DogSchoolStub> stubs = converter.to(service.readAll());
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Get dog schools: " + stubs.toString());
            }
            return stubs;
        } catch (final PersistenceServiceException e) {
            LOGGER.error(e, e);
            throw new FacadeException(e.getLocalizedMessage());
        }
    }

    @Override
    public DogSchoolStub updateDogSchool(Long id, String name, String location, InstructorStub leader) throws FacadeException {
        try {
            Instructor instructor = instructorConverter.to(leader);
            final DogSchool stub = service.update(id, name, location, instructor);

            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Update dog school by id (" + id + ") --> " + stub.toString()); }

            return converter.to(stub);
            }
        catch (final PersistenceServiceException e) {
            LOGGER.error(e, e);
            throw new FacadeException(e.getLocalizedMessage());
        }
    }

}
