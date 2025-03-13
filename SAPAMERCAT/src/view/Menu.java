package view;

import model.*;
import utils.Validacions;
import exceptions.*;

import java.util.Scanner;
import java.time.LocalDate;
import java.util.InputMismatchException;

public class Menu {
    private Scanner scanner;
    private CarretCompra carret;

    public Menu() {
        scanner = new Scanner(System.in);
        carret = new CarretCompra();
    }

    public void iniciar() {
        int opcio;
        do {
            mostrarOpcions();
            opcio = llegirEnter();
            gestionarOpcio(opcio);
        } while (opcio != 0);
    }

    private void mostrarOpcions() {
        System.out.println("\n--- MENÚ PRINCIPAL ---");
        System.out.println("1. Afegir producte");
        System.out.println("2. Mostrar carret");
        System.out.println("3. Passar per caixa");
        System.out.println("4. Cercar producte per codi de barres");
        System.out.println("0. Sortir");
        System.out.print("Opció: ");
    }

    private int llegirEnter() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.nextLine();
            System.out.println("Error: Has d'introduir un número.");
            return -1;
        }
    }

    private void gestionarOpcio(int opcio) {
        switch (opcio) {
            case 1:
                afegirProducte();
                break;
            case 2:
                carret.mostrarCarret();
                break;
            case 3:
                carret.imprimir();
                break;
            case 4:
                cercarProducte();
                break;
            case 0:
                System.out.println("Sortint...");
                break;
            default:
                System.out.println("Opció no vàlida. Torna a intentar.");
        }
    }

    private void afegirProducte() {
        try {
            System.out.println("\n--- AFEGIR PRODUCTE ---");
            System.out.print("Tipus de producte (ALIMENTACIO, TEXTIL, ELECTRONICA): ");
            String tipusInput = scanner.next().toUpperCase();
            TipusProducte tipus = TipusProducte.valueOf(tipusInput);
            scanner.nextLine();

            System.out.print("Nom: ");
            String nom = scanner.nextLine();
            Validacions.validarPreu(nom.length()); // Validación del nombre

            System.out.print("Preu: ");
            double preu = scanner.nextDouble();
            scanner.nextLine();
            Validacions.validarPreu(preu);

            System.out.print("Codi de barres: ");
            String codiBarres = scanner.nextLine();
            Validacions.validarCodiBarres(codiBarres);

            switch (tipus) {
                case ALIMENTACIO:
                    System.out.print("Data de caducitat (YYYY-MM-DD): ");
                    LocalDate dataCaducitat = LocalDate.parse(scanner.nextLine());
                    Validacions.validarDataCaducitat(dataCaducitat);
                    carret.afegirProducte(new Alimentacio(nom, preu, codiBarres, dataCaducitat));
                    break;
                case TEXTIL:
                    System.out.print("Composició tèxtil: ");
                    String composicio = scanner.nextLine();
                    Validacions.validarComposicio(composicio);
                    carret.afegirProducte(new Textil(nom, preu, codiBarres, composicio));
                    break;
                case ELECTRONICA:
                    System.out.print("Dies de garantia: ");
                    int garantia = scanner.nextInt();
                    scanner.nextLine();
                    Validacions.validarPreu(garantia); // Validación de garantía
                    carret.afegirProducte(new Electronica(nom, preu, codiBarres, garantia));
                    break;
                default:
                    System.out.println("Tipus de producte no vàlid.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: Tipus de producte no vàlid.");
        } catch (NegatiuException | DataCaducitatException | LimitCaracteresException | LimitProductesException |
                 EnumFailException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperat: " + e.getMessage());
        }
    }

    private void cercarProducte() {
        System.out.print("Introdueix el codi de barres: ");
        String codiBuscat = scanner.nextLine();
        Product trobat = carret.buscar(codiBuscat);
        if (trobat != null) {
            System.out.println("Producte trobat: " + trobat);
        } else {
            System.out.println("No s'ha trobat cap producte amb aquest codi.");
        }
    }
}