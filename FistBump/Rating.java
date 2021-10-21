package FistBump;

import java.util.UUID;

public class Rating {
    private double rating;
    private UUID raterID;
    private UUID ratedID;
    private boolean valid;

    public Rating(double rating, Account rater, Account rated) {
        
    }

    public double getRating() {
        return this.rating;
    }

    public boolean isValid() {
        return this.valid;
    }


}
