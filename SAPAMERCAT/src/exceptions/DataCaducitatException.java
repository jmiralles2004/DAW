package exceptions;

/**
 * Excepció llançada quan la validació d'una data de caducitat falla.
 * Això pot ser degut a diversos motius, com ara:
 * S'estableix una data de caducitat en el passat.
 * El format de la data és vàlid però la data de caducitat és anterior a la data actual.
 * 
 * @author Joan Miralles Carmona
 */
public class DataCaducitatException extends Exception {

    /**
     * Construeix una nova DataCaducitatException amb un missatge d'error predeterminat.
     * Aquest constructor crea una excepció que indica que la data de caducitat no pot ser anterior a la data actual.
     */
    public DataCaducitatException() {
        super("Error: La data de caducitat no pot ser anterior a avui.");
    }

    /**
     * Construeix una nova DataCaducitatException amb un missatge d'error personalitzat.
     * Això permet missatges d'error més específics relacionats amb la validació de dates.
     *
     * @param message El missatge d'error personalitzat que descriu l'error de validació.
     */
    public DataCaducitatException(String message) {
        super(message);
    }
}