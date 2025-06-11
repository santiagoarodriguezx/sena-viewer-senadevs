import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import model.*;

public class App {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<String, LocalDateTime> viewingHistory = new HashMap<>();
    private static final List<Movie> movies = new ArrayList<>();
    private static final List<Serie> series = new ArrayList<>();
    private static final List<Book> books = new ArrayList<>();
    private static final List<Magazine> magazines = new ArrayList<>();

    private static void initializeSampleData() {
        // Inicializar películas
        movies.add(new Movie("El Padrino", "Drama", "Francis Ford Coppola", 175, 1972));
        movies.add(new Movie("Matrix", "Ciencia Ficción", "Hermanas Wachowski", 136, 1999));

        // Inicializar series
        series.add(new Serie("Breaking Bad", "Drama", "Vince Gilligan", 45, 2008, 62));
        series.add(new Serie("Stranger Things", "Ciencia Ficción", "Hermanos Duffer", 50, 2016, 34));

        // Inicializar libros
        books.add(new Book("Cien años de soledad", "1967", "Sudamericana", "Gabriel García Márquez"));
        books.add(new Book("1984", "1949", "Secker and Warburg", "George Orwell"));

        // Inicializar revistas
        magazines.add(new Magazine("National Geographic", "2023", "National Geographic Society"));
        magazines.add(new Magazine("Time", "2023", "Time USA, LLC"));
    }

    public static void main(String[] args) throws Exception {
        initializeSampleData(); // Inicializamos datos de ejemplo
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
    }    private static boolean processMainMenuChoice(int choice) {
        return switch (choice) {
            case 1 -> {
                showMovies();
                yield true;
            }
            case 2 -> {
                showSeries();
                yield true;
            }
            case 3 -> {
                showBooks();
                yield true;
            }
            case 4 -> {
                showMagazines();
                yield true;
            }
            case 5 -> {
                generateReports();
                yield true;
            }
            case 0 -> {
                System.out.println("\n¡Gracias por usar SENA Viewer!");
                yield false;
            }
            default -> {
                System.out.println("\nOpción no válida. Por favor, intente nuevamente.");
                yield true;
            }
        };
    }    private static void showMovies() {
        System.out.println("\n=== Películas Disponibles ===");
        for (int i = 0; i < movies.size(); i++) {
            System.out.println((i + 1) + ". " + movies.get(i));
        }
        System.out.print("\nSeleccione una película (0 para volver): ");
        int choice = getUserChoice();
        if (choice > 0 && choice <= movies.size()) {
            Movie selectedMovie = movies.get(choice - 1);
            markAsViewed(selectedMovie.getTitle());
            selectedMovie.setViewed(true);
            int timeToView = Math.min(30, selectedMovie.getDuration()); // Simular ver 30 minutos o la duración total si es menor
            selectedMovie.setTimeViewed(selectedMovie.getTimeViewed() + timeToView);
            System.out.println("\nViendo: " + selectedMovie.getTitle() + " durante " + timeToView + " minutos");
        }
    }    private static void showSeries() {
        System.out.println("\n=== Series Disponibles ===");
        for (int i = 0; i < series.size(); i++) {
            System.out.println((i + 1) + ". " + series.get(i));
        }
        System.out.print("\nSeleccione una serie (0 para volver): ");
        int choice = getUserChoice();
        if (choice > 0 && choice <= series.size()) {
            Serie selectedSerie = series.get(choice - 1);
            markAsViewed(selectedSerie.getTitle());
            selectedSerie.setViewed(true);
            int episodeTime = selectedSerie.getDuration();
            selectedSerie.setTimeViewed(selectedSerie.getTimeViewed() + episodeTime);
            System.out.println("\nViendo un episodio de: " + selectedSerie.getTitle() + 
                " (Duración: " + episodeTime + " minutos)");
        }
    }

    private static void showBooks() {
        System.out.println("\n=== Libros Disponibles ===");
        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ". " + books.get(i));
        }
        System.out.print("\nSeleccione un libro (0 para volver): ");
        int choice = getUserChoice();
        if (choice > 0 && choice <= books.size()) {
            Book selectedBook = books.get(choice - 1);
            markAsViewed(selectedBook.getTitle());
            System.out.println("\nLeyendo: " + selectedBook.getTitle());
        }
    }

    private static void showMagazines() {
        System.out.println("\n=== Revistas Disponibles ===");
        for (int i = 0; i < magazines.size(); i++) {
            System.out.println((i + 1) + ". " + magazines.get(i));
        }
        System.out.print("\nSeleccione una revista (0 para volver): ");
        int choice = getUserChoice();
        if (choice > 0 && choice <= magazines.size()) {
            Magazine selectedMagazine = magazines.get(choice - 1);
            markAsViewed(selectedMagazine.getTitle());
            System.out.println("\nLeyendo: " + selectedMagazine.getTitle());
        }
    }

    private static void generateReports() {
        boolean inReports = true;
        while (inReports) {
            System.out.println("\n=== Menú de Reportes ===");
            System.out.println("1. Ver historial completo");
            System.out.println("2. Ver películas vistas");
            System.out.println("3. Ver series vistas");
            System.out.println("4. Ver libros leídos");
            System.out.println("5. Ver revistas leídas");
            System.out.println("0. Volver al menú principal");
            System.out.print("\nSeleccione una opción: ");
            
            int choice = getUserChoice();
            switch (choice) {
                case 1 -> showFullHistory();
                case 2 -> showMoviesHistory();
                case 3 -> showSeriesHistory();
                case 4 -> showBooksHistory();
                case 5 -> showMagazinesHistory();
                case 0 -> inReports = false;
                default -> System.out.println("\nOpción no válida. Por favor, intente nuevamente.");
            }
        }
    }

    private static void showFullHistory() {
        System.out.println("\n=== Historial Completo de Visualización ===");
        if (viewingHistory.isEmpty()) {
            System.out.println("No hay contenido visto aún.");
            return;
        }
        viewingHistory.forEach((title, dateTime) -> {
            System.out.println("- " + title + " (Visto el: " + 
                dateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) + ")");
        });
    }

    private static void showMoviesHistory() {
        System.out.println("\n=== Películas Vistas ===");
        boolean found = false;
        for (Movie movie : movies) {
            if (viewingHistory.containsKey(movie.getTitle())) {
                System.out.println("- " + movie.getTitle() + 
                    " (Última vez: " + viewingHistory.get(movie.getTitle())
                        .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) + ")");
                found = true;
            }
        }
        if (!found) System.out.println("No has visto ninguna película aún.");
    }

    private static void showSeriesHistory() {
        System.out.println("\n=== Series Vistas ===");
        boolean found = false;
        for (Serie serie : series) {
            if (viewingHistory.containsKey(serie.getTitle())) {
                System.out.println("- " + serie.getTitle() + 
                    " (Última vez: " + viewingHistory.get(serie.getTitle())
                        .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) + ")");
                found = true;
            }
        }
        if (!found) System.out.println("No has visto ninguna serie aún.");
    }

    private static void showBooksHistory() {
        System.out.println("\n=== Libros Leídos ===");
        boolean found = false;
        for (Book book : books) {
            if (viewingHistory.containsKey(book.getTitle())) {
                System.out.println("- " + book.getTitle() + 
                    " (Última vez: " + viewingHistory.get(book.getTitle())
                        .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) + ")");
                found = true;
            }
        }
        if (!found) System.out.println("No has leído ningún libro aún.");
    }

    private static void showMagazinesHistory() {
        System.out.println("\n=== Revistas Leídas ===");
        boolean found = false;
        for (Magazine magazine : magazines) {
            if (viewingHistory.containsKey(magazine.getTitle())) {
                System.out.println("- " + magazine.getTitle() + 
                    " (Última vez: " + viewingHistory.get(magazine.getTitle())
                        .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) + ")");
                found = true;
            }
        }
        if (!found) System.out.println("No has leído ninguna revista aún.");
    }

    private static void markAsViewed(String title) {
        viewingHistory.put(title, LocalDateTime.now());
    }
}
