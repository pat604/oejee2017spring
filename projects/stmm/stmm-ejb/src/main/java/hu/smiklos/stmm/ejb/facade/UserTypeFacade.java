package hu.smiklos.stmm.ejb.facade;
import hu.smiklos.stmm.ejb.converter.UserTypeConverterInterface;
import hu.smiklos.stmm.ejb.domain.UserTypeStub;
import hu.smiklos.stmm.pers.entity.UserType;
import hu.smiklos.stmm.pers.exception.PersistenceServiceException;
import hu.smiklos.stmm.pers.service.UserTypeService;
import hu.smiklos.stmm.pers.service.UserTypeServiceInterface;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SebestyenMiklos on 2017. 03. 26..
 */
@Stateless
public class UserTypeFacade implements UserTypeFacadeInterface {


    @EJB
    private UserTypeServiceInterface service;

    @EJB
    private UserTypeConverterInterface converter;

    @Override
    public List<UserTypeStub> getAllUserType() throws PersistenceServiceException {
        List<UserTypeStub> stubList = new ArrayList<UserTypeStub>();
        List<UserType> entityList = service.readAll();
        for (UserType type : entityList){
            stubList.add(converter.toUserTypeStub(type));
        }
        return stubList;
    }
}
