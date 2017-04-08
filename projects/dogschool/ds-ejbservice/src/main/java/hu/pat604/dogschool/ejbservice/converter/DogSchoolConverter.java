package hu.pat604.dogschool.ejbservice.converter;

import hu.pat604.dogschool.ejbservice.domain.DogSchoolStub;
import hu.pat604.dogschool.persistence.entity.DogSchool;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by pati on 2017-03-30.
 */

@Local
public interface DogSchoolConverter {

    DogSchoolStub to(DogSchool dogSchool);

    DogSchool to(DogSchoolStub dogSchoolStub);

    List<DogSchoolStub> to(List<DogSchool> dogSchools);

}
