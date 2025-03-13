package exceptions;

public class LimitCaracteresException extends Exception {

    public LimitCaracteresException() {
        super("Error: El text supera el límit de caràcters permès.");
    }

    public LimitCaracteresException(String message) {
        super(message);
    }
}