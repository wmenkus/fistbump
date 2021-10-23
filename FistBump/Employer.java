package FistBump;

import java.util.ArrayList;

public class Employer extends Account{
    private String company;
    private String bio;
    private ArrayList<Internship> internships;
    private ArrayList<Rating> ratings;

    /**
     * Parameterized constructor for Employer. Passes name, email,
     * and password to the constructor for Account. Initializes Internships,
     * rating, business, bio, and ratingTotal
     * @param name The name (or username?) of the employer
     * @param email The employer's email
     * @param password The employer's password
     */
    public Employer(String name, String email, String password) {
        super(name, email, password);
        this.setInternships(new ArrayList<Internship>());
        this.ratings = new ArrayList<Rating>();  
        setCompany("");
        setBio("");
    }

    public ArrayList<Internship> getInternships() {
        return internships;
    }

    public void setInternships(ArrayList<Internship> internships) {
        this.internships = internships;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void rate(Student student, Rating rating) {
        student.addRating(rating);
    }

    public double calcRating() {
        double result = 0;
        int total = 0;

        for(Rating rating : ratings) {
            if(rating.isValid()) {
                result += rating.getRating();
                total++;
            }
        }
        result /= total;
        return result;
    }

    public void hideInternship(Internship internship) {
        if(internship.getPoster() == this)
            internship.setVisibility(false);
    }

    /**
     * The permission value for Employer is 1.
     */
    public int getPermissions() {
        return 1;
    }

    public ArrayList<Rating> getRatings() {
        return ratings;
    }
}
