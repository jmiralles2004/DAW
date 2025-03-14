package model;

import java.util.Comparator;

/**
 * Comparador de productes tèxtils que permet ordenar-los segons la seva composició.
 * Aquest comparador s'utilitza principalment per ordenar els productes tèxtils en el carret de compra, agrupant-los per material (cotó, llana, seda).
 * La comparació es basa en l'ordenació alfabètica dels noms de les composicions.
 * 
 * @author Joan Miralles Carmona
 */
public class TextilComparator implements Comparator<Textil> {

    /**
     * Compara dos productes tèxtils segons la seva composició.
     * El mètode utilitza la comparació alfabètica estàndard de cadenes de text.
     *
     * @param t1 El primer producte tèxtil a comparar.
     * @param t2 El segon producte tèxtil a comparar.
     * @return Un valor negatiu si t1 té una composició alfabèticament anterior a t2, zero si les composicions són iguals, o un valor positiu si t1 té una composició alfabèticament posterior a t2.
     */
    @Override
    public int compare(Textil t1, Textil t2) {
        return t1.getComposicio().compareTo(t2.getComposicio());
    }
}