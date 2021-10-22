/**
 * @author Brian White
 */
package FistBump;

public class Admin extends Account{
    
    public Admin(String name, String email, String password){
        super(name, email, password);
    }

    public void removeAccount(Account account){
        account = null;
    }

    public void hideRating(Rating rating){
        rating.hide();
    }

    public void reviseInternship(Internship old, Internship newInternship){
        
    }

    public void removeInternship(Internship internship){

    }

    public void createAdminAccount(String name, String email, String password){

    }

    public int getPermissions() {
        return 2;
    }
}
