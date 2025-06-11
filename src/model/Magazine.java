package model;

public class Magazine extends Publication {
    public Magazine(String title, String editionDate, String editorial) {
        super(title, editionDate, editorial);
    }

    @Override
    public String toString() {
        return "Revista: " + getTitle() + " | Fecha: " + getEditionDate() + " | Editorial: " + getEditorial();
    }
}

