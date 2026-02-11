package es.iesquevedo.app;

import es.iesquevedo.dao.JsonSocioDao;
import es.iesquevedo.dao.JsonSocioDaoImpl;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Inyección de dependencias simple a mano
        String base = System.getProperty("user.dir");
        JsonSocioDao socioDao = new JsonSocioDaoImpl(base + "/socios.json");
        ConsoleApp app = new ConsoleApp(socioDao);

        try (Scanner scanner = new Scanner(System.in)) {
            boolean running = true;
            while (running) {
                printMenu();
                System.out.print("Elige una opción: ");
                String opt = scanner.nextLine().trim();
                switch (opt) {
                    case "1" -> app.crearSocio(scanner);
                    case "2" -> app.eliminarSocio(scanner);
                    case "3" -> app.listarSocios();
                    case "0" -> {
                        running = false;
                        System.out.println("Saliendo...");
                    }
                    default -> System.out.println("Opción no válida");
                }
                System.out.println();
            }
        }
    }

    private static void printMenu() {
        System.out.println("--- Videoclub ---");
        System.out.println("1) Añadir Socio");
        System.out.println("2) Eliminar Socio");
        System.out.println("3) Listar Socios");
        System.out.println("0) Salir");
    }
}
