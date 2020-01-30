package by.javatr.libproject.service.exception;

public class InvalidPublishException extends ServiceException {
    public InvalidPublishException() {
        super();
    }

    public InvalidPublishException(String message) {
        super(message);
    }

    public InvalidPublishException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidPublishException(Throwable cause) {
        super(cause);
    }
}
