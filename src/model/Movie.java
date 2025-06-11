package model;

public class Movie extends Film {
    private int timeViewed;

    public Movie(String title, String genre, String creator, int duration, int year) {
        super(title, genre, creator, duration);
        this.setYear(year);
        this.timeViewed = 0;
    }

    public int getTimeViewed() {
        return timeViewed;
    }

    public void setTimeViewed(int timeViewed) {
        this.timeViewed = timeViewed;
    }

    @Override
    public String toString() {
        return "Película: " + getTitle() + " | Año: " + getYear() + " | Tiempo visto: " + timeViewed + " min";
    }
}
