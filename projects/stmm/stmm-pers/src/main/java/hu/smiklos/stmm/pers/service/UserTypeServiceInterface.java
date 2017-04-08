package hu.smiklos.stmm.pers.service;

import hu.smiklos.stmm.pers.entity.UserType;
import hu.smiklos.stmm.pers.exception.PersistenceServiceException;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by SebestyenMiklos on 2017. 03. 26..
 */
@Local
public interface UserTypeServiceInterface {


    public List<UserType> readAll() throws PersistenceServiceException;

    UserType getTypeWhereStateIs(int state) throws PersistenceServiceException;
}
