package by.training.task10treasures.view;

public class InputException extends Exception {
    public InputException() {
    }

    public InputException(String message) {
        super(message);
    }

    public InputException(String message, Throwable cause) {
        super(message, cause);
    }

    public InputException(Throwable cause) {
        super(cause);
    }
}
