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
		Users.getInstance().getUsers().clear();
		DataWriter.saveUsers();
	}
	
	
	@Test
	void testGetUsersSize() {
		userList = DataLoader.getUsers();
		assertEquals(2, userList.size());
	}

	@Test
	void testGetUsersSizeZero() {
		Users.getInstance().getUsers().clear();
		DataWriter.saveUsers();
		assertEquals(0, userList.size());
	}
	
	@Test
	void testGetUserFirstUserName() {
		userList = DataLoader.getUsers();
		assertEquals("asmith", userList.get(0).getUserName());
	}
}