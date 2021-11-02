/**
 * @author Brian White
 */
package FistBump;
import java.util.ArrayList;
public class AccountManager {

    private ArrayList<Account> accounts;
    private static AccountManager accountManager;

    private AccountManager() {
        accounts = new ArrayList<Account>();
        accounts.addAll(DataLoader.loadAdmins());
        accounts.addAll(DataLoader.loadEmployers());
        accounts.addAll(DataLoader.loadStudents());
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
        accounts.add(account);     
    }

    public void removeAccount(Account account) {
        accounts.remove(account);
    }
}