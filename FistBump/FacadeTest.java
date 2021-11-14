package FistBump;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

class FacadeTest {
    private Facade facade = new Facade();
    private AccountManager accountManager = AccountManager.getInstance();
    private InternshipManager internshipManager = InternshipManager.getInstance();

    @BeforeEach
    public void setup() {
        accountManager.getAccounts().clear();
        accountManager.getStudents().clear();
        accountManager.getEmployers().clear();
        accountManager.getAdmins().clear();
        internshipManager.getInternships().clear();
        facade.save();
    }

    @AfterEach
    public void tearDown() {
        setup();
    }

    @Test
    public void testValidLogin() {
        Student student = new Student("jamison lee", "jlee@gmail.com", "pa$$word", "555-555-5555");
        facade.addAccount(student);
        facade.login("jlee@gmail.com", "pa$$word");
        Account currentUser = facade.getUser();
        assertEquals(student, currentUser);
    }

    @Test
    public void testInvalidLogin() {
        Student student = new Student("jamison lee", "jlee@gmail.com", "pa$$word", "555-555-5555");
        facade.addAccount(student);
        facade.login("emarks@stinker.org", "stinkstonk");
        assertEquals(facade.getUser(), null);
    }

    @Test
    public void testInvalidPassword() {
        Student student = new Student("jamison lee", "jlee@gmail.com", "pa$$word", "555-555-5555");
        facade.addAccount(student);
        facade.login("jlee@gmail.com", "password");
        assertEquals(facade.getUser(), null);
    }

    @Test
    public void testInvalidUsernameValidPassword() {
        Student student = new Student("jamison lee", "jlee@gmail.com", "pa$$word", "555-555-5555");
        facade.addAccount(student);
        facade.login("emarks@stinker.org", "pa$$word");
        assertEquals(facade.getUser(), null);
    }

    @Test
    public void testCreateSaved() {
        Student student = new Student("james bond", "jbond@gmail.com", "007", "007-007-0007");
        facade.addAccount(student);
        facade.logout();
        facade = new Facade();
        facade.login("jbond@gmail.com", "007");
        assertEquals(student, facade.getUser());
    }

    @Test
    public void testCreateDuplicateEmail() {
        Student student = new Student("james lee", "jlee@gmail.com", "james", "555-555-5555");
        Student student2 = new Student("jamison lee", "jlee@gmail.com", "jamison", "555-555-5555");
        facade.addAccount(student);
        facade.addAccount(student2);
        boolean isCreated = accountManager.getStudents().contains(student2);
        assertFalse(isCreated);
    }

    @Test
    public void testCreateInvalidEmail() {
        Student student = new Student("james lee", "james lee's email", "james", "555-555-5555");
        facade.addAccount(student);
        boolean isCreated = accountManager.getStudents().contains(student);
        assertFalse(isCreated);
    }

    @Test
    public void testCreateNoEmail() {
        Student student = new Student("james lee", "", "james", "555-555-5555");
        facade.addAccount(student);
        boolean isCreated = accountManager.getStudents().contains(student);
        assertFalse(isCreated);
    }

    @Test
    public void testCreateNoName() {
        Student student = new Student("", "jlee@gmail.com", "james", "555-555-5555");
        facade.addAccount(student);
        boolean isCreated = accountManager.getStudents().contains(student);
        assertFalse(isCreated);
    }

    @Test
    public void testCreateNullEmail() {
        Student student = new Student("james lee", null, "james", "555-555-5555");
        facade.addAccount(student);
        boolean isCreated = accountManager.getStudents().contains(student);
        assertFalse(isCreated);
    }

    @Test
    public void testChangeSortString() {
        facade.changeInternshipSortMode("length");
        assertEquals(facade.getInternshipSortString(), "length");
    }

    @Test
    
}
