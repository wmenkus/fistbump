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

    public Account(String name, String email, String password){
        id = UUID.randomUUID();
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public abstract int getPermissions();
    
}
