package FistBump;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class AccountManagerTest {
    private AccountManager accountManager = AccountManager.getInstance();
    private ArrayList<Account> accounts = accountManager.getAccounts();
    private ArrayList<Student> students = accountManager.getStudents();
    private ArrayList<Employer> employers = accountManager.getEmployers();
    private ArrayList<Admin> admins = accountManager.getAdmins();
    

    @BeforeEach
    public void setup() {
        accounts.clear();
        students.clear();
        employers.clear();
        admins.clear();
        accountManager.addAccount(new Student("jamison lee", "jlee@gmail.com", "pa$$word", "555-555-5555"));
        accountManager.addAccount(new Employer("Tech Inc.", "technology@tech.com", "techa"));
        accountManager.addAccount(new Admin("Walker Menkus", "wmenkus@gmail.com", "stinkymenky"));
        accountManager.addAccount(new Student("charles brown", "cb@bc.com", "ungabunga", "843-2092234"));
        accountManager.addAccount(new Employer("CoffeeCo", "darkroast@beans.com", "americano"));
        accountManager.addAccount(new Student("Cameron Delk", "chdelk@gmail.com", "dragon34", "843-727-2455"));
        accountManager.save();
    }

    @AfterEach
    public void tearDown() {
        accounts.clear();
        students.clear();
        employers.clear();
        admins.clear();
        accountManager.save();
    }

    @Test
    public void testSearchByValidEmail(){
        assertEquals("charles brown", accountManager.searchByEmail("cb@bc.com").getName());
    }

    @Test
    public void testSearchByInvalidEmail(){
        assertNotEquals("jamison lee", accountManager.searchByEmail("jle@gmail.com").getName());
    }

    @Test
    public void testHasFirstItem() {
        assertEquals("jamison lee", accountManager.getAccounts().get(0).getName());
    }

    @Test
    public void testHasAllStudents() {
        boolean hasStudents = true;
        for(Student student : students) {
            if(!accounts.contains(student)) {
                hasStudents = false;
            }
        }
        assertTrue(hasStudents);
    }

    @Test
    public void testHasNullEmail() {
        assertTrue(accountManager.searchByEmail(null) == null);
    }

    @Test
    public void testAddStudentAccount() {
        int accountsSize = accounts.size();
        int studentsSize = students.size();
        Student testStudent = new Student("john examination", "jtest@cn.com", "whipcrack", "987-201-9090");
        accountManager.addAccount(testStudent);
        assertTrue(accounts.size() == accountsSize + 1 && students.size() == studentsSize + 1);
    }

    @Test
    public void testAddEmployerAccount() {
        int accountsSize = accounts.size();
        int employersSize = employers.size();
        Employer testEmployer = new Employer("beedlebop co.", "beedle@bop.com", "whileywoo");
        accountManager.addAccount(testEmployer);
        assertTrue(accounts.size() == accountsSize + 1 && employers.size() == employersSize + 1);
    }

    @Test
    public void testRemoveStudentAccount() {
        int accountsSize = accounts.size();
        int studentsSize = students.size();
        accountManager.removeAccount(accountManager.searchByEmail("chdelk@gmail.com"));
        assertTrue(accounts.size() == accountsSize - 1 && students.size() == studentsSize - 1);
    }

    @Test
    public void testRemoveNullAccount() {
        int numOfAccounts = accounts.size();
        accountManager.removeAccount(null);
        assertEquals(numOfAccounts, accounts.size());
    }

}