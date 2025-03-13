package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import exceptions.DataCaducitatException;
import utils.Validacions;

public class Alimentacio extends Product {
    private LocalDate dataCaducitat;

    public Alimentacio(String nom, double preu, String codiBarres, LocalDate dataCaducitat) throws DataCaducitatException {
        super(nom, preu, codiBarres);
        Validacions.validarDataCaducitat(dataCaducitat); // Usamos Validacions
        this.dataCaducitat = dataCaducitat;
    }

    public LocalDate getDataCaducitat() {
        return dataCaducitat;
    }

    public void setDataCaducitat(LocalDate dataCaducitat) {
        this.dataCaducitat = dataCaducitat;
    }

    @Override
    public double calcularPrecio() {
        LocalDate dataActual = LocalDate.now();
        long diesRestants = ChronoUnit.DAYS.between(dataActual, dataCaducitat);

        if (diesRestants < 0) {
            return 0; // El producto ha caducado, precio 0
        }
        return preu - preu * (1.0 / (diesRestants + 1)) + (preu * 0.1);
    }

    @Override
    public String toString() {
        return super.toString() + " | Caduca el: " + dataCaducitat;
    }
}