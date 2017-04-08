package hu.pat604.dogschool.ejbservice.converter;

import hu.pat604.dogschool.ejbservice.domain.DogSchoolStub;
import hu.pat604.dogschool.ejbservice.domain.InstructorStub;
import hu.pat604.dogschool.ejbservice.domain.LevelStub;
import hu.pat604.dogschool.persistence.entity.DogSchool;
import hu.pat604.dogschool.persistence.entity.Instructor;
import hu.pat604.dogschool.persistence.entity.trunk.Level;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pati on 2017-03-30.
 */

public class InstructorConverterImpl implements InstructorConverter {
    @Override
    public InstructorStub to(Instructor instructor) {

        LevelStub level = LevelStub.valueOf(instructor.getLevel().toString());
        DogSchoolConverterImpl converter = new DogSchoolConverterImpl();
        DogSchoolStub dogSchoolPrimary = converter.to(instructor.getSchoolPrimary());
        DogSchoolStub dogSchoolSecondary = converter.to(instructor.getSchoolPrimary());

        return new InstructorStub(instructor.getName(), instructor.getBirthYear(),
                level, dogSchoolPrimary, dogSchoolSecondary, instructor.getTelephone(), instructor.getZipCode());
    }

    @Override
    public Instructor to(InstructorStub instructorStub) {
        Level level = Level.valueOf(instructorStub.getLevelStub().toString());

        DogSchoolConverter converter = new DogSchoolConverterImpl();

        DogSchool dogSchoolPrimary = converter.to(instructorStub.getSchoolPrimary());
        DogSchool dogSchoolSecondary = converter.to(instructorStub.getSchoolPrimary());

        return new Instructor(instructorStub.getName(), instructorStub.getBirthYear(),
                level, dogSchoolPrimary, dogSchoolSecondary, instructorStub.getTelephone(), instructorStub.getZipCode());
    }

    @Override
    public List<InstructorStub> to(List<Instructor> instructors) {
        final List<InstructorStub> result = new ArrayList<>();
        for (final Instructor instructor : instructors)
        {
            result.add(this.to(instructor));
        }
        return result;

    }
}
