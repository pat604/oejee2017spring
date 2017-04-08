package hu.pat604.dogschool.ejbservice.facade;

import hu.pat604.dogschool.ejbservice.domain.DogSchoolStub;
import hu.pat604.dogschool.ejbservice.domain.InstructorStub;
import hu.pat604.dogschool.ejbservice.exception.FacadeException;

import java.util.List;

/**
 * Created by pat on 2017.04.03..
 */
public interface DogSchoolFacade {

    // ezen a szinten ne legyen id
    // DogSchoolStub getDogSchool(Long id) throws FacadeException;

    DogSchoolStub getDogSchool(String name) throws FacadeException;

    List<DogSchoolStub> getDogSchools() throws FacadeException;

    DogSchoolStub updateDogSchool(Long id, String name, String location, InstructorStub leader)
            throws FacadeException;

}
