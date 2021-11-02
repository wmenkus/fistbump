package FistBump;

import java.util.UUID;

public class Rating {
    private double rating;
    private Account rater;
    private boolean valid;

    public Rating(double rating, Account rater) {
        this.rating = rating;
        this.rater = rater;
    }

    public Rating(double rating, Account rater, boolean valid) {
        this.rating = rating;
        this.rater = rater;
        this.valid = valid;
    }

    public double getRating() {
        return this.rating;
    }

    public Account getRater() {
        return this.rater;
    }

    public void setRater(Account rater) {
        this.rater = rater;
    }

    public boolean isValid() {
        return this.valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
}
