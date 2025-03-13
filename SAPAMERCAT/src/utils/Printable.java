package utils;

/**
 * Interfície que defineix la capacitat d'un objecte per generar una representació impresa.
 * Aquesta interfície és implementada per classes que necessiten crear sortides formades, com ara tiquets de compra o informes.
 * Aquesta interfície s'utilitza principalment per:
 * - Generar tiquets de compra amb el carret dels productes seleccionats.
 * - Mostrar informació formatada sobre els productes i les seves característiques.
 * 
 * @author Joan Miralles Carmona
 */
public interface Printable {

    /**
     * Genera una representació impresa de l'objecte.
     * En el cas del carret de compra, aquest mètode mostra tots els productes, els seus preus i el total de la compra en un format estructurat.
     */
    void imprimir();
}