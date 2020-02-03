package by.javatr.libproject.dao.exception;

public class DAOInvalidFormatException extends DAOException {
    public DAOInvalidFormatException() {
    }

    public DAOInvalidFormatException(String message) {
        super(message);
    }

    public DAOInvalidFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public DAOInvalidFormatException(Throwable cause) {
        super(cause);
    }
}
