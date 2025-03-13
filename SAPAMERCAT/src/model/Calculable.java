package model;

/**
 * Interfície que defineix la capacitat d'un objecte per calcular el seu preu.
 * Aquesta interfície és implementada per totes les classes de productes que necessiten calcular el seu preu de manera específica, permetent així diferents fórmules de càlcul segons el tipus de producte:
 * - Productes d'alimentació: El preu varia segons la proximitat a la data de caducitat.
 * - Productes tèxtils: El preu es manté sense canvis.
 * - Productes electrònics: El preu s'ajusta segons els dies de garantia.
 * 
 * @author Joan Miralles Carmona
 */
public interface Calculable {
    
    /**
     * Calcula el preu actual del producte.
     * Aquest mètode aplica les regles específiques de cada tipus de producte per determinar el seu preu final.
     *
     * @return El preu calculat del producte.
     */
    double calcularPreu();
}