/**
 * @author Brian White
 * @author Walker Menkus
 */
package FistBump;

import java.util.UUID;

/**
 * Account is an abstract base class that all user accounts, Student,
 * Employer, and Admin, inherit from. All accounts will have an ID,
 * a name (username?), an email, and a password. All accounts also have
 * a permissions value to be checked by the Facade, which will be
 * defined in their inherited abstract method getPermissions().
 */
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

    /**
     * Abstract method getPermissions is how the permission level of
     * each class is defined. Each class will return a different value for
     * their permissions.
     * @return 0 for Student, 1 for Employer, 2 for Admin
     */
    public abstract int getPermissions();
    
}
