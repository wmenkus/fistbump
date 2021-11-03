/**
 * @author Brian White
 */
package FistBump;

import java.util.ArrayList;

public class Facade {
    private AccountManager accountManager;
    private InternshipManager internshipManager;
    private Account user;
    private String internshipSortString;
    private String studentSortString;

    public Facade(){
        internshipManager = InternshipManager.getInstance();
        accountManager = AccountManager.getInstance();
        user = null;
        internshipSortString = "pay";
        studentSortString = "rating";
    }

    public boolean login(String email, String password) {
        if(verify(email, password)) {
            this.user = accountManager.searchByEmail(email);
            return true;
        }
        else {
            return false;
        }
    }

    public void logout() {
        user = null;
    }

    public boolean verify(String email, String password) {
        Account inspected = accountManager.searchByEmail(email); //This should return null if the account DNE
        if(inspected == null) {
            return false;
        }
        else {
            return inspected.getPassword().equals(password);
        }
    }

    public Account searchAccount(String name) {
        return accountManager.searchByName(name);
    }

    public void addResume(Resume resume) {
        ((Student)user).addResume(resume);
    }

    public Account getUser() {
        return this.user;
    }

    public int getPermissions() {
        return user.getPermissions();
    }

    public String getInternshipSortString() {
        return internshipSortString;
    }

    public String getStudentSortString() {
        return studentSortString;
    }

    public ArrayList<Internship> getInternships() {
        return internshipManager.getInternships();
    }

    public ArrayList<Account> getAccounts() {
        return accountManager.getAccounts();
    }

    public ArrayList<Internship> getMyInternships() {
        return ((Employer)user).getInternships();
    }

    public void addAccount(Account account) {
        accountManager.addAccount(account);
    }

    public void removeAccount(Account account) {
        accountManager.removeAccount(account);
    }

    public void addInternship(Internship internship){
        internshipManager.addInternship((Employer)user, internship);
    }

    public void removeInternship(Internship internship) {
        internshipManager.removeInternship((Employer)user, internship);
    }

    /**
     * This is all wrong
     * 
     * Changes the type of sort for internships or students based on the type
     * of account calling the method. For admins, gives them an option of which
     * one to change.
     * @param sortMode "GPA" "Length" "Rating" "Pay"
     */
    public void changeInternshipSortMode(String sortMode){
        //if sortMode == pay, internshipSortMode = paySort; internshipSortString = pay;
        internshipManager.setSortBehavior(sortMode);
    }

    public void changeStudentSortMode(String sortMode) {
        ((Employer)user).setSortBehavior(sortMode);
    }

    public void sortInternships() {
        internshipManager.sort();
    }

    public Account createAccount() {
        return null;
    }
    
    public void save() {
        accountManager.save();
        internshipManager.save();
    }

    public void printResume() {
        DataWriter.saveResume(((Student)user).getResumes().get(((Student)user).getResumes().size()-1));
    }
}
