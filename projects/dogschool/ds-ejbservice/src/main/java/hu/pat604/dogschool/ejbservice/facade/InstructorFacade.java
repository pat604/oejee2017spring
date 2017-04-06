package hu.pat604.dogschool.ejbservice.facade;

import hu.pat604.dogschool.ejbservice.domain.DogSchoolStub;
import hu.pat604.dogschool.ejbservice.domain.InstructorStub;
import hu.pat604.dogschool.ejbservice.domain.LevelStub;
import hu.pat604.dogschool.ejbservice.exception.FacadeException;
import hu.pat604.dogschool.persistence.entity.DogSchool;
import hu.pat604.dogschool.persistence.entity.Instructor;
import hu.pat604.dogschool.persistence.exception.PersistenceServiceException;

import java.util.List;

/**
 * Created by pat on 2017.04.03..
 */
public interface InstructorFacade {

    // InstructorStub getInstructor(Long id) throws FacadeException;

    InstructorStub getInstructor(String name, String telephone) throws FacadeException;

    List<InstructorStub> getInstructors(LevelStub levelStub) throws FacadeException;

    List<InstructorStub> getInstructors(DogSchoolStub dogSchoolStub) throws FacadeException;

    List<InstructorStub> getInstructors() throws FacadeException;

    InstructorStub saveInstructor(String name, String birthYear, LevelStub levelStub, DogSchoolStub schoolPrimaryStub, DogSchoolStub schoolSecondaryStub,
                                    String telephone, String zipCode) throws FacadeException;

    void deleteInstructor(String name, String telephone) throws FacadeException, PersistenceServiceException;

}
