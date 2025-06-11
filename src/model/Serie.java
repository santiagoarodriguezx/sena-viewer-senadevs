package model;

public class Serie extends Film {
    private int timeViewed;
    private int sessionQuantity;

    public Serie(String title, String genre, String creator, int duration, int year, int sessionQuantity) {
        super(title, genre, creator, duration);
        this.setYear(year);
        this.sessionQuantity = sessionQuantity;
        this.timeViewed = 0;
    }

    public int getTimeViewed() { return timeViewed; }
    public void setTimeViewed(int timeViewed) { this.timeViewed = timeViewed; }

    public int getSessionQuantity() { return sessionQuantity; }
    public void setSessionQuantity(int sessionQuantity) { this.sessionQuantity = sessionQuantity; }

    @Override
    public String toString() {
        return "Serie: " + getTitle() + " | Sesiones: " + sessionQuantity + " | Tiempo visto: " + timeViewed + " min";
    }
}
