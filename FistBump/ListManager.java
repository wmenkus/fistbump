package FistBump;

import java.util.ArrayList;

public class ListManager {
    private ArrayList<Internship> internships;
    ListManager() {
        internships = new ArrayList<Internship>();
    }

    public void addInternship(Internship internship) {
        internships.add(internship);
    }
}
