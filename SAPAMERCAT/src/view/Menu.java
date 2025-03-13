package view;

import model.*;
import utils.Validacions;
import exceptions.*;

import java.util.Scanner;
import java.time.LocalDate;
import java.util.NoSuchElementException;

/**
 * Classe principal de la interfície d'usuari del sistema SAPAMERCAT.
 * Aquesta classe gestiona la interacció amb l'usuari mitjançant un menú de
 * consola que permet:
 * - Afegir productes de diferents tipus (alimentació, tèxtil, electrònica).
 * - Mostrar el contingut del carret de compra.
 * - Generar tiquets de compra.
 * - Cercar productes per codi de barres.
 * Proporciona validació de totes les entrades d'usuari i gestió d'errors amb
 * missatges descriptius.
 * 
 * @author Joan Miralles Carmona
 */
public class Menu {
    private Scanner scanner;
    private CarretCompra carret;

    /**
     * Construeix un nou menú del sistema SAPAMERCAT.
     * Inicialitza l'escàner per a l'entrada d'usuari i crea un carret de compra
     * buit.
     */
    public Menu() {
        scanner = new Scanner(System.in);
        carret = new CarretCompra();
    }

    /**
     * Inicia el menú principal del sistema.
     * Mostra les opcions disponibles i gestiona la interacció de l'usuari en un
     * bucle continu fins que l'usuari decideixi sortir.
     */
    public void iniciar() {
        int opcio;
        do {
            mostrarOpcions();
            opcio = llegirEnter();
            gestionarOpcio(opcio);
        } while (opcio != 0);
    }

    /**
     * Mostra les opcions disponibles del menú principal.
     * Inclou una capçalera de benvinguda i les diferents accions que pot
     * seleccionar l'usuari.
     */
    private void mostrarOpcions() {
        // Welcome message now appears every time the menu is displayed
        System.out.println("*************************************************");
        System.out.println("*             BENVINGUT A SAPAMERCAT            *");
        System.out.println("*************************************************");

        System.out.println("\n--- MENÚ PRINCIPAL ---");
        System.out.println("1. Afegir producte");
        System.out.println("2. Mostrar carret");
        System.out.println("3. Passar per caixa");
        System.out.println("4. Cercar producte per codi de barres");
        System.out.println("0. Sortir");
        System.out.print("Opció: ");
    }

    /**
     * Llegeix un número enter des de l'entrada estàndard.
     * Valida que l'entrada no estigui buida i sigui numèrica.
     * 
     * @return El número enter introduït per l'usuari, o -1 si l'entrada no és
     *         vàlida.
     */
    private int llegirEnter() {
        try {
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Error: No has introduït cap valor. Si us plau, introdueix una opció vàlida.");
                return -1;
            }

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Error: Has d'introduir un número.");
                return -1;
            }
        } catch (NoSuchElementException | IllegalStateException e) {
            System.out.println("\nPrograma finalitzat. Gràcies per utilitzar SAPAMERCAT.");
            System.exit(0);
            return 0;
        }
    }

    /**
     * Gestiona l'opció seleccionada per l'usuari en el menú principal.
     * Dirigeix el flux del programa segons l'opció seleccionada.
     * 
     * @param opcio El número d'opció seleccionada per l'usuari.
     */
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
                System.out.println();
        }
    }

    /**
     * Gestiona l'addició de nous productes al carret de compra.
     * Permet seleccionar el tipus de producte (alimentació, tèxtil, electrònica) i
     * introduir les dades específiques de cada tipus, amb validacions per a cada
     * camp.
     */
    private void afegirProducte() {
        boolean continuar = true;

        while (continuar) {
            try {
                System.out.println("\n--- AFEGIR PRODUCTE ---");

                TipusProducte tipus = null;
                int tipusOpcio = -1;

                do {
                    try {
                        System.out.println("Selecciona el tipus de producte:");
                        System.out.println("1. Alimentació");
                        System.out.println("2. Tèxtil");
                        System.out.println("3. Electrònica");
                        System.out.println("0. Tornar al menú principal");
                        System.out.print("Opció: ");

                        String input = scanner.nextLine().trim();

                        if (input.isEmpty()) {
                            System.out.println("Error: No has introduït cap valor.");
                            System.out.println();
                            continue;
                        }

                        try {
                            tipusOpcio = Integer.parseInt(input);

                            switch (tipusOpcio) {
                                case 1:
                                    tipus = TipusProducte.ALIMENTACIO;
                                    break;
                                case 2:
                                    tipus = TipusProducte.TEXTIL;
                                    break;
                                case 3:
                                    tipus = TipusProducte.ELECTRONICA;
                                    break;
                                case 0:
                                    System.out.println();
                                    return;
                                default:
                                    System.out.println("Error: Opció no vàlida.");
                                    System.out.println();
                                    break;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Error: Has d'introduir un número.");
                            System.out.println();
                        }
                    } catch (NoSuchElementException | IllegalStateException e) {
                        System.out.println("\nPrograma finalitzat. Gràcies per utilitzar SAPAMERCAT.");
                        System.exit(0);
                    }
                } while (tipus == null);

                try {
                    String nom = "";
                    boolean nomValid = false;
                    while (!nomValid) {
                        System.out.print("Nom: ");
                        nom = scanner.nextLine().trim();

                        if (nom.equalsIgnoreCase("sortir")) {
                            return;
                        }

                        if (nom.isEmpty()) {
                            System.out.println("Error: El nom no pot estar buit.");
                            continue;
                        }

                        try {
                            Validacions.validarNom(nom);
                            nomValid = true;
                        } catch (LimitCaracteresException e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    try {
                        Validacions.validarPreu(nom.length());
                    } catch (NegatiuException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }

                    double preu = 0;
                    boolean preuValid = false;
                    while (!preuValid) {
                        System.out.print("Preu: ");
                        String preuInput = scanner.nextLine().trim();

                        if (preuInput.equalsIgnoreCase("sortir")) {
                            return;
                        }

                        if (preuInput.isEmpty()) {
                            System.out.println("Error: El preu no pot estar buit.");
                            continue;
                        }

                        try {
                            preu = Double.parseDouble(preuInput);
                            Validacions.validarPreu(preu);
                            preuValid = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Error: El preu ha de ser un valor numèric.");
                        } catch (NegatiuException e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    String codiBarres = "";
                    boolean codiValid = false;
                    while (!codiValid) {
                        System.out.print("Codi de barres: ");
                        codiBarres = scanner.nextLine().trim();

                        if (codiBarres.equalsIgnoreCase("sortir")) {
                            return;
                        }

                        if (codiBarres.isEmpty()) {
                            System.out.println("Error: El codi de barres no pot estar buit.");
                            continue;
                        }

                        try {
                            Validacions.validarCodiBarres(codiBarres);
                            codiValid = true;
                        } catch (LimitCaracteresException e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    switch (tipus) {
                        case ALIMENTACIO:
                            boolean dataValid = false;
                            while (!dataValid) {
                                System.out.print("Data de caducitat (DD/MM/YYYY): ");
                                String dataInput = scanner.nextLine().trim();

                                if (dataInput.equalsIgnoreCase("sortir")) {
                                    return;
                                }

                                if (dataInput.isEmpty()) {
                                    System.out.println("Error: La data de caducitat no pot estar buida.");
                                    continue;
                                }

                                try {
                                    LocalDate dataCaducitat;
                                    if (dataInput.contains("/")) {
                                        String[] parts = dataInput.split("/");
                                        if (parts.length == 3) {
                                            int dia = Integer.parseInt(parts[0]);
                                            int mes = Integer.parseInt(parts[1]);
                                            int any = Integer.parseInt(parts[2]);
                                            dataCaducitat = LocalDate.of(any, mes, dia);
                                        } else {
                                            throw new java.time.format.DateTimeParseException("Format incorrecte",
                                                    dataInput, 0);
                                        }
                                    } else {
                                        dataCaducitat = LocalDate.parse(dataInput);
                                    }

                                    Validacions.validarDataCaducitat(dataCaducitat);
                                    carret.afegirProducte(new Alimentacio(nom, preu, codiBarres, dataCaducitat));
                                    dataValid = true;
                                    continuar = false;
                                    System.out.println();
                                } catch (java.time.format.DateTimeParseException | NumberFormatException e) {
                                    System.out.println("Error: Format de data incorrecte. Usa DD/MM/YYYY.");
                                } catch (DataCaducitatException e) {
                                    System.out.println(e.getMessage());
                                } catch (Exception e) {
                                    System.out.println("Error: " + e.getMessage());
                                }
                            }
                            break;
                        case TEXTIL:
                            boolean composicioValid = false;
                            String composicio = "";

                            do {
                                try {
                                    System.out.println("\nSelecciona la composició tèxtil:");
                                    System.out.println("1. Cotó");
                                    System.out.println("2. Llana");
                                    System.out.println("3. Seda");
                                    System.out.println("0. Tornar al menú principal");
                                    System.out.print("Opció: ");

                                    String composicioInput = scanner.nextLine().trim();

                                    if (composicioInput.isEmpty()) {
                                        System.out.println("Error: No has introduït cap valor.");
                                        continue;
                                    }

                                    try {
                                        int composicioOpcio = Integer.parseInt(composicioInput);

                                        switch (composicioOpcio) {
                                            case 1:
                                                composicio = "cotó";
                                                composicioValid = true;
                                                break;
                                            case 2:
                                                composicio = "llana";
                                                composicioValid = true;
                                                break;
                                            case 3:
                                                composicio = "seda";
                                                composicioValid = true;
                                                break;
                                            case 0:
                                                return;
                                            default:
                                                System.out.println("Error: Opció no vàlida.");
                                                System.out.println();
                                                break;
                                        }
                                        System.out.println();

                                        if (composicioValid) {
                                            carret.afegirProducte(new Textil(nom, preu, codiBarres, composicio));
                                            continuar = false;
                                            System.out.println();
                                        }
                                    } catch (NumberFormatException e) {
                                        System.out.println("Error: Has d'introduir un número.");
                                    } catch (LimitCaracteresException | LimitProductesException e) {
                                        System.out.println(e.getMessage());
                                    } catch (Exception e) {
                                        System.out.println("Error: " + e.getMessage());
                                    }
                                } catch (NoSuchElementException | IllegalStateException e) {
                                    System.out.println("\nPrograma finalitzat. Gràcies per utilitzar SAPAMERCAT.");
                                    System.exit(0);
                                }
                            } while (!composicioValid);
                            break;
                        case ELECTRONICA:
                            boolean garantiaValid = false;
                            while (!garantiaValid) {
                                System.out.print("Dies de garantia: ");
                                String garantiaInput = scanner.nextLine().trim();
                                System.out.println();

                                if (garantiaInput.equalsIgnoreCase("sortir")) {
                                    return;
                                }

                                if (garantiaInput.isEmpty()) {
                                    System.out.println("Error: Els dies de garantia no poden estar buits.");
                                    continue;
                                }

                                try {
                                    int garantia = Integer.parseInt(garantiaInput);
                                    Validacions.validarPreu(garantia);
                                    carret.afegirProducte(new Electronica(nom, preu, codiBarres, garantia));
                                    garantiaValid = true;
                                    continuar = false;
                                    System.out.println();
                                } catch (NumberFormatException e) {
                                    System.out.println("Error: Els dies de garantia han de ser un valor numèric.");
                                } catch (NegatiuException e) {
                                    System.out.println(e.getMessage());
                                } catch (Exception e) {
                                    System.out.println("Error: " + e.getMessage());
                                }
                            }
                            break;
                    }
                } catch (NoSuchElementException | IllegalStateException e) {
                    System.out.println("\nPrograma finalitzat. Gràcies per utilitzar SAPAMERCAT.");
                    System.exit(0);
                }

            } catch (NoSuchElementException | IllegalStateException e) {
                System.out.println("\nPrograma finalitzat. Gràcies per utilitzar SAPAMERCAT.");
                System.exit(0);
            } catch (Exception e) {
                System.out.println("Error inesperat: " + e.getMessage());
            }
        }
    }

    /**
     * Gestiona el submenú de cerca de productes.
     * Permet a l'usuari cercar productes per codi de barres i mostrar els seus
     * detalls.
     */
    private void cercarProducte() {
        boolean continuar = true;

        while (continuar) {
            try {
                System.out.println("\n--- CERCAR PRODUCTE ---");
                System.out.println("1. Buscar per codi de barres");
                System.out.println("0. Tornar al menú principal");
                System.out.print("Opció: ");

                String input = scanner.nextLine().trim();

                if (input.isEmpty()) {
                    System.out.println("Error: No has introduït cap valor.");
                    continue;
                }

                try {
                    int opcio = Integer.parseInt(input);

                    switch (opcio) {
                        case 0:
                            System.out.println();
                            return;

                        case 1:

                            boolean cercaValid = false;
                            while (!cercaValid) {
                                System.out.print("Introdueix el codi de barres: ");
                                String codiBarres = scanner.nextLine().trim();

                                if (codiBarres.equalsIgnoreCase("sortir")) {
                                    break;
                                }

                                if (codiBarres.isEmpty()) {
                                    System.out.println("Error: El codi de barres no pot estar buit.");
                                    continue;
                                }

                                try {
                                    Validacions.validarCodiBarres(codiBarres);

                                    Product trobat = carret.buscar(codiBarres);
                                    if (trobat != null) {
                                        System.out.println("Producte trobat: " + trobat);
                                    } else {
                                        System.out.println("No s'ha trobat cap producte amb aquest codi.");
                                    }

                                    System.out.print("Vols cercar un altre producte? (s/n): ");
                                    String resposta = scanner.nextLine().trim().toLowerCase();
                                    if (!resposta.equals("s") && !resposta.equals("si")) {
                                        cercaValid = true;
                                    }
                                } catch (LimitCaracteresException e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                            break;

                        default:
                            System.out.println("Error: Opció no vàlida.");
                            System.out.println();
                            break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error: Has d'introduir un número.");
                    System.out.println();
                }
            } catch (NoSuchElementException | IllegalStateException e) {
                System.out.println("\nPrograma finalitzat. Gràcies per utilitzar SAPAMERCAT.");
                System.exit(0);
            }
        }
    }
}