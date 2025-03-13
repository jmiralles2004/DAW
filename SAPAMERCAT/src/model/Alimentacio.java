package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import exceptions.DataCaducitatException;
import exceptions.LimitCaracteresException;
import exceptions.NegatiuException;
import utils.Validacions;

/**
 * Representa un producte alimentari amb data de caducitat.
 * Aquesta classe gestiona productes de tipus alimentació amb característiques específiques:
 * - Data de caducitat que afecta el preu del producte.
 * - Càlcul del preu basat en la proximitat a la data de caducitat.
 * - Validació per assegurar que la data de caducitat no sigui anterior a la data actual.
 * 
 * @author Joan Miralles Carmona
 */
public class Alimentacio extends Product {
    private LocalDate dataCaducitat;
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    /**
     * Construeix un nou producte d'alimentació amb les dades proporcionades.
     * Valida la data de caducitat per assegurar que no és anterior a la data actual.
     *
     * @param nom El nom del producte d'alimentació.
     * @param preu El preu base del producte.
     * @param codiBarres El codi de barres únic del producte.
     * @param dataCaducitat La data de caducitat del producte.
     * @throws DataCaducitatException Si la data de caducitat és anterior a la data actual.
     * @throws NegatiuException Si el preu és negatiu o zero.
     * @throws LimitCaracteresException Si el codi de barres no compleix amb els requisits.
     */
    public Alimentacio(String nom, double preu, String codiBarres, LocalDate dataCaducitat)
            throws DataCaducitatException, NegatiuException, LimitCaracteresException {
        super(nom, preu, codiBarres);
        Validacions.validarDataCaducitat(dataCaducitat);
        this.dataCaducitat = dataCaducitat;
    }

    /**
     * Retorna la data de caducitat del producte.
     *
     * @return La data de caducitat en format LocalDate.
     */
    public LocalDate getDataCaducitat() {
        return dataCaducitat;
    }

    /**
     * Estableix una nova data de caducitat per al producte.
     *
     * @param dataCaducitat La nova data de caducitat del producte.
     */
    public void setDataCaducitat(LocalDate dataCaducitat) {
        this.dataCaducitat = dataCaducitat;
    }

    /**
     * Calcula el preu del producte tenint en compte la proximitat a la data de caducitat.
     * Si el producte ha caducat, el seu preu és 0.
     * La fórmula aplicada és: preu - preu * (1.0 / (diesRestants + 1)) + (preu * 0.1).
     *
     * @return El preu calculat segons els dies que falten per caducar.
     */
    @Override
    public double calcularPreu() {
        LocalDate dataActual = LocalDate.now();
        long diesRestants = ChronoUnit.DAYS.between(dataActual, dataCaducitat);

        if (diesRestants < 0) {
            return 0;
        }

        return preu - preu * (1.0 / (diesRestants + 1)) + (preu * 0.1);
    }

    /**
     * Retorna una representació en format text del producte d'alimentació.
     * Inclou la informació bàsica del producte més la data de caducitat formatada.
     *
     * @return Representació del producte en format text.
     */
    @Override
    public String toString() {
        return super.toString() + " | Caduca el: " + dataCaducitat.format(DATE_FORMATTER);
    }
}