package model;

import exceptions.LimitCaracteresException;
import utils.Validacions;

public class Textil extends Product {
    private String composicio;

    public Textil(String nom, double preu, String codiBarres, String composicio) throws LimitCaracteresException {
        super(nom, preu, codiBarres);
        Validacions.validarComposicio(composicio); // Usamos Validacions para la validación
        this.composicio = composicio;
    }

    public String getComposicio() {
        return composicio;
    }

    public void setComposicio(String composicio) {
        this.composicio = composicio;
    }

    @Override
    public double calcularPrecio() {
        return preu; // El precio no cambia
    }

    @Override
    public String toString() {
        return super.toString() + " | Composició: " + composicio;
    }
}