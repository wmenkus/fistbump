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

    public Account(){

    }

    public abstract int getPermissions();
    
}
