package FistBump;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataLoaderTest {

	private AccountManager accountManager = AccountManager.getInstance();
    private InternshipManager internshipManager = InternshipManager.getInstance();
    private ArrayList<Student> studentList = accountManager.getStudents();
    private ArrayList<Employer> employerList = accountManager.getEmployers();
    private ArrayList<Admin> adminList = accountManager.getAdmins();
    private ArrayList<Internship> internshipList = internshipManager.getInternships();
	
	@BeforeEach
	public void setup() {
        studentList.clear();
        employerList.clear();
        adminList.clear();
        internshipList.clear();
        studentList.add(new Student("Brian White", "brian01white@gmail.com", "123456", "704-519-9114"));
        studentList.add(new Student("jamison lee", "jlee@gmail.com", "pa$$word", "555-555-5555"));
        adminList.add(new Admin("Walker Menkus", "wmenkus@gmail.com", "stinkymenky"));
        employerList.add(new Employer("Tech Inc.", "technology@tech.com", "techa"));
        employerList.add(new Employer("CoffeeCo", "darkroast@beans.com", "americano"));

        Employer testEmployer = new Employer("Tech Inc.", "technology@tech.com", "techa");
        internshipList.add(new Internship(testEmployer, "name", 0.5, "description", 3, "skillRequirements", true, "startDate"));
        internshipList.add(new Internship(testEmployer, "tech officer", 2.5, "does technology", 1200, "type 300 wpm", false, "02/30/2022"));
        
        DataWriter.saveAdmin(adminList);
        DataWriter.saveEmployer(employerList);
        DataWriter.saveStudent(studentList);
        DataWriter.saveInternship(internshipList);
	}
	
	@AfterEach
	public void tearDown() {
		employerList.clear();
        studentList.clear();
        adminList.clear();
        internshipList.clear();
		DataWriter.saveAdmin(adminList);
        DataWriter.saveEmployer(employerList);
        DataWriter.saveStudent(studentList);
        DataWriter.saveInternship(internshipList);
	}
	
	
	@Test
	void testGetStudentsSize() {
		studentList = DataLoader.loadStudents();
		assertEquals(2, studentList.size());
	}

	@Test
	void testGetStudentSizeZero() {
		studentList.clear();
        DataWriter.saveStudent(studentList);
        studentList = DataLoader.loadStudents();
		assertEquals(0, studentList.size());
	}
	
	@Test
    void testGetStudentName() {
        studentList = DataLoader.loadStudents();
        assertEquals("Brian White", studentList.get(0).getName());
    }

    //
    @Test
	void testGetIntrnshipsSize() {
		internshipList = DataLoader.loadInternships();
		assertEquals(2, studentList.size());
	}

	@Test
	void testGetInternshipSizeZero() {
		internshipList.clear();
        DataWriter.saveInternship(internshipList);
        internshipList = DataLoader.loadInternships();
		assertEquals(0, internshipList.size());
	}
	
	@Test
	void testGetInternshipName() {
		internshipList = DataLoader.loadInternships();
		assertEquals("name", internshipList.get(0).getName());
	}
}