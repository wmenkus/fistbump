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

        for (Employer employer : employers) {
            for (String internshipId : employer.getInternshipIds()) {
                System.out.println("AccountManager: " + internshipId);
                for (Internship internship : InternshipManager.getInstance().getInternships()) {
                    if (internshipId.equals(internship.getId().toString())) {
                        System.out.println("true");
                        employer.addInternship(internship);
                        internship.setPoster(employer);
                    } else {

                        System.out.println(internship.getId().toString());
                        System.out.println(internshipId);
                    }
                }
            }
        }

        for (Internship internship : InternshipManager.getInstance().getInternships()) {
            ArrayList<Student> applicants = new ArrayList<Student>();
            for (String applicantId : internship.getApplicantIds()) {
                for (Student student : students) {
                    if (applicantId.equals(student.getId().toString())) {
                        applicants.add(student);
                    }
                }

            }
            internship.setApplicants(applicants);
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
        if(accounts.size() == 0) {
            return null;
        }
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
        accounts.add(account);
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

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void save() {
        DataWriter.saveAdmin(admins);
        DataWriter.saveEmployer(employers);
        DataWriter.saveStudent(students);
    }

    public ArrayList<Employer> getEmployers(){
        return employers;
    }

}