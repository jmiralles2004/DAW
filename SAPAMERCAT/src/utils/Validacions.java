package utils;

import exceptions.NegatiuException;
import exceptions.LimitCaracteresException;
import exceptions.DataCaducitatException;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/**
 * Classe d'utilitat que proporciona mètodes de validació per als diferents atributs dels productes.
 * Aquesta classe conté mètodes estàtics per validar:
 * - Preus (no negatius ni zero).
 * - Codis de barres (només números, màxim 13 caràcters).
 * - Composicions tèxtils (ha de ser una de les vàlides).
 * - Dates de caducitat (no pot ser anterior a la data actual).
 * - Noms (només lletres).
 * 
 * @author Joan Miralles Carmona
 */
public class Validacions {

    /**
     * Llista de composicions tèxtils vàlides per als productes tèxtils.
     * Actualment inclou: cotó, llana i seda.
     */
    private static final List<String> VALID_COMPOSITIONS = Arrays.asList(
            "cotó", "llana", "seda");

    /**
     * Valida que el preu no sigui negatiu ni zero.
     *
     * @param preu El preu a validar.
     * @throws NegatiuException Si el preu és negatiu o zero.
     */
    public static void validarPreu(double preu) throws NegatiuException {
        if (preu < 0) {
            throw new NegatiuException("Error: El preu no pot ser negatiu.");
        }
        if (preu == 0) {
            throw new NegatiuException("Error: El preu no pot ser gratuït (0).");
        }
    }

    /**
     * Valida que el codi de barres compleixi els requisits:
     * - Màxim 13 caràcters.
     * - Només pot contenir números.
     *
     * @param codiBarres El codi de barres a validar.
     * @throws LimitCaracteresException Si el codi de barres no compleix els requisits.
     */
    public static void validarCodiBarres(String codiBarres) throws LimitCaracteresException {
        if (codiBarres.length() > 13) {
            throw new LimitCaracteresException("Error: El codi de barres no pot tenir més de 13 caràcters.");
        }
        if (!codiBarres.matches("[0-9]+")) {
            throw new LimitCaracteresException("Error: El codi de barres només pot contenir números.");
        }
    }

    /**
     * Valida que la composició tèxtil sigui una de les vàlides.
     * Comprova que la composició no superi els 100 caràcters i que estigui inclosa a la llista de composicions vàlides.
     *
     * @param composicio La composició tèxtil a validar.
     * @throws LimitCaracteresException Si la composició no és vàlida o supera els 100 caràcters.
     */
    public static void validarComposicio(String composicio) throws LimitCaracteresException {
        if (composicio.length() > 100) {
            throw new LimitCaracteresException("Error: La composició tèxtil no pot tenir més de 100 caràcters.");
        }


        if (!VALID_COMPOSITIONS.stream().anyMatch(comp -> comp.equalsIgnoreCase(composicio))) {
            StringBuilder errorMessage = new StringBuilder();
            errorMessage.append("Error: La composició tèxtil no és vàlida. ");
            errorMessage.append("Opcions vàlides: ");
            errorMessage.append(String.join(", ", VALID_COMPOSITIONS));
            throw new LimitCaracteresException(errorMessage.toString());
        }
    }

    /**
     * Valida que la data de caducitat no sigui anterior a la data actual.
     *
     * @param dataCaducitat La data de caducitat a validar.
     * @throws DataCaducitatException Si la data de caducitat és anterior a la data actual.
     */
    public static void validarDataCaducitat(LocalDate dataCaducitat) throws DataCaducitatException {
        if (dataCaducitat.isBefore(LocalDate.now())) {
            throw new DataCaducitatException("Error: La data de caducitat no pot ser anterior a avui.");
        }
    }

    /**
     * Valida que el nom només contingui lletres i espais.
     *
     * @param nom El nom a validar.
     * @throws LimitCaracteresException Si el nom conté caràcters que no són lletres o espais.
     */
    public static void validarNom(String nom) throws LimitCaracteresException {
        if (!nom.matches("[a-zA-ZÀ-ÿ\\s]+")) {
            throw new LimitCaracteresException("Error: El nom només pot contenir lletres.");
        }
    }

    /**
     * Retorna la llista de composicions tèxtils vàlides.
     *
     * @return Llista de composicions vàlides (cotó, llana, seda).
     */
    public static List<String> getValidCompositions() {
        return VALID_COMPOSITIONS;
    }
}