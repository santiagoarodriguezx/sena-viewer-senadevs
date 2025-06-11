package models;
public class Magazine {
    private int id;
    private String title;
    private String edititionDate;
    private String editorial;
    private String authors;

    // Constructor
    public Magazine(String title, String edititionDate, String editorial) {
        this.title = title;
        this.edititionDate = edititionDate;
        this.editorial = editorial;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getEdititionDate() {
        return edititionDate;
    }

    public String getEditorial() {
        return editorial;
    }

    public String getAuthors() {
        return authors;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setEdititionDate(String edititionDate) {
        this.edititionDate = edititionDate;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }
}