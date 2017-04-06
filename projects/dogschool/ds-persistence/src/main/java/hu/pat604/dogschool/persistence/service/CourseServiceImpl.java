package hu.pat604.dogschool.persistence.service;

import hu.pat604.dogschool.persistence.entity.Course;
import hu.pat604.dogschool.persistence.entity.DogSchool;
import hu.pat604.dogschool.persistence.entity.Instructor;
import hu.pat604.dogschool.persistence.entity.trunk.CourseType;
import hu.pat604.dogschool.persistence.entity.trunk.DogSize;
import hu.pat604.dogschool.persistence.entity.trunk.Level;
import hu.pat604.dogschool.persistence.exception.PersistenceServiceException;
import hu.pat604.dogschool.persistence.parameter.CourseParameter;
import hu.pat604.dogschool.persistence.parameter.InstructorParameter;
import hu.pat604.dogschool.persistence.query.CourseQuery;
import hu.pat604.dogschool.persistence.query.InstructorQuery;
import org.apache.log4j.Logger;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

/**
 * Created by pati on 2017-04-01.
 */
@Stateless(mappedName = "ejb/courseService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class CourseServiceImpl implements CourseService {

    private static final Logger LOGGER = Logger.getLogger(CourseServiceImpl.class);

    @PersistenceContext(unitName = "ds-persistence-unit")
    private EntityManager entityManager;


    @Override
    public boolean exists(Long id) throws PersistenceServiceException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Check course by id (" + id + ")");
        }
        try {
            return entityManager.createNamedQuery(CourseQuery.COUNT_BY_ID, Integer.class).setParameter(InstructorParameter.ID, id)
                    .getSingleResult() == 1;
        } catch (final Exception e) {
            throw new PersistenceServiceException("Unknown error during counting courses by id (" + id + ")!" + e.getLocalizedMessage(), e);
        }
    }

    @Override
    public Course create(DogSchool dogSchool, Date startDate, CourseType courseType, DogSize size, Instructor groupLeader, Instructor assistantPrimary, Instructor assistantSecondary) throws PersistenceServiceException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Create course: " + dogSchool + ", " + startDate + ", " + courseType + ", " + size + ", " +
                    groupLeader + ", " + assistantPrimary + ", " + assistantSecondary);
        }
        try {
            final Course course = new Course(dogSchool, startDate, courseType, size, groupLeader, assistantPrimary, assistantSecondary);
            entityManager.persist(course);
            return course;
        } catch (final Exception e) {
            throw new PersistenceServiceException("Unknown error during persisting course (" + dogSchool + ", " + startDate + ")! " + e.getLocalizedMessage(), e);
        }
    }

    @Override
    public Course read(Long id) throws PersistenceServiceException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Get course by id (" + id + ")");
        }
        Course result;
        try {
            result = entityManager.createNamedQuery(CourseQuery.GET_BY_ID, Course.class).setParameter(CourseParameter.ID, id).getSingleResult();
        } catch (final Exception e) {
            throw new PersistenceServiceException("Unknown error when fetching course by id (" + id + ")! " + e.getLocalizedMessage(), e);
        }
        return result;
    }

    @Override
    public List<Course> read(DogSchool dogSchool) throws PersistenceServiceException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Get courses by dog school (" + dogSchool + ")");
        }
        List<Course> result;
        try {
            result = entityManager.createNamedQuery(CourseQuery.GET_BY_DOGSCHOOL, Course.class)
                    .setParameter(CourseParameter.DOGSCHOOL, dogSchool).getResultList();
        } catch (final Exception e) {
            throw new PersistenceServiceException("Unknown error when fetching courses by dog school (" + dogSchool + ")! " + e.getLocalizedMessage(), e);
        }
        return result;
    }

    @Override
    public List<Course> read(DogSchool dogSchool, Date startDate) throws PersistenceServiceException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Get courses by dog school and start date (" + dogSchool + ", " + startDate.toString() + ")");
        }
        List<Course> result;
        try {
            result = entityManager.createNamedQuery(CourseQuery.GET_BY_DOGSCHOOL_STARTDATE, Course.class)
                    .setParameter(CourseParameter.DOGSCHOOL, dogSchool).setParameter(CourseParameter.START, startDate).getResultList();
        } catch (final Exception e) {
            throw new PersistenceServiceException("Unknown error when fetching courses by dog school and start date (" + dogSchool + ", " + startDate.toString() + ")! " + e.getLocalizedMessage(), e);
        }
        return result;
    }


    @Override
    public List<Course> read(DogSchool dogSchool, Instructor groupLeader) throws PersistenceServiceException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Get courses by dog school and group leader (" + dogSchool + ", " + groupLeader + ")");
        }
        List<Course> result;
        try {
            result = entityManager.createNamedQuery(CourseQuery.GET_BY_DOGSCHOOL_GROUPLEADER, Course.class)
                    .setParameter(CourseParameter.DOGSCHOOL, dogSchool).setParameter(CourseParameter.GROUPLEADER, groupLeader).getResultList();
        } catch (final Exception e) {
            throw new PersistenceServiceException("Unknown error when fetching courses by dog school and group leader (" + dogSchool + ", " + groupLeader + ")! " + e.getLocalizedMessage(), e);
        }
        return result;

    }

    @Override
    public List<Course> read(Instructor groupLeader) throws PersistenceServiceException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Get courses by group leader (" + groupLeader + ")");
        }
        List<Course> result;
        try {
            result = this.entityManager.createNamedQuery(CourseQuery.GET_BY_GROUPLEADER, Course.class)
                    .setParameter(CourseParameter.GROUPLEADER, groupLeader).getResultList();
        } catch (final Exception e) {
            throw new PersistenceServiceException("Unknown error when fetching courses by group leader (" + groupLeader + ")! " + e.getLocalizedMessage(), e);
        }
        return result;
    }

    @Override
    public List<Course> readAll() throws PersistenceServiceException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Get all courses");
        }
        List<Course> result;
        try {
            result = this.entityManager.createNamedQuery(CourseQuery.GET_ALL, Course.class).getResultList();
        } catch (final Exception e) {
            throw new PersistenceServiceException("Unknown error when fetching courses! " + e.getLocalizedMessage(), e);
        }
        return result;
    }

    @Override
    public Course update(Long id, DogSchool dogSchool, Date startDate, CourseType courseType, DogSize size, Instructor groupLeader, Instructor assistantPrimary, Instructor assistantSecondary)
            throws PersistenceServiceException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Update course with data: id:" + id + ", " + dogSchool + ", " + startDate + ", " + courseType + ", " + size + ", " +
                    groupLeader + ", " + assistantPrimary + ", " + assistantSecondary);
        }
        try {
            final Course course = this.read(id);
            course.setDogSchool(dogSchool);
            course.setStartDate(startDate);
            course.setCourseType(courseType);
            course.setSize(size);
            course.setGroupLeader(groupLeader);
            course.setAssistantPrimary(assistantPrimary);
            course.setAssistantSecondary(assistantSecondary);

            return this.entityManager.merge(course);
        } catch (final Exception e) {
            throw new PersistenceServiceException("Unknown error when merging course! " + e.getLocalizedMessage(), e);
        }
    }

    @Override
    public void delete(Long id) throws PersistenceServiceException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Remove course by id (" + id + ")");
        }
        try {
            this.entityManager.createNamedQuery(CourseQuery.REMOVE_BY_ID).setParameter(InstructorParameter.ID, id).executeUpdate();
        } catch (final Exception e) {
            throw new PersistenceServiceException("Unknown error when removing course by id (" + id + ")! " + e.getLocalizedMessage(), e);
        }
    }
}
