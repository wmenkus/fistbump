/**
 * @author Brian White
 */
package FistBump;

public class Account {
    protected String name;
    protected String email;
    protected String password;
    private int permissions;
    private int id;

    public Account(){
        name = "";
        email = "";
        password = "";
        permissions = 0;
        id = 0;
    }
    public int getPermissions(){
        return permissions;
    }
    
}
