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

    public void hideRating(Rating rating){
        rating.setValid(false);
    }

    public void revealRating(Rating rating){
        rating.setValid(true);
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
