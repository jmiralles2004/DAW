package model;

import exceptions.LimitCaracteresException;
import exceptions.NegatiuException;
import utils.Validacions;

/**
 * Representa un producte tèxtil amb composició específica.
 * Aquesta classe gestiona productes de tipus tèxtil amb característiques específiques:
 * - Composició del material tèxtil (cotó, llana, seda).
 * - Validació per assegurar que la composició sigui una de les permeses.
 * - Manteniment del preu base sense modificacions.
 * 
 * @author Joan Miralles Carmona
 */
public class Textil extends Product {
    private String composicio;

    /**
     * Construeix un nou producte tèxtil amb les dades proporcionades.
     * Valida que la composició sigui una de les permeses pel sistema.
     *
     * @param nom El nom del producte tèxtil.
     * @param preu El preu base del producte.
     * @param codiBarres El codi de barres únic del producte.
     * @param composicio La composició del teixit (cotó, llana, seda).
     * @throws LimitCaracteresException Si la composició no és vàlida o el codi de barres no compleix amb els requisits.
     * @throws NegatiuException Si el preu és negatiu o zero.
     */
    public Textil(String nom, double preu, String codiBarres, String composicio)
            throws LimitCaracteresException, NegatiuException {
        super(nom, preu, codiBarres);
        Validacions.validarComposicio(composicio);
        this.composicio = composicio;
    }

    /**
     * Retorna la composició del producte tèxtil.
     *
     * @return La composició del teixit.
     */
    public String getComposicio() {
        return composicio;
    }

    /**
     * Estableix una nova composició per al producte tèxtil.
     *
     * @param composicio La nova composició del teixit.
     */
    public void setComposicio(String composicio) {
        this.composicio = composicio;
    }

    /**
     * Calcula el preu del producte tèxtil.
     * En aquest cas, el preu no es modifica i és igual al preu base.
     *
     * @return El preu base del producte.
     */
    @Override
    public double calcularPreu() {
        return preu;
    }

    /**
     * Retorna una representació en format text del producte tèxtil.
     * Inclou la informació bàsica del producte més la composició del teixit.
     *
     * @return Representació del producte en format text.
     */
    @Override
    public String toString() {
        return super.toString() + " | Composició: " + composicio;
    }
}