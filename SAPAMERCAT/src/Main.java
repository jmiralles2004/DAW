import view.Menu;

/**
 * Classe principal que inicia l'aplicació SAPAMERCAT.
 * Aquesta classe conté el punt d'entrada principal de l'aplicació i s'encarrega de:
 * - Crear una instància del menú principal.
 * - Iniciar la interacció amb l'usuari.
 * El seu funcionament és senzill però fonamental, ja que connecta tots els components del sistema i permet que l'aplicació comenci a funcionar.
 * 
 * @author Joan Miralles Carmona
 */
public class Main {
    
    /**
     * Mètode principal que inicia l'aplicació SAPAMERCAT.
     * Crea una instància de la classe Menu i crida al seu mètode iniciar() per començar la interacció amb l'usuari.
     *
     * @param args Arguments de la línia de comandes (no s'utilitzen).
     */
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.iniciar();
    }
}