package FistBump;

import java.util.ArrayList;

public class ListManager {
    private ArrayList<Internship> internships;
<<<<<<< HEAD
    private static ListManager listManager;
    private SortBehavior sortBehavior;

    private ListManager() {

    }
    public static ListManager getInstance() {
        return listManager;
    }
    public void displayInternships() {

    }
    public void addInternship(Employer employer) {

=======
    ListManager() {
        internships = new ArrayList<Internship>();
>>>>>>> 86297744fb9e6bc8151e69693b409e963cc25f06
    }

    public void addInternship(Internship internship) {
        internships.add(internship);
    }
}
