package model;

import java.util.Comparator;

/**
 * Comparador de productes que permet ordenar-los segons el seu preu.
 * Aquest comparador s'utilitza en diverses situacions, com ara:
 * - En la generació del tiquet de compra per mostrar els productes ordenats per preu.
 * - En operacions de classificació de l'inventari.
 * - En processos d'anàlisi de preus de productes.
 * 
 * @author Joan Miralles Carmona
 */
public class ProductComparator implements Comparator<Product> {
    
    /**
     * Compara dos productes segons el seu preu.
     * La comparació es realitza utilitzant Double.compare() per evitar problemes amb els valors de punt flotant i garantir una ordenació estable.
     *
     * @param p1 El primer producte a comparar.
     * @param p2 El segon producte a comparar.
     * @return Un valor negatiu si p1 té un preu menor que p2, zero si els preus són iguals, o un valor positiu si p1 té un preu major que p2.
     */
    @Override
    public int compare(Product p1, Product p2) {
        return Double.compare(p1.getPreu(), p2.getPreu());
    }
}