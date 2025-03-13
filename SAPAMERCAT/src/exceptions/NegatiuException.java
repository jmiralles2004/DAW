package exceptions;

public class NegatiuException extends Exception {
    public NegatiuException() {
        super("Error: El valor no pot ser negatiu.");
    }

    public NegatiuException(String message) {
        super(message);
    }
}