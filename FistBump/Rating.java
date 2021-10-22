package FistBump;

import java.util.UUID;

public class Rating {
    private double rating;
    private Account rater;
    private Account rated;
    private boolean valid;

<<<<<<< HEAD
    public Rating() {
        id = "";
        rating = 0;
        raterID = 0;
        ratedID = 0;
        valid = true;
=======
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

    public void setValid(boolean valid){
        this.valid = valid;
>>>>>>> 86297744fb9e6bc8151e69693b409e963cc25f06
    }
    public Rating(String id, int rating, int raterID, int ratedID, boolean valid, Account rater, Account rated) {
        this.id = id;
        this.rating = rating;
        this.raterID = raterID;
        this.ratedID = ratedID;
        this.valid = valid;
        rater = new Account();
        rated = new Account();
    }
    public String getID() {
        return this.id;
    }
    public void setID(String id) {
        this.id = id;
    }
    public int getRating() {
        return this.rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    public int getRaterID() {
        return this.raterID;
    }
    public void setRaterID(int raterID) {
        this.raterID = raterID;
    }
    public int getRatedID() {
        return this.ratedID;
    }
    public void setRatedID(int ratedID) {
        this.ratedID = ratedID;
    }
    public boolean getValid() {
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
