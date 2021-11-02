/**
 * @author Walker Menkus
 */

package FistBump;

import java.util.ArrayList;
import java.util.UUID;

public class Student extends Account {
    private ArrayList<Resume> resumes;
    private ArrayList<Rating> ratings;
    private String phoneNumber;

    /**
     * Parameterized constructor for Student. Passes name, email,
     * and password to the constructor for Account, and constructs two
     * empty ArrayLists to store the Student's resumes and ratings.
     * @param name The name (or username?) of the Student
     * @param email The student's email
     * @param password The student's password
     */
    public Student(String name, String email, String password, String phoneNumber) {
        super(name, email, password);
        this.phoneNumber = phoneNumber;
        this.resumes = new ArrayList<Resume>();
        this.ratings = new ArrayList<Rating>();
    }

    public Student(UUID id, String name, String email, String password, ArrayList<Resume> resumes, ArrayList<Rating> ratings, String phoneNumber) {
        super(id, name, email, password);
        this.phoneNumber = phoneNumber;
        this.resumes = resumes;
        this.ratings = ratings;
    }

    public Student(UUID id, String name, String email, String password, ArrayList<Resume> resumes, String phoneNumber) {
        super(id, name, email, password);
        this.phoneNumber = phoneNumber;
        this.resumes = resumes;
    }
    
    /**
     * Accessor for the Student's ratings. Returns all ratings,
     * even those that are hidden.
     * @return The list of all ratings
     */
    public ArrayList<Rating> getRatings() {
        return ratings;
    }

    /**
     * Adds a rating to the ratings away
     */
    public void addRating(Rating rating) {
        ratings.add(rating);
    }

    /**
     * Calculates and returns the student's mean average rating, only taking into
     * account the VISIBLE ratings. This value is never stored; this prevents
     * potential desynchronization at the cost of the program calculating the
     * rating any time it will be used. The rating is easily calculable,
     * so the cost is negligible.
     * @return
     */
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

    /**
     * Adds a resume to the Student's list of resumes. Since
     * resumes are stored within the Student's JSON file, resumes
     * will not be saved until they are added to a Student's resume list.
     * @param resume The resume to be added/saved
     */
    public void addResume(Resume resume) {
        resumes.add(resume);
    }

    public ArrayList<Resume> getResumes() {
        return this.resumes;
    }

    /**
     * The permission value for Student is 0.
     */
    public int getPermissions() {
        return 0;
    }

    /**
     * Not entirely sure how this method will end up being used, the Facade
     * could potentially add students directly without having to call an apply method
     * from the Student class.
     * @param internship The internship the student is applying to
     */
    public void apply(Internship internship) {
        internship.addStudent(this);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public double getGpa() {
        if(resumes != null) {
            return resumes.get(resumes.size() - 1).getGpa();
        }
        else {
            return 0;
        }
    }

    public String toString() {
        return name + "\n" +
        getGpa() + "\n" +
        calcRating();
    }

    public String details() {
        String details = "Name: " + name + "\nEmail: " + email + "\nPhone Number: " + phoneNumber;
        for(Resume resume : resumes) {
            details += resume.toString();
        }
        return details;
    }
}
