package model;

import exceptions.NegatiuException;
import exceptions.LimitCaracteresException;
import utils.Validacions;

/**
 * Classe abstracta que representa un producte genèric a la botiga.
 * Aquesta classe proporciona l'estructura bàsica comuna a tots els tipus de productes:
 * - Atributs bàsics com nom, preu i codi de barres.
 * - Validació del preu i del codi de barres.
 * - Implementació de la interfície Calculable per al càlcul del preu.
 * 
 * Les classes derivades han d'implementar el mètode calcularPreu() per proporcionar el càlcul específic segons el tipus de producte.
 * 
 * @author Joan Miralles Carmona
 */
public abstract class Product implements Calculable {
    protected String nom;
    protected double preu;
    protected String codiBarres;

    /**
     * Construeix un nou producte amb les dades proporcionades.
     * Valida que el preu no sigui negatiu ni zero i que el codi de barres compleixi amb els requisits.
     *
     * @param nom El nom del producte.
     * @param preu El preu base del producte.
     * @param codiBarres El codi de barres únic del producte.
     * @throws NegatiuException Si el preu és negatiu o zero.
     * @throws LimitCaracteresException Si el codi de barres no compleix amb els requisits.
     */
    public Product(String nom, double preu, String codiBarres)
            throws NegatiuException, LimitCaracteresException {
        Validacions.validarPreu(preu);
        Validacions.validarCodiBarres(codiBarres);
        this.nom = nom;
        this.preu = preu;
        this.codiBarres = codiBarres;
    }

    /**
     * Retorna el nom del producte.
     *
     * @return El nom del producte.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Estableix un nou nom per al producte.
     *
     * @param nom El nou nom del producte.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Retorna el preu base del producte.
     *
     * @return El preu base del producte.
     */
    public double getPreu() {
        return preu;
    }

    /**
     * Estableix un nou preu base per al producte.
     *
     * @param preu El nou preu base del producte.
     */
    public void setPreu(double preu) {
        this.preu = preu;
    }

    /**
     * Retorna el codi de barres del producte.
     *
     * @return El codi de barres del producte.
     */
    public String getCodiBarres() {
        return codiBarres;
    }

    /**
     * Estableix un nou codi de barres per al producte.
     *
     * @param codiBarres El nou codi de barres del producte.
     */
    public void setCodiBarres(String codiBarres) {
        this.codiBarres = codiBarres;
    }

    /**
     * Retorna una representació en format text del producte.
     * Inclou el nom, codi de barres i preu del producte.
     *
     * @return Representació del producte en format text.
     */
    @Override
    public String toString() {
        return nom + " (" + codiBarres + ") - " + preu + " EUR";
    }
}