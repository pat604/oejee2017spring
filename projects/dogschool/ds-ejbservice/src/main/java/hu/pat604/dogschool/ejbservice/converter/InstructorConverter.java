package hu.pat604.dogschool.ejbservice.converter;

import hu.pat604.dogschool.ejbservice.domain.DogSchoolStub;
import hu.pat604.dogschool.ejbservice.domain.InstructorStub;
import hu.pat604.dogschool.persistence.entity.DogSchool;
import hu.pat604.dogschool.persistence.entity.Instructor;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by pati on 2017-03-30.
 */

@Local
public interface InstructorConverter {

    InstructorStub to(Instructor instructor);

    Instructor to(InstructorStub instructorStub);

    List<InstructorStub> to(List<Instructor> instructors);

}
