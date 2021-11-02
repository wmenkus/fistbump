/**
 * @author Walker Menkus
 */

package FistBump;

import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    private Facade app;
    private Scanner keyboard;
    private String input;

    public UI(Facade app) {
        this.app = app;
        keyboard = new Scanner(System.in);
    }

    private void inputError() {
        System.out.println("Incorrect input.");
    }

    public void start() {
        boolean exit = false;
        while (!exit) {
            loginScreen();
            input = keyboard.nextLine();
            if(input.equals("1")) {
                verify();
            }
            if(input.equals("2")) {
                createAccount();
            }
            if(input.equals("3")) {
                exit = true;
            }
            else {
                inputError();
            }
        }
    }

    public void loginScreen() {
        System.out.println (
            "======== FistBump ========\n" + 
            "1. Log In \n" +
            "2. Create an Account\n" +
            "3. Exit\n"
        );
    }

    public void verify() {
        boolean exit = false;
        while(!exit)
        {
            System.out.println("Please enter your username: \n");
            String username = keyboard.nextLine();
            System.out.println("Please enter your password: \n");
            String password = keyboard.nextLine();
            if(app.verify(username, password)) {
                app.login(username, password);
                exit = true;
            }
        }
        if(app.getPermissions() == 0) {
            studentMenu();
        }
        if(app.getPermissions() == 1) {
            employerMenu();
        }
        if(app.getPermissions() == 2) {
            adminMenu();
        }
    }

    public void createAccount() {
        int accountType = -1; //Sentinel value
        boolean exit = false;
        while(!exit) {
            System.out.println(
                "-------- Creating an Account --------\n" +
                "What kind of account are you creating?\n" +
                "1. Student\n" +
                "2. Employer\n" +
                "3. Quit\n"
            );
            input = keyboard.nextLine();
            if(input.equals("1")) {
                accountType = 0;
                exit = true;
            }
            else if(input.equals("2")) {
                accountType = 1;
                exit = true;
            }
            else if(input.equals("3")) {
                return;
            }
            else {
                inputError();
            }
        }

        String name = "";
        String email = "";
        String password = "";
        System.out.println("Please enter your name: ");
        name = keyboard.nextLine();
        System.out.println("Please enter your email: ");
        email = keyboard.nextLine();
        boolean match = false;
        while(!match) {
            System.out.println("Please enter your password: ");
            password = keyboard.nextLine();
            System.out.println("Please confirm your password: ");
            if(password.equals(keyboard.nextLine())) {
                match = true;
            }
            else {
                System.out.println("Password mismatch.");
            }
        }
        if(accountType == 0) {
            Student student = new Student(name, email, password);
            app.addAccount(student);
            app.login(email, password);
            studentMenu();
        }
        else if(accountType == 1) {
            Employer employer = new Employer(name, email, password);
            app.addAccount(employer);
            app.login(email, password);
            employerMenu();
        }
    }

    public void studentMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println (
                "======== Main Menu =========\n" +
                "1. Create Resume\n" +
                "2. Display Internships\n" +
                "3. Change Sort Mode\n" +
                "4. Apply to Internship\n" +
                "5. Display Internship Details\n" +
                "6. Rate Employer\n" +
                "7. Log Out\n"
            );
            input = keyboard.nextLine();
            if(input.equals("1")) {
                createResume();
            }
            else if(input.equals("2")) {
                displayInternships();
            }
            else if(input.equals("3")) {
                changeInternshipSortMode();
            }
            else if(input.equals("4")) {
                applyToInternship();
            }
            else if(input.equals("5")) {
                displayInternshipDetails();
            }
            else if(input.equals("6")) {
                rateEmployer();
            }
            else if(input.equals("7")) {
                exit = true;
            }
            else {
                inputError();
            }
        }
    }

    public void createResume() {
        double gpa = 0;
        String skills = "";
        String references = "";
        ArrayList<Employment> pastEmployment = new ArrayList<Employment>();
        String employmentString = "";
        ArrayList<Education> education = new ArrayList<Education>();
        String educationString = "";

        boolean exit = false;
        while (!exit) {
            System.out.println(
                "-------- Create a Resume --------\n" +
                "GPA: " + gpa + "\n" +
                "Skills: " + skills + "\n" +
                "References: " + references + "\n" +
                "Past Employment: " + employmentString + "\n" +
                "Education: " + educationString + "\n" +
                "\n"
            );
            System.out.println(
                "1. Enter GPA\n" +
                "2. Add a Skill\n" +
                "3. Add a Reference\n" +
                "4. Add an Employment\n" +
                "5. Add an Education\n" +
                "6. Quit\n" +
                "7. Save and Quit"
            );

            input = keyboard.nextLine();
            if(input.equals("1")) {
                gpa = enterGPA();
            }
            else if(input.equals("2")) {
                skills += addSkill() + " ";
            }
            else if(input.equals("3")) {
                references += addReference() + " ";
            }
            else if(input.equals("4")) {
                Employment fresh = addEmployment();
                pastEmployment.add(fresh);
                employmentString += fresh.toString() + " "; 
            }
            else if(input.equals("5")) {
                Education fresh = addEducation();
                education.add(fresh);
                educationString += fresh.toString() + " ";
            }
            else if(input.equals("6")) {
                exit = true;
            }
            else if(input.equals("7")) {
                Resume resume = new Resume(skills, references, gpa, pastEmployment, education);
                app.addResume(resume);
                exit = true;
            }
            else {
                inputError();
            }
        }
    }

    private double enterGPA() {
        System.out.println(
            "-------- Entering your GPA --------\n" +
            "Please enter your GPA: "
        );
        double result = keyboard.nextDouble();
        keyboard.nextLine();
        return result;
    }

    private String addSkill() {
        System.out.println(
            "-------- Entering your Skills --------\n" +
            "Please enter a skill: "
        );
        return keyboard.nextLine();
    }

    private Employment addEmployment() {
        String jobTitle;
        String companyName;
        String startDate;
        String endDate;
        String contactInfo;
        String jobType;
        System.out.println("-------- Past Employment --------");
        System.out.println("Please enter your job title: ");
        jobTitle = keyboard.nextLine();
        System.out.println("Enter the company name: ");
        companyName = keyboard.nextLine();
        System.out.println("Enter the type of job: ");
        jobType = keyboard.nextLine();
        System.out.println("Enter your start date in the form MM/DD/YYYY: ");
        startDate = keyboard.nextLine();
        System.out.println("Enter your end date in the form MM/DD/YYYY: ");
        endDate = keyboard.nextLine();
        System.out.println("Enter the company's email: ");
        contactInfo = keyboard.nextLine();
        return new Employment(jobTitle, companyName, jobType, startDate, endDate, contactInfo);
    }

    private Education addEducation() {
        String institution;
        String location;
        String degree;
        String graduationDate;
        System.out.println("-------- Education --------");
        System.out.println("Please enter the name of the institution: ");
        institution = keyboard.nextLine();
        System.out.println("Enter the location of the institution in the form \"City, State\": ");
        location = keyboard.nextLine();
        System.out.println("Enter the name of your degree: ");
        degree = keyboard.nextLine();
        System.out.println("Please enter your graduation date in the form MM/DD/YYYY: ");
        graduationDate = keyboard.nextLine();
        return new Education(institution, location, degree, graduationDate);
    }

    public void displayInternships() {
        System.out.println("-------- Internships --------");
        ArrayList<Internship> internships = app.getInternships();
        for(Internship internship : internships) {
            System.out.println(internship.toString() + "\n");
        }
        boolean exit = false;
        while(!exit) {
            System.out.println("Would you like to apply to an internship? (Y/N): ");
            input = keyboard.nextLine();
            if(input.equalsIgnoreCase("y")) {
                applyToInternship();
                exit = true;
            }
            else if(input.equalsIgnoreCase("n")) {
                exit = true;
            }
            else {
                inputError();
            }
        }
    }

    //TODO this needs to be able to search by keyword
    public void changeInternshipSortMode() {
        boolean exit = false;
        while(!exit) {
            System.out.println(
                "-------- Change Sort Mode --------\n" +
                "Your current sort mode is: " + app.getInternshipSortString() +
                "1. Sort by pay\n" +
                "2. Sort by length of employment\n" +
                "3. Cancel"
            );
            input = keyboard.nextLine();
            if(input.equals("1")) {
                app.changeInternshipSortMode("pay");
                exit = true;
            }
            else if(input.equals("2")) {
                app.changeInternshipSortMode("length");
                exit = true;
            }
            else if(input.equals("3")) {
                exit = true;
            }
            else {
                inputError();
            }
        }
    }

    public void applyToInternship() {
        //TODO how will we apply to internship? by name? company? both? id? index?
    }

    public void displayInternshipDetails() {
        //TODO how we select internships to display is dependent on how we apply
    }

    public void rateEmployer() {
        System.out.println("-------- Rating an Employer --------");
        int rating = 0;
        Employer rated = null;

        boolean exit = false;
        while(!exit) {
            System.out.println("Which employer are you rating? Enter Q to cancel.");
            input = keyboard.nextLine();
            if(input.equalsIgnoreCase("q")) {
                return;
            }
            Account temp = app.searchAccount(input);
            if(temp.getPermissions() == 1) {
                rated = (Employer)temp;
                exit = true;
            }
            else {
                System.out.println("Could not find an employer with that name.");
            }
        }
        while(!exit) {
            System.out.println("How would you rate this employer on a scale of 1 to 5?");
            rating = keyboard.nextInt();
            keyboard.nextLine();
            if(0 < rating && rating <= 5) {
                exit = true;
            }
            else {
                inputError();
            }
        }

        Rating newRating = new Rating(rating, app.getUser(), rated);
        rated.addRating(newRating);
    }

    public void employerMenu() {
        System.out.println(
            "======== Main Menu ========\n" +
            "1. Display Applicants\n" +
            "2. Display Applicant Details\n" +
            "3. Change Sort Mode\n" +
            "4. Post Internship\n" +
            "5. Rate Student\n" +
            "6. Log Out\n"
        );
        boolean exit = false;
        while(!exit) {
            input = keyboard.nextLine();
            if(input.equals("1")) {
                displayApplicants();
            }
            else if(input.equals("2")) {
                displayApplicantDetails();
            }
            else if(input.equals("3")) {
                changeStudentSortMode();
            }
            else if(input.equals("4")) {
                postInternship();
            }
            else if(input.equals("5")) {
                exit = true;
            }
            else {
                inputError();
            }
        }
    }

    public void displayApplicants() {
        System.out.println("-------- Applicants --------");
        ArrayList<Internship> myInternships = app.getMyInternships();
        ArrayList<Student> applicants;
        for(Internship internship : myInternships) {
            System.out.println("For internship \"" + internship.getName() + "\":\n");
            applicants = internship.getApplicants();
            for(Student applicant : applicants) {
                System.out.println(applicant.toString());
            }
        }
    }

    public void displayApplicantDetails() {
        //TODO
    }

    public void changeStudentSortMode() {
        boolean exit = false;
        while(!exit) {
            System.out.println(
                "-------- Change Sort Mode --------\n" +
                "Your current sort mode is: " + app.getStudentSortString() +
                "1. Sort by rating\n" +
                "2. Sort by GPA\n" +
                "3. Cancel"
            );
            input = keyboard.nextLine();
            if(input.equals("1")) {
                app.changeStudentSortMode("pay");
                exit = true;
            }
            else if(input.equals("2")) {
                app.changeStudentSortMode("length");
                exit = true;
            }
            else if(input.equals("3")) {
                exit = true;
            }
            else {
                inputError();
            }
        }
    }

    public void postInternship() {
        String name = "";
        double pay = 0;
        String description = "";
        int timePeriod = 0;
        String skillRequirements = "";
        String onSiteString = "N/A";



        boolean exit = false;

        while(!exit) {
            System.out.println(
                "-------- Post an Internship --------\n" +
                "Job Title: " + name + "\n" +
                "Pay: " + pay + "\n" +
                "Description: " + description + "\n" +
                "Length (in months): " + timePeriod + "\n" +
                "Skill Requirements: " + skillRequirements + "\n" +
                "On Site: " + onSiteString
                
            );

        }
    }

    
}
