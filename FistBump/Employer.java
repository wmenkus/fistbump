package FistBump;

import java.util.ArrayList;
import java.util.UUID;

public class Employer extends Account{
    private String bio;
    private ArrayList<Internship> internships;
    private ArrayList<Rating> ratings;
    private ArrayList<String> internshipIds;

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
        setBio("");
        this.internshipIds = new ArrayList<String>();
    }
    
    public Employer(UUID id, String name, String email, String password, String bio, ArrayList<String> internshipIds,
            ArrayList<Rating> ratings) {
        super(id, name, email, password);
        this.internships = new ArrayList<Internship>();
        this.internshipIds = internshipIds;
        for (String internshipId : internshipIds) {
            System.out.println("Employer: "+internshipId);
        }
        this.ratings = ratings;
        this.bio = bio;
    }
    
    public Employer(UUID id, String name, String email, String password, String bio, ArrayList<String> internshipIds) {
        super(id, name, email, password);
        this.internships = new ArrayList<Internship>();
        this.internshipIds = internshipIds;
        this.bio = bio;
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

    public void rate(Student student, Rating rating) {
        student.addRating(rating);
    }

    public void addRating(Rating rating) {
        ratings.add(rating);
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

    public void addInternship(Internship internship) {
        internships.add(internship);
    }

    public ArrayList<String> getInternshipIds(){
        return internshipIds;
    }
}
