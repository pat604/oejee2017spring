package hu.pat604.dogschool.ejbservice.exception;

/**
 * Created by pati on 2017-04-01.
 */
public class FacadeException extends Exception {

    public FacadeException(String message) {
        super(message);
    }

    public FacadeException(String message, Throwable cause) {
        super(message, cause);
    }
}
