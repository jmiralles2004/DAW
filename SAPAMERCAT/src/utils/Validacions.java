package utils;

import exceptions.NegatiuException;
import exceptions.LimitCaracteresException;
import exceptions.DataCaducitatException;

import java.time.LocalDate;

public class Validacions {

    public static void validarPreu(double preu) throws NegatiuException {
        if (preu < 0) {
            throw new NegatiuException("Error: El preu no pot ser negatiu.");
        }
    }

    public static void validarCodiBarres(String codiBarres) throws LimitCaracteresException {
        if (codiBarres.length() > 13) {
            throw new LimitCaracteresException("Error: El codi de barres no pot tenir més de 13 caràcters.");
        }
    }

    public static void validarComposicio(String composicio) throws LimitCaracteresException {
        if (composicio.length() > 100) {
            throw new LimitCaracteresException("Error: La composició tèxtil no pot tenir més de 100 caràcters.");
        }
    }

    public static void validarDataCaducitat(LocalDate dataCaducitat) throws DataCaducitatException {
        if (dataCaducitat.isBefore(LocalDate.now())) {
            throw new DataCaducitatException("Error: La data de caducitat no pot ser anterior a avui.");
        }
    }
}