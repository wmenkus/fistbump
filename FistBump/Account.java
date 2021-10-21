/**
 * @author Brian White
 */
package FistBump;
import java.util.UUID;
public abstract class Account {
    protected UUID id;
    protected String name;
    protected String email;
    protected String password;

<<<<<<< HEAD
    public Account(String name, String email, String password){
        id = UUID.randomUUID();
        this.name = name;
        this.email = email;
        this.password = password;
    }

=======
>>>>>>> 0e5096fa9039d3275c78a692c6b77101c65a9d80
    public abstract int getPermissions();
    
}
