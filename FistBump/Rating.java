package FistBump;

public class Rating {
    private String id;
    private int rating;
    private int raterID;
    private int ratedID;
    private boolean valid;

    public Rating() {
        id = "";
        rating = 0;
        raterID = 0;
        ratedID = 0;
        valid = true;
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
