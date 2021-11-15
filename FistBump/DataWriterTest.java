package FistBump;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataWriterTest {

    private AccountManager accountManager = AccountManager.getInstance();
    private InternshipManager internshipManager = InternshipManager.getInstance();
    private ArrayList<Student> studentList = accountManager.getStudents();
    private ArrayList<Employer> employerList = accountManager.getEmployers();
    private ArrayList<Admin> adminList = accountManager.getAdmins();
    private ArrayList<Internship> internshipList = internshipManager.getInternships();
	
	@BeforeEach
	public void setup() {
        accountManager.getInstance().getEmployers().clear();
        accountManager.getInstance().getStudents().clear();
        accountManager.getInstance().getAdmins().clear();
        DataWriter.saveAdmin(adminList);
        DataWriter.saveEmployer(employerList);
        DataWriter.saveStudent(studentList);
        DataWriter.saveInternship(internshipList);
	}
	
	@AfterEach
	public void tearDown() {
		accountManager.getInstance().getEmployers().clear();
        accountManager.getInstance().getStudents().clear();
        accountManager.getInstance().getAdmins().clear();
        DataWriter.saveAdmin(adminList);
        DataWriter.saveEmployer(employerList);
        DataWriter.saveStudent(studentList);
        DataWriter.saveInternship(internshipList);
	}
	
	
	@Test
	void testWritingZeroStudents() {
		studentList = DataLoader.loadStudents();
		assertEquals(0, studentList.size());
	}

	@Test
	void testWritingOneStudent() {
		studentList.add(new Student("Brian White", "brian01white@gmail.com", "123456", "704-519-9114"));
        DataWriter.saveStudent(studentList);
        studentList = DataLoader.loadStudents();
		assertEquals("Brian", studentList.get(0).getName());
	}
	
	@Test
	void testWritingFiveStudents() {
		studentList.add(new Student("Brian White", "brian01white@gmail.com", "123456", "704-519-9114"));
		studentList.add(new Student("jamison lee", "jlee@gmail.com", "pa$$word", "555-555-5555"));
        studentList.add(new Student("charles brown", "cb@bc.com", "ungabunga", "843-2092234"));
        studentList.add(new Student("Charles Entertainment Cheese", "CCheese@gmail.com", "poop", "803-369-4693"));
        studentList.add(new Student("Cameron Delk", "chdelk@gmail.com", "dragon34", "843-727-2455"));
        DataWriter.saveStudent(studentList);
        studentList = DataLoader.loadStudents();
		assertEquals("Cameron Delk", studentList.get(4).getName());
	}
	
	@Test
	void testWritingEmptyStudent() {
		studentList.add(new Student("", "", "", ""));
        DataWriter.saveStudent(studentList);
        studentList = DataLoader.loadStudents();
		assertEquals("", studentList.get(0).getName());
	}
	
	@Test
	void testWritingNullStudent() {
		studentList.add(new Student(null, "", "", ""));
        DataWriter.saveStudent(studentList);
        studentList = DataLoader.loadStudents();
		assertEquals(null, studentList.get(0).getName());
	}
	
}