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
        Student student2 = (Student)accountManager.searchByEmail("jlee@gmail.com");
        assertTrue(student.email.equals(student.email));
    }

    public void testSearchByEmailInvalidEmail(){
        Student student = new Student("jamison lee", "jlee@gmail.com", "pa$$word", "555-555-5555");
        accountManager.addAccount(student);
        Student student2 = (Student)accountManager.searchByEmail("jle@gmail.com");
        assertFalse(student.email.equals(student.email));
    }
}