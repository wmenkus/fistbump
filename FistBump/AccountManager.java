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

    public Account search(String email) {
        for(Account account : accounts) {
            if(account.getEmail().equals(email)) {
                return account;
            }
        }
        return null;
    }

    public static void getInstance(){

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