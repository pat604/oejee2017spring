package hu.pat604.dogschool.persistence.service;

import hu.pat604.dogschool.persistence.entity.DogSchool;
import hu.pat604.dogschool.persistence.entity.Instructor;
import hu.pat604.dogschool.persistence.exception.PersistenceServiceException;

import java.util.List;

import hu.pat604.dogschool.persistence.parameter.DogSchoolParameter;
import hu.pat604.dogschool.persistence.query.DogSchoolQuery;
import org.apache.log4j.Logger;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by pati on 2017-04-01.
 */

@Stateless(mappedName = "ejb/dogSchoolService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class DogSchoolServiceImpl implements DogSchoolService {

    private static final Logger LOGGER = Logger.getLogger(DogSchoolServiceImpl.class);

    @PersistenceContext(unitName = "ds-persistence-unit")
    private EntityManager entityManager;

    @Override
    public DogSchool read(Long id) throws PersistenceServiceException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Get DogSchool by id (" + id + ")");
        }
        DogSchool result;
        try {
            result = this.entityManager.createNamedQuery(DogSchoolQuery.GET_BY_ID, DogSchool.class).setParameter(DogSchoolParameter.ID, id).getSingleResult();
        } catch (final Exception e) {
            throw new PersistenceServiceException("Unknown error when fetching dog school by id (" + id + ")! " + e.getLocalizedMessage(), e);
        }
        return result;
    }

    @Override
    public DogSchool read(String name) throws PersistenceServiceException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Get DogSchool by name (" + name + ")");
        }
        DogSchool result;
        try {
            result = this.entityManager.createNamedQuery(DogSchoolQuery.GET_BY_NAME, DogSchool.class).setParameter(DogSchoolParameter.NAME, name).getSingleResult();
        } catch (final Exception e) {
            throw new PersistenceServiceException("Unknown error when fetching dog school by name (" + name + ")! " + e.getLocalizedMessage(), e);
        }
        return result;
    }


    @Override
    public List<DogSchool> readAll() throws PersistenceServiceException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Get all dog schools");
        }
        List<DogSchool> result;
        try {
            result = this.entityManager.createNamedQuery(DogSchoolQuery.GET_ALL, DogSchool.class).getResultList();
        } catch (final Exception e) {
            throw new PersistenceServiceException("Unknown error when fetching dog schools! " + e.getLocalizedMessage(), e);
        }
        return result;
    }

    @Override
    public DogSchool update(Long id, String name, String location, Instructor leader) throws PersistenceServiceException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Update dog school with data: id:" + id + ", " + name + ", " + location + ", " + leader.toString());
        }
        try {
            final DogSchool dogSchool = this.read(id);
            dogSchool.setLeader(leader);
            dogSchool.setLocation(location);
            dogSchool.setName(name);
            return this.entityManager.merge(dogSchool);
        } catch (final Exception e) {
            throw new PersistenceServiceException("Unknown error when merging dog school! " + e.getLocalizedMessage(), e);
        }
    }
}
