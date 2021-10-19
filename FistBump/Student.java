/**
 * @author Walker Menkus
 */

package FistBump;

import java.util.ArrayList;
import java.util.UUID;

public class Student extends Account {
    private double rating;
    private ArrayList<UUID> resumes; //TODO discuss with team how we will implement UUIDs
    private int ratingTotal;

    public Student(String name, String email, String password) {
        super.name = name;
        this.email = email;
        this.password = password; //TODO fields are not visible, do they need to be protected in Account?
    }

    public void calcRating(ArrayList<Rating> ratings) {
        //TODO average the ratings
    }

    public void createResume() { //Removed Student parameter that was listed on the UML
        //TODO construct a Resume, I'm not sure if the UI stuff will go here or somewhere else?
    }

    public void apply(Internship internship) {
        //TODO adds self to the list of Students on that internship
    }
}
