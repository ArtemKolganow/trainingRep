package by.training.finalproject.dal;

public class DataObjectException extends Exception {
    public DataObjectException() {
    }

    public DataObjectException(String message) {
        super(message);
    }

    public DataObjectException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataObjectException(Throwable cause) {
        super(cause);
    }
}
