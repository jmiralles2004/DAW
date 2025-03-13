package model;

import utils.Addable;
import utils.Printable;
import utils.Searchable;
import exceptions.LimitProductesException;

import java.util.*;
import java.text.SimpleDateFormat;

/**
 * Representa un carret de compra que gestiona els productes afegits i les seves quantitats.
 * Aquesta classe proporciona funcionalitats per:
 * - Afegir nous productes al carret o incrementar la quantitat dels existents.
 * - Visualitzar el contingut del carret sense preus.
 * - Generar un tiquet de compra amb preus i total.
 * - Cercar productes per codi de barres.
 * 
 * La classe implementa:
 * - Printable: per generar tiquets de compra.
 * - Searchable: per cercar productes.
 * - Addable: per afegir productes.
 * 
 * @author Joan Miralles Carmona
 */
public class CarretCompra implements Printable, Searchable<Product>, Addable {
    private List<Product> productes;
    private Map<String, Integer> quantitats;

    /**
     * Construeix un nou carret de compra buit.
     * Inicialitza la llista de productes i el mapa de quantitats.
     */
    public CarretCompra() {
        this.productes = new ArrayList<>();
        this.quantitats = new HashMap<>();
    }

    /**
     * Afegeix un producte al carret o incrementa la seva quantitat si ja existeix.
     * Si el producte amb el mateix codi de barres ja existeix, s'incrementa la quantitat.
     * Si el producte és nou, s'afegeix a la llista i s'estableix la quantitat inicial a 1.
     *
     * @param producte El producte a afegir al carret.
     * @throws LimitProductesException Si s'intenta afegir més de 100 productes diferents.
     */
    @Override
    public void afegirProducte(Product producte) throws LimitProductesException {
        if (productes.size() >= 100) {
            throw new LimitProductesException("Error: No pots afegir més de 100 productes al carret!");
        }

        if (quantitats.containsKey(producte.getCodiBarres())) {
            quantitats.put(producte.getCodiBarres(), quantitats.get(producte.getCodiBarres()) + 1);
        } else {
            productes.add(producte);
            quantitats.put(producte.getCodiBarres(), 1);
        }
    }

    /**
     * Mostra el contingut del carret sense preus.
     * Els productes tèxtils es mostren ordenats per composició.
     * Per cada producte es mostra el nom i la quantitat.
     * Si el carret està buit, es mostra un missatge indicant-ho.
     */
    public void mostrarCarret() {
        System.out.println("----- CARRET -----");

        if (productes.isEmpty()) {
            System.out.println("El carret està buit.");
            System.out.println();
            return;
        }

        List<Textil> productesTextil = new ArrayList<>();
        List<Product> altresProductes = new ArrayList<>();

        for (Product p : productes) {
            if (p instanceof Textil) {
                productesTextil.add((Textil) p);
            } else {
                altresProductes.add(p);
            }
        }

        Collections.sort(productesTextil, new TextilComparator());

        productesTextil.forEach(textil -> {
            int quantitat = quantitats.get(textil.getCodiBarres());
            System.out.printf("%s - %d unitat%s\n", textil.getNom(), quantitat, quantitat > 1 ? "s" : "");
        });

        altresProductes.forEach(prod -> {
            int quantitat = quantitats.get(prod.getCodiBarres());
            System.out.printf("%s - %d unitat%s\n", prod.getNom(), quantitat, quantitat > 1 ? "s" : "");
        });

        System.out.println();
    }

    /**
     * Genera un tiquet de compra amb els productes, quantitats i preus.
     * Els productes es mostren ordenats per preu.
     * El tiquet inclou:
     * - Capçalera de SAPAMERCAT.
     * - Data i hora actual.
     * - Llista de productes amb nom, quantitat, preu unitari i total.
     * - Total de la compra.
     * Després de generar el tiquet, es buida el carret.
     */
    @Override
    public void imprimir() {
        System.out.println("\n--------- SAPAMERCAT ---------");

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        System.out.println("Data: " + dateFormat.format(new Date()));
        System.out.println("--------------------------------");

        Collections.sort(productes, new ProductComparator());

        double total = 0;
        for (String codi : quantitats.keySet()) {
            Product prod = productes.stream().filter(p -> p.getCodiBarres().equals(codi)).findFirst().orElse(null);
            if (prod != null) {
                int quantitat = quantitats.get(codi);
                double preuUnitari = prod.calcularPreu();
                double preuTotal = preuUnitari * quantitat;
                total += preuTotal;
                System.out.printf("%-10s %2d  %.2f EUR  %.2f EUR\n", prod.getNom(), quantitat, preuUnitari, preuTotal);
            }
        }

        System.out.println("--------------------------------");
        System.out.printf("Total: %.2f EUR\n", total);
        System.out.println();
        productes.clear();
        quantitats.clear();
    }

    /**
     * Cerca un producte al carret pel seu codi de barres.
     *
     * @param codiBarres El codi de barres del producte a cercar.
     * @return El producte si es troba al carret, o null si no existeix.
     */
    @Override
    public Product buscar(String codiBarres) {
        return productes.stream().filter(p -> p.getCodiBarres().equals(codiBarres)).findFirst().orElse(null);
    }
}