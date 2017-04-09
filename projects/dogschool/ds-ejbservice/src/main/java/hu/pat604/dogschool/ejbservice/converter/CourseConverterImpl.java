package hu.pat604.dogschool.ejbservice.converter;

import hu.pat604.dogschool.ejbservice.domain.*;
import hu.pat604.dogschool.persistence.entity.Course;
import hu.pat604.dogschool.persistence.entity.DogSchool;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by pati on 2017-04-01.
 */
public class CourseConverterImpl implements CourseConverter {

    @Override
    public CourseStub to(Course course) {
        DogSchoolConverterImpl dsConverter = new DogSchoolConverterImpl();
        DogSchoolStub dogSchool = dsConverter.to(course.getDogSchool());

        InstructorConverterImpl iConverter = new InstructorConverterImpl();
        InstructorStub groupLeader = iConverter.to(course.getGroupLeader());
        InstructorStub assistantPrimary = iConverter.to(course.getAssistantPrimary());
        InstructorStub assistantSecondary = iConverter.to(course.getAssistantSecondary());

        return new CourseStub(dogSchool, course.getStartDate(), CourseTypeStub.valueOf(course.getCourseType().toString()),
        DogSizeStub.valueOf(course.getSize().toString()), groupLeader, assistantPrimary, assistantSecondary);
    }

    @Override
    public List<CourseStub> to(List<Course> courses) {
        final List<CourseStub> result = new ArrayList<>();
        for (final Course course : courses)
        {
            result.add(this.to(course));
        }
        return result;
    }
}
