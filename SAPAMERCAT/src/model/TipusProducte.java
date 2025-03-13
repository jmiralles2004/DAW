package model;

/**
 * Defineix els tipus de productes disponibles al sistema SAPAMERCAT.
 * Aquest enumerat s'utilitza per classificar els productes en categories específiques que determinen el seu comportament i atributs:
 * - ALIMENTACIO: Productes amb data de caducitat que afecta el preu.
 * - TEXTIL: Productes amb composició específica i preu estable.
 * - ELECTRONICA: Productes amb garantia que afecta el preu.
 * L'enumerat s'utilitza principalment en la creació de productes i en el menú per seleccionar el tipus de producte a afegir.
 * 
 * @author Joan Miralles Carmona
 */
public enum TipusProducte {
    /**
     * Productes alimentaris amb data de caducitat.
     */
    ALIMENTACIO,

    /**
     * Productes tèxtils amb composició específica.
     */
    TEXTIL,

    /**
     * Productes electrònics amb garantia.
     */
    ELECTRONICA;
}