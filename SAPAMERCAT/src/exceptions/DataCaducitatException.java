package exceptions;

public class DataCaducitatException extends Exception {

    public DataCaducitatException() {
        super("Error: La data de caducitat no pot ser anterior a avui.");
    }

    public DataCaducitatException(String message) {
        super(message);
    }
}