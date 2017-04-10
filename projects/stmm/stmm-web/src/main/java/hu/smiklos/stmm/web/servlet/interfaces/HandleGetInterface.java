package hu.smiklos.stmm.web.servlet.interfaces;

import hu.smiklos.stmm.pers.exception.PersistenceServiceException;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by SebestyenMiklos on 2017. 04. 06..
 */
public interface HandleGetInterface {
    void handleGet() throws ServletException, IOException, PersistenceServiceException;
}
