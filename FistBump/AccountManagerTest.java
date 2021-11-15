package FistBump;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

class AccountManagerTest {
    private AccountManager accountManager = AccountManager.getInstance();

    

    @BeforeEach
    public void setup() {
        accountManager.getAccounts().clear();
        accountManager.getStudents().clear();
        accountManager.getEmployers().clear();
        accountManager.getAdmins().clear();
    }

    @AfterEach
    public void tearDown() {
        setup();
    }

    @Test
    public void testSearchByEmail(){
        Student student = new Student("jamison lee", "jlee@gmail.com", "pa$$word", "555-555-5555");
        accountManager.addAccount(student);
        assertTrue(student.equals((Student)accountManager.searchByEmail("jlee@gmail.com")));
    }

    public void testSearchByEmailInvalidEmail(){
        Student student = new Student("jamison lee", "jlee@gmail.com", "pa$$word", "555-555-5555");
        accountManager.addAccount(student);
        assertTrue(student.equals((Student)accountManager.searchByEmail("jle@gmail.com")));
    }
}