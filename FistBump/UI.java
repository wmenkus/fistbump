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
                changeSortMode();
            }
            else if(input.equals("4")) {
                applyToInternship();
            }
            else if(input.equals("5")) {
                displayInternship();
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

    //TODO this method will need to be rewritten, and we will need a Reference class
    private String addReference() {
        System.out.println(
            "-------- Entering your References --------\n" +
            "Please enter a reference: "
        );
        return keyboard.nextLine();
    }

    private Employment addEmployment() {
        String jobTitle;
        String companyName;
        String startDate;
        String endDate;
        String contactInfo;
        System.out.println("-------- Past Employment --------");
        System.out.println("Please enter your job title: ");
        jobTitle = keyboard.nextLine();
        System.out.println("Enter the company name: ");
        companyName = keyboard.nextLine();
        System.out.println("Enter your start date in the form MM/DD/YYYY: ");
        startDate = keyboard.nextLine();
        System.out.println("Enter your end date in the form MM/DD/YYYY: ");
        endDate = keyboard.nextLine();
        System.out.println("Enter the company's email: ");
        contactInfo = keyboard.nextLine();
        return new Employment(jobTitle, companyName, startDate, endDate, contactInfo);
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
}
