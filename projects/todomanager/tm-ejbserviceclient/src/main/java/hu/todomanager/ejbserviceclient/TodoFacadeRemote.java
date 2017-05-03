package hu.todomanager.ejbserviceclient;

import javax.ejb.Remote;

import hu.todomanager.ejbserviceclient.domain.TodoStub;
import hu.todomanager.ejbserviceclient.exception.*;

@Remote
public interface TodoFacadeRemote {

	TodoStub getTodoByName(String name) throws FacadeException;

}
