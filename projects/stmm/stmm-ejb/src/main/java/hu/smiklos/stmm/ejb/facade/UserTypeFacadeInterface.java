package hu.smiklos.stmm.ejb.facade;

import hu.smiklos.stmm.ejb.domain.UserTypeStub;
import hu.smiklos.stmm.pers.entity.UserType;
import hu.smiklos.stmm.pers.exception.PersistenceServiceException;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by SebestyenMiklos on 2017. 03. 26..
 */
@Local
public interface UserTypeFacadeInterface {

    List<UserTypeStub> getAllUserType() throws PersistenceServiceException;

}
