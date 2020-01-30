package by.javatr.libproject.service.exception;

public class InvalidAuthorNameException extends ServiceException {
    public InvalidAuthorNameException() {
        super();
    }

    public InvalidAuthorNameException(String message) {
        super(message);
    }

    public InvalidAuthorNameException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidAuthorNameException(Throwable cause) {
        super(cause);
    }
}
