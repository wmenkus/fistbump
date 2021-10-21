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
    protected int permissions;

    public Account(){

    }
    public int getPermissions(){
        return permissions;
    }
    
}
