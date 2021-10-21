/**
 * @author Walker Menkus
 */

package FistBump;

import java.util.ArrayList;

public class Student extends Account {
    private ArrayList<Rating> ratings;
    private ArrayList<Resume> resumes;

    public Student(String name, String email, String password) {
        super(name, email, password);
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

    public void addResume(Resume resume) {
        resumes.add(resume);
    }

    public int getPermissions() {
        return 0;
    }

    public void apply(Internship internship) {
        internship.addStudent(this);
    }
}
