package utils;

/**
 * Interfície que defineix la capacitat de cercar i recuperar elements.
 * Aquesta interfície genèrica és implementada per classes que necessiten proporcionar funcionalitat de cerca, com ara el carret de compra.
 * El paràmetre genèric T representa el tipus d'objecte que es pot cercar i recuperar (per exemple, Product).
 * Aquesta interfície s'utilitza principalment per:
 * - Cercar productes al carret de compra per codi de barres.
 * - Implementar funcionalitat de cerca en altres col·leccions d'objectes.
 * 
 * @author Joan Miralles Carmona
 * @param <T> El tipus d'objecte que es pot cercar i recuperar.
 */
public interface Searchable<T> {
    
    /**
     * Cerca un element pel seu codi de barres.
     * 
     * @param codiBarres El codi de barres de l'element a cercar.
     * @return L'element trobat del tipus T, o null si no es troba cap element amb aquest codi.
     */
    T buscar(String codiBarres);
}