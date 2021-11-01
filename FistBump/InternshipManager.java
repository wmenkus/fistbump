package FistBump;
import java.util.ArrayList;

public class InternshipManager {
    private ArrayList<Internship> internships;
    private static InternshipManager listManager;
    private InternshipSortBehavior internSortBehavior;

    private InternshipManager() {
        internships = new ArrayList<Internship>();
        listManager = new InternshipManager();
    }
    public static InternshipManager getInstance() {
        return null;
    }
    public void displayInternships() {

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
