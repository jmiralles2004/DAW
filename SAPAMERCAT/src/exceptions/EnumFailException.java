package exceptions;

/**
 * Excepció llançada quan es produeix un error relacionat amb un valor enumerat.
 * Això pot ser degut a diversos motius, com ara:
 * S'intenta utilitzar un tipus de producte que no existeix.
 * El valor proporcionat no coincideix amb cap de les opcions vàlides de l'enumeració.
 * 
 * @author Joan Miralles Carmona
 */
public class EnumFailException extends Exception {

    /**
     * Construeix una nova EnumFailException amb un missatge d'error predeterminat.
     * Aquest constructor crea una excepció que indica que el tipus de producte no és vàlid.
     */
    public EnumFailException() {
        super("Error: El tipus de producte no és vàlid.");
    }

    /**
     * Construeix una nova EnumFailException amb un missatge d'error personalitzat.
     * Això permet missatges d'error més específics relacionats amb valors enumerats invàlids.
     *
     * @param message El missatge d'error personalitzat que descriu l'error de validació.
     */
    public EnumFailException(String message) {
        super(message);
    }
}