package FistBump;
import java.util.ArrayList;

public class Employer extends Account{
    private String business;
    private String bio;
    private ArrayList<Internship> internships;
    private ArrayList<Rating> ratings;

    /**
     * Parameterized constructor for Employer. Passes name, email,
     * and password to the constructor for Account. Initializes Internships,
     * rating, business, bio, and ratingTotal
     * @param name The name (or username?) of the emplloyer
     * @param email The employer's email
     * @param password The employer's password
     */
    public Employer(String name, String email, String password) {
        super(name, email, password);
        this.internships = new ArrayList<Internship>();
        this.ratings = new ArrayList<Rating>();  
        business = "";
        bio = "";
    }

    public void rate(Student student, double rating) {
        
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
        internship.setVisibility(false);
    }

    public void createInternship() {
        
    }
}
