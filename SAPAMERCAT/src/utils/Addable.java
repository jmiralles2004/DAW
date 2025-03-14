package utils;

import model.Product;
import exceptions.LimitProductesException;

/**
 * Interfície que defineix la capacitat d'afegir productes.
 * Aquesta interfície és implementada per classes que necessiten gestionar col·leccions de productes, com ara el carret de compra.
 * Proporciona un mètode estàndard per afegir productes i gestionar les excepcions relacionades amb els límits de productes permesos.
 * 
 * @author Joan Miralles Carmona
 */
public interface Addable {
    
    /**
     * Afegeix un producte a la col·lecció.
     * 
     * @param producte El producte a afegir.
     * @throws LimitProductesException Si s'intenta afegir més productes dels permesos o si s'excedeix el límit màxim de la col·lecció.
     */
    void afegirProducte(Product producte) throws LimitProductesException;
}