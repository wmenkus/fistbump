/**
 * @author Walker Menkus
 */

package FistBump;

import java.util.ArrayList;
import java.util.UUID;

public class Student extends Account {
    private ArrayList<Rating> ratings;
    private ArrayList<Resume> resumes;
    private static final int permissions = 0;

    public Student(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.ratings = new ArrayList<Rating>();
        this.resumes = new ArrayList<Resume>();
    }

    public ArrayList<Rating> getRatings() {
        return ratings;
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

    public void addResume(Resume resume) { //Removed Student parameter that was listed on the UML
        
    }

    public void apply(Internship internship) {
        //TODO adds self to the list of Students on that internship
    }
}
