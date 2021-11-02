/**
 * @author Brian White
 */
package FistBump;

import java.util.UUID;

public class Admin extends Account{
    
    public Admin(String name, String email, String password) {
        super(name, email, password);
    }
    
    public Admin( UUID id, String name, String email, String password){
        super(id, name, email, password);
    }

    public void removeAccount(Account account){
        account = null;
    }

    public void hideRating(Rating rating){
        rating.setValid(false);
    }

    public void revealRating(Rating rating){
        rating.setValid(true);
    }

    public void reviseInternship(Internship oldInternship, Internship newInternship){
        oldInternship = newInternship;
    }

    public void removeInternship(Internship internship){
        internship = null;
    }

    public static void createAdminAccount(String name, String email, String password){

    }

    public int getPermissions() {
        return 2;
    }

    public String toString() {
        return name + "\nIs an Admin";
    }

    public String details() {
        return toString();
    }
}
