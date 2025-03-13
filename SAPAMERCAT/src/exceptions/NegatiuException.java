package exceptions;

/**
 * Excepció llançada quan es detecta un valor negatiu invàlid.
 * Això pot ser degut a diversos motius, com ara:
 * S'intenta establir un preu negatiu per a un producte.
 * S'intenta establir una quantitat negativa d'unitats.
 * S'intenta establir dies de garantia negatius.
 * 
 * @author Joan Miralles Carmona
 */
public class NegatiuException extends Exception {

    /**
     * Construeix una nova NegatiuException amb un missatge d'error predeterminat.
     * Aquest constructor crea una excepció que indica que el valor no pot ser negatiu.
     */
    public NegatiuException() {
        super("Error: El valor no pot ser negatiu.");
    }

    /**
     * Construeix una nova NegatiuException amb un missatge d'error personalitzat.
     * Això permet missatges d'error més específics relacionats amb valors negatius invàlids.
     *
     * @param message El missatge d'error personalitzat que descriu l'error específic.
     */
    public NegatiuException(String message) {
        super(message);
    }
}