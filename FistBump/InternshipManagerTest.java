package FistBump;

/**
 * Written by Walker Menkus
 */

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class InternshipManagerTest {
    private InternshipManager internshipManager = InternshipManager.getInstance();
    private ArrayList<Internship> internships = internshipManager.getInternships();

    @BeforeEach
    public void setup() {
        internships.clear();
        Employer testEmployer = new Employer("Tech Inc.", "technology@tech.com", "techa");
        internshipManager.addInternship(testEmployer, new Internship(testEmployer, "name", 0.5, "description", 3, "skillRequirements", true, "startDate"));
        internshipManager.addInternship(testEmployer, new Internship(testEmployer, "tech officer", 2.5, "does technology", 1200, "type 300 wpm", false, "02/30/2022"));
        internshipManager.save();
    }

    @AfterEach
    public void tearDown() {
        internships.clear();
        internshipManager.save();
    }

    @Test
    public void testAddInternship() {
        int internshipsSize = internships.size();
        Employer testEmployer = internships.get(0).getPoster();
        int employerListSize = testEmployer.getInternships().size();
        Internship testInternship = new Internship(testEmployer, "beep", 0, "description", 1, "skillRequirements", true, "startDate");
        internshipManager.addInternship(testEmployer, testInternship);
        assertTrue(internships.size() == internshipsSize + 1 && testEmployer.getInternships().size() == employerListSize + 1);
    }

    @Test
    public void testAddInternshipMismatchPoster() {
        int internshipsSize = internships.size();
        Employer testEmployer = internships.get(0).getPoster();
        int employerListSize = testEmployer.getInternships().size();
        Employer testEmployerInvalid = new Employer("", "", "");
        Internship testInternship = new Internship(testEmployerInvalid, "", 0, "", 1, "", true, "");
        internshipManager.addInternship(testEmployer, testInternship);
        assertTrue(internships.size() == internshipsSize && testEmployer.getInternships().size() == employerListSize);
    }

    @Test
    public void testRemoveInternship() {
        int internshipSize = internships.size();
        Employer testEmployer = internships.get(0).getPoster();
        int employerListSize = testEmployer.getInternships().size();
        internshipManager.removeInternship(testEmployer, internships.get(0));
        assertTrue(internships.size() == internshipSize - 1 && testEmployer.getInternships().size() == employerListSize - 1);
    }

    @Test
    public void testSetSortModeLength() {
        internshipManager.setSortBehavior("length");
        assertEquals(LengthSort.class, internshipManager.getSortBehavior().getClass());
    }

    @Test
    public void testSetSortModePay() {
        internshipManager.setSortBehavior("length");
        internshipManager.setSortBehavior("pay");
        assertEquals(PaySort.class, internshipManager.getSortBehavior().getClass());
    }

    @Test
    public void testPaySort() {
        Employer testEmployer = internships.get(0).getPoster();
        for(int i = 0; i < 10; i++) {
            internships.add(new Internship(testEmployer, "", i, "", 1, "", true, ""));
        }
        internshipManager.setSortBehavior("pay");
        internshipManager.sort();
        assertEquals(9, internships.get(0).getPay());
    }

    @Test
    public void testLengthSort() {
        Employer testEmployer = internships.get(0).getPoster();
        for(int i = 0; i < 10; i++) {
            internships.add(new Internship(testEmployer, "", 1, "", i, "", true, ""));
        }
        internshipManager.setSortBehavior("length");
        internshipManager.sort();
        assertEquals(0, internships.get(0).getTimePeriod());
    }

}
