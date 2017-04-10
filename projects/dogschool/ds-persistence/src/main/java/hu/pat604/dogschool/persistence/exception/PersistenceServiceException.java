package hu.pat604.dogschool.persistence.exception;

/**
 * Created by pati on 2017-04-01.
 */
public class PersistenceServiceException extends Exception {

    public PersistenceServiceException(String message) {
        super(message);
    }

    public PersistenceServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
