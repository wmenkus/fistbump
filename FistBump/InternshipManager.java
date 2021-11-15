package FistBump;
import java.util.ArrayList;

public class InternshipManager {
    private ArrayList<Internship> internships;
    private static InternshipManager listManager;
    private InternshipSortBehavior internSortBehavior;

    private InternshipManager() {
        internships = DataLoader.loadInternships();
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
        internships.add(internship);
        employer.addInternship(internship);
    }

    public void removeInternship(Employer employer, Internship internship) {
        internships.remove(internship);
        employer.removeInternship(internship);
    }

    public void sort() {
        internSortBehavior.sort(internships);
    }

    public Internship getInternship(Internship internship) {
        return internship;
    }

    public void setSortBehavior(String sortMode) {
        if (sortMode.equalsIgnoreCase("pay")) {
            internSortBehavior = new PaySort();
        } else if (sortMode.equalsIgnoreCase("length")) {
            internSortBehavior = new LengthSort();
        }
    }

    public InternshipSortBehavior getSortBehavior() {
        return this.internSortBehavior;
    }

    public void save() {
        DataWriter.saveInternship(internships);
    }
}
