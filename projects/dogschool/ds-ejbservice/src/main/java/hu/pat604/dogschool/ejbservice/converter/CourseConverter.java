package hu.pat604.dogschool.ejbservice.converter;

import hu.pat604.dogschool.ejbservice.domain.CourseStub;
import hu.pat604.dogschool.ejbservice.domain.DogSchoolStub;
import hu.pat604.dogschool.ejbservice.domain.InstructorStub;
import hu.pat604.dogschool.persistence.entity.Course;
import hu.pat604.dogschool.persistence.entity.DogSchool;
import hu.pat604.dogschool.persistence.entity.Instructor;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by pati on 2017-03-30.
 */

@Local
public interface CourseConverter {

    CourseStub to(Course course);

    List<CourseStub> to(List<Course> courses);

}
