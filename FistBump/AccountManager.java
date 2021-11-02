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