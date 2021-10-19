/**
 * @author Brian White
 */
package FistBump;

public class Account {
    protected String name;
    private String email;
    private String password;
    private int permissions;
    private int id;

    public Account(){

    }
    public int getPermissions(){
        return permissions;
    }
    
}
