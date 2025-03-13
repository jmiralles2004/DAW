package model;

import exceptions.NegatiuException;
import exceptions.LimitCaracteresException;

/**
 * Representa un producte electrònic amb dies de garantia.
 * Aquesta classe gestiona productes de tipus electrònica amb característiques específiques:
 * - Dies de garantia que afecten el preu del producte.
 * - Càlcul del preu basat en la durada de la garantia.
 * - Validació per assegurar que els dies de garantia no siguin negatius.
 * 
 * @author Joan Miralles Carmona
 */
public class Electronica extends Product {
    private int garantia;

    /**
     * Construeix un nou producte electrònic amb les dades proporcionades.
     * Valida que els dies de garantia no siguin negatius.
     *
     * @param nom El nom del producte electrònic.
     * @param preu El preu base del producte.
     * @param codiBarres El codi de barres únic del producte.
     * @param garantia Els dies de garantia del producte.
     * @throws NegatiuException Si la garantia és negativa o el preu és negatiu o zero.
     * @throws LimitCaracteresException Si el codi de barres no compleix amb els requisits.
     */
    public Electronica(String nom, double preu, String codiBarres, int garantia)
            throws NegatiuException, LimitCaracteresException {
        super(nom, preu, codiBarres);
        if (garantia < 0) {
            throw new NegatiuException("Error: La garantia no pot ser negativa.");
        }
        this.garantia = garantia;
    }

    /**
     * Retorna els dies de garantia del producte.
     *
     * @return Els dies de garantia.
     */
    public int getGarantia() {
        return garantia;
    }

    /**
     * Estableix nous dies de garantia per al producte.
     *
     * @param garantia Els nous dies de garantia.
     */
    public void setGarantia(int garantia) {
        this.garantia = garantia;
    }

    /**
     * Calcula el preu del producte tenint en compte els dies de garantia.
     * La fórmula aplicada és: preu + preu * (garantia/365) * 0.1.
     * A més dies de garantia, més alt serà el preu.
     *
     * @return El preu calculat segons els dies de garantia.
     */
    @Override
    public double calcularPreu() {
        return preu + preu * ((double) garantia / 365) * 0.1;
    }

    /**
     * Retorna una representació en format text del producte electrònic.
     * Inclou la informació bàsica del producte més els dies de garantia.
     *
     * @return Representació del producte en format text.
     */
    @Override
    public String toString() {
        return super.toString() + " | Garantia: " + garantia + " dies";
    }
}