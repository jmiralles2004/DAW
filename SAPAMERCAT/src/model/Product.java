package model;

import exceptions.NegatiuException;
import exceptions.LimitCaracteresException;
import utils.Validacions;

public abstract class Product implements Calculable {
    protected String nom;
    protected double preu;
    protected String codiBarres;

    // Constructor
    public Product(String nom, double preu, String codiBarres) throws NegatiuException, LimitCaracteresException {
        Validacions.validarPreu(preu); // Validación del precio
        Validacions.validarCodiBarres(codiBarres); // Validación del código de barras
        this.nom = nom;
        this.preu = preu;
        this.codiBarres = codiBarres;
    }

    // Getters y Setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPreu() {
        return preu;
    }

    public void setPreu(double preu) {
        this.preu = preu;
    }

    public String getCodiBarres() {
        return codiBarres;
    }

    public void setCodiBarres(String codiBarres) {
        this.codiBarres = codiBarres;
    }

    // Método toString para mostrar la información del producto
    @Override
    public String toString() {
        return nom + " (" + codiBarres + ") - " + preu + "€";
    }
}