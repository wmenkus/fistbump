/**
 * @author Brian White
 */
package FistBump;

public class Facade {
    private AccountManager accountManager;
    private ListManager listManager;
    private Account user;

    public Facade(){

    }

    public void displayMenu(){

    }

    public void displayInternships(){

    }

    public void displayAccounts(){

    }

    public void displayApplicants(){

    }

    /**
     * Changes the type of sort for internships or students based on the type
     * of account calling the method. For admins, gives them an option of which
     * one to change.
     * @param sortMode "GPA" "Length" "Rating" "Pay"
     */
    public void changeSortMode(String sortMode){

    }

    public Account createAccount(){
        return null;
    }

    public void login(String email, String password){

    }

    public void apply(int internshipId){

    }


    public void internshipDetails(int accountId){

    }

    public void accountDetails(int accountId){

    }

    public void createResume(){

    }

    public void addRating(int accountId){

    }

    public void hideInternship(int internshipId){

    }

    public Internship createInternship(){
        return null;
    }

    public void removeAccount(int accountId){

    }

    public void hideRating(int accoundId, int ratingId){

    }

    public void reviseInternship(int internhipId){

    }

    public void removeInternship(int internshipId){

    }

    public Admin createAdminAccount(){
        return null;
    }

    public void logout(){
        
    }
}
