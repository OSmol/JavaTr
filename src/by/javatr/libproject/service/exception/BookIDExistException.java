package by.javatr.libproject.service.exception;

public class BookIDExistException extends ServiceException {
    public BookIDExistException() {
        super();
    }

    public BookIDExistException(String message) {
        super(message);
    }

    public BookIDExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookIDExistException(Throwable cause) {
        super(cause);
    }
}
