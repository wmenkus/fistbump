package FistBump;

import java.util.UUID;

public class Rating {
    private double rating;
    private Account rater;
    private Account rated;
    private boolean valid;

    public Rating(double rating, Account rater, Account rated) {
        this.rater = rater;
        this.rated = rated;
        this.rating = rating;
    }

    public double getRating() {
        return this.rating;
    }

    public boolean isValid() {
        return this.valid;
    }

    public void hide(){
        valid = false;
    }

    public void reveal(){
        valid = true;
    }
}
