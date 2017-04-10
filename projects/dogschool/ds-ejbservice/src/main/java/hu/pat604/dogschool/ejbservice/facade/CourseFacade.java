package hu.pat604.dogschool.ejbservice.facade;

import hu.pat604.dogschool.ejbservice.domain.*;
import hu.pat604.dogschool.ejbservice.exception.FacadeException;

import java.util.Date;
import java.util.List;

/**
 * Created by pat on 2017.04.03..
 */
public interface CourseFacade {

    CourseStub getCourse(Long id) throws FacadeException;

    List<CourseStub> getCourses(DogSchoolStub dogSchoolStub) throws FacadeException;

    List<CourseStub> getCourses(DogSchoolStub dogSchoolStub, Date startDate) throws FacadeException;

    List<CourseStub> getCourses(DogSchoolStub dogSchoolStub, InstructorStub instructorStub) throws FacadeException;

    List<CourseStub> getCourses(InstructorStub instructorStub) throws FacadeException;

    List<CourseStub> getCourses() throws FacadeException;

    CourseStub saveCourse(DogSchoolStub dogSchool, Date startDate, CourseTypeStub courseType, DogSizeStub size, InstructorStub groupLeader, InstructorStub assistantPrimary, InstructorStub assistantSecondary)
            throws FacadeException;

    CourseStub saveCourse(Long id, DogSchoolStub dogSchool, Date startDate, CourseTypeStub courseType, DogSizeStub size, InstructorStub groupLeader, InstructorStub assistantPrimary, InstructorStub assistantSecondary)
            throws FacadeException;

    void deleteCourse(Long id) throws FacadeException;
}
