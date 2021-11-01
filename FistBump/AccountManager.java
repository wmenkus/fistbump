/**
 * @author Brian White
 */
package FistBump;
import java.util.ArrayList;
public class AccountManager{

    private ArrayList<Account> accounts;
    private int idTotal;
    private AccountManager accountManager;

    private AccountManager(){

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
        return null; //TODO this is wrong
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void addRating(Account rater, Account rated, int rating){

    }

    public Account getAccount(int id){

        return null;
    }

    public void removeAccount(int id){
    
    }
}