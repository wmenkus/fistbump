package FistBump;

public class Account {
    private String name;
    private String email;
    private String password;
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
