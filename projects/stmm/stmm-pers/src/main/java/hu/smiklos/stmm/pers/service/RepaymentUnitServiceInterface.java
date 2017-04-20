package hu.smiklos.stmm.pers.service;

import hu.smiklos.stmm.pers.entity.RepaymentUnit;
import hu.smiklos.stmm.pers.exception.PersistenceServiceException;

import javax.ejb.Local;

/**
 * Created by SebestyenMiklos on 2017. 04. 20..
 */
@Local
public interface RepaymentUnitServiceInterface {

    RepaymentUnit create(RepaymentUnit unit) throws PersistenceServiceException;

}
