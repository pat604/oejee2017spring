package hu.smiklos.stmm.ejb.facade;

import hu.smiklos.stmm.ejb.converter.AppUserConverter;
import hu.smiklos.stmm.ejb.converter.AppUserConverterInterface;
import hu.smiklos.stmm.ejb.domain.AppUserStub;
import hu.smiklos.stmm.ejb.exception.FacadeException;
import hu.smiklos.stmm.pers.exception.PersistenceServiceException;
import hu.smiklos.stmm.pers.service.AppUserServiceInterface;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Created by SebestyenMiklos on 2017. 03. 12..
 */
@Stateless
public class AppUserFacade implements AppUserFacadeInterface {

    @EJB
    private AppUserServiceInterface service;

    @EJB
    private AppUserConverterInterface converter;

    @Override
    public AppUserStub getAppUser(String userId) throws FacadeException, PersistenceServiceException {

        AppUserStub user;
        user = converter.toAppUserStub(service.read("2017-03-12-0000001"));
        return user;
    }
}
