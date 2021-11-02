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

        for (Employer employer : AccountManager.getInstance().getEmployers()) {
            for (String internshipId : employer.getInternshipIds()) {
                System.out.println("Facade: "+internshipId);
                for (Internship internship : InternshipManager.getInstance().getInternships()) {
                    if (internshipId.equals(internship.getId().toString())) {
                        System.out.println("true");
                        employer.addInternship(internship);
                        internship.setPoster(employer);
                    }
                    else {

                        System.out.println(internship.getId().toString());
                        System.out.println(internshipId);
                    }
                }
            }
        }
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

    //TODO is checking for the account type here going to make debugging harder?
    public void addResume(Resume resume) {
        if(user.getPermissions() == 0) {
            ((Student)user).addResume(resume);
        }
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

    public ArrayList<Internship> getMyInternships() {
        return ((Employer)user).getInternships();
    }

    public void addAccount(Account account) {
        accountManager.addAccount(account);
    }

    public void addInternship(Employer employer, Internship internship){
        internshipManager.addInternship(employer, internship);
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
        //TODO
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
