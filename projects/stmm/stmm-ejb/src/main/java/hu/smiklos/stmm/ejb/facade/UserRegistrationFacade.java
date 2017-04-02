package hu.smiklos.stmm.ejb.facade;

import hu.smiklos.stmm.ejb.common.PasswordInterface;
import hu.smiklos.stmm.ejb.converter.DateConverter;
import hu.smiklos.stmm.ejb.converter.UserRegisterStubToUserInterface;
import hu.smiklos.stmm.ejb.domain.UserRegistrationStub;
import hu.smiklos.stmm.pers.entity.AppUser;
import hu.smiklos.stmm.pers.entity.RegistrationPerDay;
import hu.smiklos.stmm.pers.entity.UserType;
import hu.smiklos.stmm.pers.exception.PersistenceServiceException;
import hu.smiklos.stmm.pers.service.AppUserServiceInterface;
import hu.smiklos.stmm.pers.service.RegistrationPerDayInterface;
import hu.smiklos.stmm.pers.service.UserTypeServiceInterface;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.Date;

/**
 * Created by SebestyenMiklos on 2017. 03. 30..
 */
@Stateless
public class UserRegistrationFacade implements UserRegistrationFacadeInterface {

    @EJB
    private AppUserServiceInterface userService;

    @EJB
    private RegistrationPerDayInterface regService;

    @EJB
    private UserRegisterStubToUserInterface converter;

    @EJB
    private PasswordInterface pwService;

    @EJB
    private UserTypeServiceInterface userTypeService;

    private UserRegistrationStub userRegistrationStub;

    @Override
    public UserRegistrationStub getUserRegistrationStub() {
        if(userRegistrationStub == null){
            userRegistrationStub = new UserRegistrationStub();
        }
        return userRegistrationStub;
    }

    @Override
    public void createUser(UserRegistrationStub stub) throws PersistenceServiceException {
        String todayNumber = DateConverter.getDateAsContinouesString(new Date());
        int nextVal = getTodayRegistrationData(todayNumber);

        AppUser user= converter.formToAppUser(stub);
        user.setUserId(String.format("%s-%s", todayNumber, nextVal));

        pwService.setPlainTextPassword(stub.getPassword());
        user.setPassword(pwService.getHashedPassword());

        UserType uType = userTypeService.getTypeWhereStateIs(1);
        user.setUserType(uType);

        userService.create(user);
    }

    public int getTodayRegistrationData(String todayNumber) throws PersistenceServiceException {
        int nextVal=1;
        if(regService.exists(todayNumber)){
            RegistrationPerDay day = regService.read(todayNumber);
            nextVal = day.getCount()+1;
            day.setCount(nextVal);
            regService.update(day);
        }else{
            RegistrationPerDay day = new RegistrationPerDay();
            day.setCount(1);
            day.setDay(todayNumber);
            regService.create(day);
        }
        return nextVal;
    }



}
