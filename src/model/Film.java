package model;

public class Film {
    private int id;
    private String title;
    private String genre;
    private String creator;
    private int duration;
    private int year;
    private boolean viewed;

    public Film(String title, String genre, String creator, int duration) {
        this.title = title;
        this.genre = genre;
        this.creator = creator;
        this.duration = duration;
        this.viewed = false;
    }

    // Getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public String getCreator() { return creator; }
    public void setCreator(String creator) { this.creator = creator; }

    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public boolean isViewed() { return viewed; }
    public void setViewed(boolean viewed) { this.viewed = viewed; }

    @Override
    public String toString() {
        return "Título: " + title + " | Género: " + genre + " | Director: " + creator + " | Duración: " + duration + " min";
    }
}
