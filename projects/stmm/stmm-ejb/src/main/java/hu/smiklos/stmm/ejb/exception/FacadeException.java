package hu.smiklos.stmm.ejb.exception;

/**
 * Created by SebestyenMiklos on 2017. 03. 12..
 */
public class FacadeException extends Exception {

    public FacadeException(String message) {
        super(message);
    }

    public FacadeException(String message, Throwable cause) {
        super(message, cause);
    }

}
