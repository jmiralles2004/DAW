package exceptions;

/**
 * Excepció llançada quan la validació de límits de caràcters falla.
 * Això pot ser degut a diversos motius, com ara:
 * El text supera el límit màxim de caràcters permès.
 * El text conté caràcters no permesos (com números en un camp de només lletres).
 * El format del text no compleix amb els requisits establerts.
 * 
 * @author Joan Miralles Carmona
 */
public class LimitCaracteresException extends Exception {

    /**
     * Construeix una nova LimitCaracteresException amb un missatge d'error predeterminat.
     * Aquest constructor crea una excepció que indica que el text supera el límit de caràcters permès.
     */
    public LimitCaracteresException() {
        super("Error: El text supera el límit de caràcters permès.");
    }

    /**
     * Construeix una nova LimitCaracteresException amb un missatge d'error personalitzat.
     * Això permet missatges d'error més específics relacionats amb la validació de caràcters.
     *
     * @param message El missatge d'error personalitzat que descriu l'error de validació.
     */
    public LimitCaracteresException(String message) {
        super(message);
    }
}