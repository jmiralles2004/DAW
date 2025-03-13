package exceptions;

/**
 * Excepció llançada quan s'intenta superar el límit màxim de productes permesos.
 * Això pot ser degut a diversos motius, com ara:
 * S'intenta afegir més productes dels permesos al carret de la compra.
 * S'ha arribat al límit d'elements que pot gestionar el sistema.
 * S'ha superat la capacitat màxima d'emmagatzematge.
 * 
 * @author Joan Miralles Carmona
 */
public class LimitProductesException extends Exception {

    /**
     * Construeix una nova LimitProductesException amb un missatge d'error personalitzat.
     * Aquest constructor s'utilitza per indicar que s'ha sobrepassat el límit de productes permès en el carret de compra o en altres col·leccions del sistema.
     *
     * @param message El missatge d'error personalitzat que descriu l'error específic relacionat amb el límit de productes
     */
    public LimitProductesException(String message) {
        super(message);
    }

    /**
     * Construeix una nova LimitProductesException amb un missatge d'error predeterminat.
     * Aquest constructor crea una excepció que indica que s'ha sobrepassat el límit de productes permès.
     */
    public LimitProductesException() {
        super("Error: S'ha superat el límit màxim de productes permesos.");
    }
}