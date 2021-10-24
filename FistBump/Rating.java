package FistBump;

import java.util.UUID;

public class Rating {
    private double rating;
    private Account rater;
    private Account rated;
    private boolean valid;

    public Rating(double rating, Account rater, Account rated, boolean valid) {
        this.rating = rating;
        this.rater = rater;
        this.rated = rated;
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
    public Account getRated() {
        return this.rated;
    }
    public void setRated(Account rated) {
        this.rated = rated;
    }
    public boolean isValid() {
        return this.valid;
    }
    public void setValid(boolean valid) {
        this.valid = valid;
    }
    /**
     * Last Updated: October 22, 2021
     * By: Cameron Delk
     */
}
