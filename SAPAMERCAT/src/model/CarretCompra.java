package model;

import utils.Printable;
import utils.Searchable;
import exceptions.LimitProductesException;

import java.util.*;

public class CarretCompra implements Printable, Searchable<Product> {
    private List<Product> productes;
    private Map<String, Integer> quantitats;

    public CarretCompra() {
        this.productes = new ArrayList<>();
        this.quantitats = new HashMap<>();
    }

    // Método para afegir productes al carret
    @Override
    public void afegirProducte(Product producte) throws LimitProductesException {
        if (productes.size() >= 100) {
            throw new LimitProductesException("Error: No pots afegir més de 100 productes al carret!");
        }
        if (!quantitats.containsKey(producte.getCodiBarres())) {
            productes.add(producte);
        }
        quantitats.put(producte.getCodiBarres(), quantitats.getOrDefault(producte.getCodiBarres(), 0) + 1);
    }

    // Mostrar el carret sense preus
    @Override
    public void mostrarCarret() {
        System.out.println("----- CARRET -----");

        // Ordenar los productos Textil por composición
        List<Textil> productesTextil = new ArrayList<>();
        for (Product p : productes) {
            if (p instanceof Textil) {
                productesTextil.add((Textil) p);
            }
        }
        Collections.sort(productesTextil, new TextilComparator());

        for (Textil textil : productesTextil) {
            System.out.println(textil);
        }

        // Mostrar productos no textil
        for (String codi : quantitats.keySet()) {
            if (!(productesTextil.stream().anyMatch(t -> t.getCodiBarres().equals(codi)))) {
                System.out.println(codi + " → " + quantitats.get(codi) + " unitats");
            }
        }
    }

    // Generar el tiquet de compra
    @Override
    public void imprimir() {
        System.out.println("\n--------- SAPAMERCAT ---------");
        System.out.println("Data: " + new Date());
        System.out.println("--------------------------------");

        // Ordenar los productos por precio
        Collections.sort(productes, new ProductComparator());

        double total = 0;
        for (String codi : quantitats.keySet()) {
            Product prod = productes.stream().filter(p -> p.getCodiBarres().equals(codi)).findFirst().orElse(null);
            if (prod != null) {
                int quantitat = quantitats.get(codi);
                double preuUnitari = prod.calcularPrecio();
                double preuTotal = preuUnitari * quantitat;
                total += preuTotal;

                System.out.printf("%-10s %2d  %.2f€  %.2f€\n", prod.getNom(), quantitat, preuUnitari, preuTotal);
            }
        }

        System.out.println("--------------------------------");
        System.out.printf("Total: %.2f€\n", total);
        productes.clear();
        quantitats.clear();
    }

    // Buscar un producte pel codi de barres
    @Override
    public Product buscar(String codiBarres) {
        return productes.stream().filter(p -> p.getCodiBarres().equals(codiBarres)).findFirst().orElse(null);
    }
}