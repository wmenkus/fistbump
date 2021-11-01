package FistBump;
import java.util.ArrayList;

public class InternshipManager {
    private ArrayList<Internship> internships;
    private static InternshipManager listManager;
    private InternshipSortBehavior internSortBehavior;

    private InternshipManager() {
        internships = new ArrayList<Internship>();
        listManager = new InternshipManager(); //TODO this may be wrong, does this create an infinite loop of creating InternshipManagers?
    }
    public static InternshipManager getInstance() {
        return null; //TODO This is definitely wrong
    }
    public void displayInternships() {

    }

    public ArrayList<Internship> getInternships() {
        return this.internships;
    }

    public void addInternship(Employer employer) {

    }
    public void sort() {

    }
    public Internship getInternship(Internship internship) {
        return null;
    }
    public void hideInternship(Internship internship) {
        
    }
}
