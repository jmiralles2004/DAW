package exceptions;

public class EnumFailException extends Exception {

    public EnumFailException() {
        super("Error: El tipus de producte no és vàlid.");
    }

    public EnumFailException(String message) {
        super(message);
    }
}