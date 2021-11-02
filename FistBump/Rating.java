/**
 * A rating.
 * @author: Cameron Delk
 */
package FistBump;

public class Rating {
    private double rating;
    private Account rater;
    private boolean valid;

    /**
     * A parameterized constructor for Rating.
     */
    public Rating(double rating, Account rater) {
        this.rating = rating;
        this.rater = rater;
    }

    /**
     * Another parameterized constructor for Rating.
     */
    public Rating(double rating, Account rater, boolean valid) {
        this.rating = rating;
        this.rater = rater;
        this.valid = valid;
    }

    /**
     * The accessor for rating.
     */
    public double getRating() {
        return this.rating;
    }

    /**
     * The accessor for rater.
     */
    public Account getRater() {
        return this.rater;
    }

    /**
     * The mutator for rater.
     */
    public void setRater(Account rater) {
        this.rater = rater;
    }

    /**
     * The accessor for valid.
     */
    public boolean isValid() {
        return this.valid;
    }

    /**
     * The mutator for valid.
     */
    public void setValid(boolean valid) {
        this.valid = valid;
    }
}
