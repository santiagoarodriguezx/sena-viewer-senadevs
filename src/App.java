import java.util.Scanner;

public class App {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        boolean running = true;
        while (running) {
            displayMainMenu();
            int choice = getUserChoice();
            running = processMainMenuChoice(choice);
        }
        scanner.close();
    }

    private static void displayMainMenu() {
        System.out.println("\n=== SENA Viewer - Menú Principal ===");
        System.out.println("1. Ver Películas");
        System.out.println("2. Ver Series");
        System.out.println("3. Ver Libros");
        System.out.println("4. Ver Revistas");
        System.out.println("5. Generar Reportes");
        System.out.println("0. Salir");
        System.out.print("\nSeleccione una opción: ");
    }

    private static int getUserChoice() {
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, ingrese un número válido.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static boolean processMainMenuChoice(int choice) {
        switch (choice) {
            case 1:
                System.out.println("\nMostrando lista de películas...");
                return true;
            case 2:
                System.out.println("\nMostrando lista de series...");
                return true;
            case 3:
                System.out.println("\nMostrando lista de libros...");
                return true;
            case 4:
                System.out.println("\nMostrando lista de revistas...");
                return true;
            case 5:
                System.out.println("\nGenerando reportes...");
                return true;
            case 0:
                System.out.println("\n¡Gracias por usar SENA Viewer!");
                return false;
            default:
                System.out.println("\nOpción no válida. Por favor, intente nuevamente.");
                return true;
        }
    }
}
