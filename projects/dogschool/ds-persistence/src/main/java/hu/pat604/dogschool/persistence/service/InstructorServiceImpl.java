package hu.pat604.dogschool.persistence.service;

import hu.pat604.dogschool.persistence.entity.DogSchool;
import hu.pat604.dogschool.persistence.entity.Instructor;
import hu.pat604.dogschool.persistence.entity.trunk.Level;
import hu.pat604.dogschool.persistence.exception.PersistenceServiceException;
import hu.pat604.dogschool.persistence.parameter.InstructorParameter;
import hu.pat604.dogschool.persistence.query.InstructorQuery;
import org.apache.log4j.Logger;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * Created by pati on 2017-04-01.
 */
@Stateless(mappedName = "ejb/instructorService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class InstructorServiceImpl implements InstructorService {

    private static final Logger LOGGER = Logger.getLogger(InstructorServiceImpl.class);

    @PersistenceContext(unitName = "ds-persistence-unit")
    private EntityManager entityManager;

    @Override
    public boolean exists(String name, String telephone) throws PersistenceServiceException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Check instructor by name and telephone (" + name + ", " + telephone + ")");
        }
        try {
            return this.entityManager.createNamedQuery(InstructorQuery.COUNT_BY_NAME_TELEPHONE, Integer.class).setParameter(InstructorParameter.NAME, name)
                    .setParameter(InstructorParameter.TELEPHONE, telephone).getSingleResult() == 1;
        } catch (final Exception e) {
            throw new PersistenceServiceException("Unknown error during counting instructors by name and telephone (" + name + ", " + telephone + ")!" + e.getLocalizedMessage(), e);
        }
    }

    @Override
    public Instructor create(String name, String birthYear, Level level, DogSchool schoolPrimary,
         DogSchool schoolSecondary, String telephone, String zipCode) throws PersistenceServiceException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Create instructor: " + name + ", " + birthYear + ", " + level + ", " + schoolPrimary + ", " +
                    schoolSecondary + ", " + telephone + ", " + zipCode);
        }
        try {
            final Instructor instructor = new Instructor(name, birthYear, level, schoolPrimary, schoolSecondary, telephone, zipCode);
            this.entityManager.persist(instructor);
            return instructor;
        } catch (final Exception e) {
            throw new PersistenceServiceException("Unknown error during persisting instructor (" + name + ")! " + e.getLocalizedMessage(), e);
        }
    }

    @Override
    public Instructor read(Long id) throws PersistenceServiceException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Get instructor by id (" + id + ")");
        }
        Instructor result;
        try {
            // InstructorQuery.GET_BY_ID: "Instructor.getById" STRING. mire használja ezt a Stringet? Instructort ad vissza.
            // ja, ez a named query elnevezése. mitől lesz type safe?
            // a query egy osztályt kap paraméterkéntt  a query elnevezése mellett - ezen hajtja végre
            result = this.entityManager.createNamedQuery(InstructorQuery.GET_BY_ID, Instructor.class).setParameter(InstructorParameter.ID, id).getSingleResult();
        } catch (final Exception e) {
            throw new PersistenceServiceException("Unknown error when fetching instructor by id (" + id + ")! " + e.getLocalizedMessage(), e);
        }
        return result;
    }

    @Override
    public Instructor read(String name, String telephone) throws PersistenceServiceException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Get instructor by name and telephone (" + name + ", " + telephone + ")");
        }
        Instructor result;
        try {
            result = this.entityManager.createNamedQuery(InstructorQuery.GET_BY_NAME_TELEPHONE, Instructor.class)
                    .setParameter(InstructorParameter.NAME, name).setParameter(InstructorParameter.TELEPHONE, telephone).getSingleResult();
        } catch (final Exception e) {
            throw new PersistenceServiceException("Unknown error when fetching instructor by name and telephone (" + name + ", " + telephone + ")!" + e.getLocalizedMessage(), e);
        }
        return result;
    }

    @Override
    public List<Instructor> read(Level level) throws PersistenceServiceException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Get all instructors by given level");
        }
        List<Instructor> result;
        try {
            result = this.entityManager.createNamedQuery(InstructorQuery.GET_BY_LEVEL, Instructor.class)
                    .setParameter(InstructorParameter.LEVEL, level).getResultList();
        } catch (final Exception e) {
            throw new PersistenceServiceException("Unknown error when fetching instructors by given level! " + e.getLocalizedMessage(), e);
        }
        return result;
    }

    @Override
    public List<Instructor> read(DogSchool dogSchool) throws PersistenceServiceException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Get all instructors by given dogschool");
        }
        List<Instructor> result;
        try {
            result = this.entityManager.createNamedQuery(InstructorQuery.GET_BY_DOGSCHOOL, Instructor.class)
                    .setParameter(InstructorParameter.DOGSCHOOL, dogSchool).getResultList();

        } catch (final Exception e) {
            throw new PersistenceServiceException("Unknown error when fetching instructors by given dog school! " + e.getLocalizedMessage(), e);
        }
        return result;
    }

    @Override
    public List<Instructor> readAll() throws PersistenceServiceException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Get all instructors");
        }
        List<Instructor> result;
        try {
            result = this.entityManager.createNamedQuery(InstructorQuery.GET_ALL, Instructor.class).getResultList();
        } catch (final Exception e) {
            throw new PersistenceServiceException("Unknown error when fetching instructors! " + e.getLocalizedMessage(), e);
        }
        return result;
    }


    @Override
    public Instructor update(Long id, String name, String birthYear, Level level, DogSchool schoolPrimary,
                             DogSchool schoolSecondary, String telephone, String zipCode) throws PersistenceServiceException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Update instructor with data: id:" + id + ", " + name + ", " + birthYear + ", " + level + ", " +
            schoolPrimary.toString() + ", " + schoolSecondary.toString() + ", " + telephone + ", " + zipCode);
        }
        try {
            final Instructor instructor = this.read(id);
            instructor.setName(name);
            instructor.setBirthYear(birthYear);
            instructor.setLevel(level);
            instructor.setSchoolPrimary(schoolPrimary);
            instructor.setSchoolSecondary(schoolSecondary);
            instructor.setTelephone(telephone);
            instructor.setZipCode(zipCode);

            return this.entityManager.merge(instructor);
        } catch (final Exception e) {
            throw new PersistenceServiceException("Unknown error when merging instructor! " + e.getLocalizedMessage(), e);
        }
    }

    @Override
    public Instructor update(String name, String birthYear, Level level, DogSchool schoolPrimary,
                             DogSchool schoolSecondary, String telephone, String zipCode) throws PersistenceServiceException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Update instructor with data:" + name + ", " + birthYear + ", " + level + ", " +
                    schoolPrimary.toString() + ", " + schoolSecondary.toString() + ", " + telephone + ", " + zipCode);
        }
        try {
            final Instructor instructor = this.read(name, telephone);
            instructor.setBirthYear(birthYear);
            instructor.setLevel(level);
            instructor.setSchoolPrimary(schoolPrimary);
            instructor.setSchoolSecondary(schoolSecondary);
            instructor.setZipCode(zipCode);

            return this.entityManager.merge(instructor);
        } catch (final Exception e) {
            throw new PersistenceServiceException("Unknown error when merging instructor! " + e.getLocalizedMessage(), e);
        }
    }

    @Override
    public void delete(Long id) throws PersistenceServiceException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Remove instructor by id (" + id + ")");
        }
        try {
            this.entityManager.createNamedQuery(InstructorQuery.REMOVE_BY_ID).setParameter(InstructorParameter.ID, id).executeUpdate();
        } catch (final Exception e) {
            throw new PersistenceServiceException("Unknown error when removing instructor by id (" + id + ")! " + e.getLocalizedMessage(), e);
        }
    }

    @Override
    public void delete(String name, String telephone) throws PersistenceServiceException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Remove instructor by name and telephone (" + name + ", " + telephone + ")");
        }
        try {
            this.entityManager.createNamedQuery(InstructorQuery.REMOVE_BY_NAME_TELEPHONE).setParameter(InstructorParameter.NAME, name)
                    .setParameter(InstructorParameter.TELEPHONE, telephone).executeUpdate();
        } catch (final Exception e) {
            throw new PersistenceServiceException("Unknown error when removing instructor by  by name and telephone (" + name + ", " + telephone + ")!" + e.getLocalizedMessage(), e);
        }
    }
}
