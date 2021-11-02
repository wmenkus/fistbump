/**
 * @author Brian White
 */
package FistBump;
import java.util.ArrayList;
public class AccountManager {

    private ArrayList<Account> accounts;
    private ArrayList<Admin> admins;
    private ArrayList<Student> students;
    private ArrayList<Employer> employers;
    private static AccountManager accountManager;

    private AccountManager() {
        accounts = new ArrayList<Account>();
        admins = DataLoader.loadAdmins();
        students = DataLoader.loadStudents();
        employers = DataLoader.loadEmployers();

        ArrayList<Internship> internships = InternshipManager.getInstance().getInternships();

        for (Employer employer : employers) {
            for (String internshipId : employer.getInternshipIds()) {
                for (Internship internship : internships) {
                    if (internshipId.equals(internship.getId().toString())) {
                        employer.addInternship(internship);
                        internship.setPoster(employer);
                    }
                }
            }
        }

        accounts.addAll(admins);
        accounts.addAll(students);
        accounts.addAll(employers);

        
    }
    

    public Account searchByEmail(String email) {
        for(Account account : accounts) {
            if(account.getEmail().equals(email)) {
                return account;
            }
        }
        return null;
    }
    
    public Account searchByName(String name) {
        for(Account account : accounts) {
            if(account.getName().equalsIgnoreCase(name)) {
                return account;
            }
        }
        return null;
    }

    public static AccountManager getInstance(){
        if (accountManager == null) {
            accountManager = new AccountManager();
        }
        return accountManager; 
    }
    public void addAccount(Account account) {
        if (account.getPermissions() == 2) {
            admins.add((Admin) account);
        }
        else if (account.getPermissions() == 1) {
            employers.add((Employer) account);
        } 
        else if (account.getPermissions() == 0){
            students.add((Student) account);
        }
    }

    public void removeAccount(Account account) {
        accounts.remove(account);
    }

    public void save() {
        DataWriter.saveAdmin(admins);
        DataWriter.saveEmployer(employers);
        DataWriter.saveStudent(students);
    }

}