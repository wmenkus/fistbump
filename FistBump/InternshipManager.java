package FistBump;
import java.util.ArrayList;

public class InternshipManager {
    private ArrayList<Internship> internships;
    private static InternshipManager listManager;
    private InternshipSortBehavior internSortBehavior;

    private InternshipManager() {
        internships = new ArrayList<Internship>();
        internSortBehavior = new PaySort();
    }

    public static InternshipManager getInstance() {
        if (listManager == null) {
            listManager = new InternshipManager();
        }
        return listManager;
    }

    public ArrayList<Internship> getInternships() {
        return this.internships;
    }

    public void addInternship(Employer employer, Internship internship) {
        employer.addInternship(internship);
    }

    public void sort() {
        internSortBehavior.sort(internships);
    }

    public Internship getInternship(Internship internship) {
        return internship;
    }

    public void hideInternship(Employer employer, Internship internship) {
        employer.hideInternship(internship);
    }

    public void setSortBehavior(String sortMode) {
        if (sortMode.equalsIgnoreCase("pay")) {
            internSortBehavior = new PaySort();
        } else if (sortMode.equalsIgnoreCase("length")) {
            internSortBehavior = new LengthSort();
        }
    }

    public void save() {
        DataWriter.saveInternship(internships);
    }
}
