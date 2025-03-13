package model;

import exceptions.NegatiuException;

public class Electronica extends Product {
    private int garantia; // Días de garantía

    public Electronica(String nom, double preu, String codiBarres, int garantia) throws NegatiuException {
        super(nom, preu, codiBarres);
        if (garantia < 0) {
            throw new NegatiuException("Error: La garantia no pot ser negativa.");
        }
        this.garantia = garantia;
    }

    public int getGarantia() {
        return garantia;
    }

    public void setGarantia(int garantia) {
        this.garantia = garantia;
    }

    @Override
    public double calcularPrecio() {
        return preu + preu * ((double) garantia / 365) * 0.1;
    }

    @Override
    public String toString() {
        return super.toString() + " | Garantia: " + garantia + " dies";
    }
}