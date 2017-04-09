package hu.pat604.dogschool.ejbservice.converter;

import hu.pat604.dogschool.ejbservice.domain.DogSchoolStub;
import hu.pat604.dogschool.ejbservice.domain.InstructorStub;
import hu.pat604.dogschool.persistence.entity.DogSchool;
import hu.pat604.dogschool.persistence.entity.Instructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pati on 2017-03-30.
 */

public class DogSchoolConverterImpl implements DogSchoolConverter {
    @Override
    public DogSchoolStub to(DogSchool dogSchool) {
        InstructorConverterImpl converter = new InstructorConverterImpl();
        InstructorStub leader = converter.to(dogSchool.getLeader());
        return new DogSchoolStub(dogSchool.getName(), leader, dogSchool.getLocation(), dogSchool.getOpenedIn());
    }

    @Override
    public DogSchool to(DogSchoolStub dogSchoolStub) {

        InstructorConverter converter = new InstructorConverterImpl();
        Instructor leader = converter.to(dogSchoolStub.getLeader());

        return new DogSchool(dogSchoolStub.getName(), leader, dogSchoolStub.getLocation(), dogSchoolStub.getOpenedIn());
    }

    @Override
    public List<DogSchoolStub> to(List<DogSchool> dogSchools) {
        final List<DogSchoolStub> result = new ArrayList<>();
        for (final DogSchool dogSchool : dogSchools)
        {
            result.add(this.to(dogSchool));
        }
        return result;
    }
}
