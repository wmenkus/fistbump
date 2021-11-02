/**
 * @author Walker Menkus
 */

package FistBump;

import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    private Facade app;
    private Scanner keyboard;

    public UI(Facade app) {
        this.app = app;
        keyboard = new Scanner(System.in);
    }

    private void inputError() {
        System.out.println("Incorrect input.");
    }

    public void start() {
        String input;
        boolean exit = false;
        while (!exit) {
            loginScreen();
            input = keyboard.nextLine();
            if(input.equals("1")) {
                verify();
            }
            else if(input.equals("2")) {
                createAccount();
            }
            else if(input.equals("3")) {
                exit = true;
            }
            else {
                inputError();
            }
        }
    }

    public void loginScreen() {
        System.out.println (
            "\n======== FistBump ========\n" + 
            "1. Log In \n" +
            "2. Create an Account\n" +
            "3. Exit\n"
        );
    }

    public void verify() {
        System.out.println("\n-------- Log In --------");
        boolean exit = false;
        while(!exit)
        {
            System.out.println("Please enter your email: ");
            String email = keyboard.nextLine();
            System.out.println("Please enter your password: ");
            String password = keyboard.nextLine();
            if(app.login(email, password)) {
                exit = true;
            }
            else {
                System.out.println("Invalid credentials.");
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
        String input;
        boolean exit = false;
        while(!exit) {
            System.out.println(
                "\n-------- Creating an Account --------\n" +
                "What kind of account are you creating?\n" +
                "1. Student\n" +
                "2. Employer\n" +
                "3. Quit\n"
            );
            input = keyboard.nextLine();
            if(input.equals("1")) {
                createStudentAccount();
                exit = true;
            }
            else if(input.equals("2")) {
                createEmployerAccount();
                exit = true;
            }
            else if(input.equals("3")) {
                return;
            }
            else {
                inputError();
            }
        }
    }

    public void createStudentAccount() {
        String name = "";
        String email = "";
        String phoneNumber = "";
        String password = "";
        System.out.println("\n-------- Creating Student Account --------");
        System.out.println("Please enter your name: ");
        name = keyboard.nextLine();
        System.out.println("Please enter your email: ");
        email = keyboard.nextLine();
        System.out.println("Please enter your phone number: ");
        phoneNumber = keyboard.nextLine();
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
        Student student = new Student(name, email, password, phoneNumber);
        app.addAccount(student);
        app.login(email, password);
        studentMenu();
    }

    public void createEmployerAccount() {
        String name = "";
        String email = "";
        String password = "";
        System.out.println("\n-------- Creating Employer Account --------");
        System.out.println("Please enter the name of your company: ");
        name = keyboard.nextLine();
        System.out.println("Please enter your company email: ");
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
        Employer employer = new Employer(name, email, password);
        app.addAccount(employer);
        app.login(email, password);
        employerMenu();
    }

    public void studentMenu() {
        String input;
        boolean exit = false;
        while (!exit) {
            System.out.println (
                "\n======== Main Menu =========\n" +
                "1. Create Resume\n" +
                "2. Display all Internships\n" +
                "3. Change Sort Mode\n" +
                "4. Search by Keyword\n" +
                "5. Rate Employer\n" +
                "6. Print Resume to Text File\n" +
                "7. Log Out\n"
            );
            input = keyboard.nextLine();
            if(input.equals("1")) {
                createResume();
            }
            else if(input.equals("2")) {
                displayInternships("");
            }
            else if(input.equals("3")) {
                changeInternshipSortMode();
            }
            else if(input.equals("4")) {
                keywordSearch();
            }
            else if(input.equals("5")) {
                rateEmployer();
            }
            else if(input.equals("6")) {
                app.printResume();
                System.out.println("Resume printed!");
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
        String input;
        double gpa = 0;
        String skills = "";
        ArrayList<Employment> pastEmployment = new ArrayList<Employment>();
        String employmentString = "";
        ArrayList<Education> education = new ArrayList<Education>();
        String educationString = "";

        boolean exit = false;
        while (!exit) {
            System.out.println(
                "\n-------- Create a Resume --------\n" +
                "GPA: " + gpa + "\n" +
                "Skills: " + skills + "\n" +
                "Past Employment: " + employmentString + "\n" +
                "Education: " + educationString
            );
            System.out.println(
                "\n1. Enter GPA\n" +
                "2. Add a Skill\n" +
                "3. Add an Employment\n" +
                "4. Add an Education\n" +
                "5. Quit\n" +
                "6. Save and Quit"
            );

            input = keyboard.nextLine();
            if(input.equals("1")) {
                gpa = enterGPA();
            }
            else if(input.equals("2")) {
                skills += addSkill() + " ";
            }
            else if(input.equals("3")) {
                Employment fresh = addEmployment();
                pastEmployment.add(fresh);
                employmentString += fresh.toString() + " ";
            }
            else if(input.equals("4")) {
                Education fresh = addEducation();
                education.add(fresh);
                educationString += fresh.toString() + " ";
            }
            else if(input.equals("5")) {
                exit = true;
            }
            else if(input.equals("6")) {
                Resume resume = new Resume(skills, gpa, pastEmployment, education);
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
            "\n-------- Entering your GPA --------\n" +
            "Please enter your GPA: "
        );
        double result = keyboard.nextDouble();
        keyboard.nextLine();
        return result;
    }

    private String addSkill() {
        System.out.println(
            "\n-------- Entering your Skills --------\n" +
            "Please enter a skill: "
        );
        return keyboard.nextLine();
    }

    private Employment addEmployment() {
        String jobTitle;
        String companyName;
        String jobType;
        String startDate;
        String endDate;
        String jobDescription;
        System.out.println("\n-------- Past Employment --------");
        System.out.println("Please enter your job title: ");
        jobTitle = keyboard.nextLine();
        System.out.println("Enter the company name: ");
        companyName = keyboard.nextLine();
        System.out.println("Enter the job type: ");
        jobType = keyboard.nextLine();
        System.out.println("Enter your start date in the form MM/DD/YYYY: ");
        startDate = keyboard.nextLine();
        System.out.println("Enter your end date in the form MM/DD/YYYY: ");
        endDate = keyboard.nextLine();
        System.out.println("Enter the Job description: ");
        jobDescription = keyboard.nextLine();
        return new Employment(jobTitle, companyName, jobType, startDate, endDate, jobDescription);
    }

    private Education addEducation() {
        String institution;
        String degree;
        String graduationDate;
        System.out.println("\n-------- Education --------");
        System.out.println("Please enter the name of the institution: ");
        institution = keyboard.nextLine();
        System.out.println("Enter the name of your degree: ");
        degree = keyboard.nextLine();
        System.out.println("Please enter your graduation date in the form MM/DD/YYYY: ");
        graduationDate = keyboard.nextLine();
        return new Education(institution, degree, graduationDate);
    }

    public void keywordSearch() {
        System.out.println("\n-------- Keyword Search --------");
        System.out.println("Please enter the keyword you would like to search for: ");
        displayInternships(keyboard.nextLine());
    }

    public void displayInternships(String keyword) {
        String input;
        System.out.println("\n-------- Internships --------");
        app.sortInternships();
        ArrayList<Internship> internshipsAll = app.getInternships();
        ArrayList<Internship> internshipsShown = new ArrayList<Internship>();
        for(Internship internship : internshipsAll) {
            if(internship.isAvailable() && internship.toString().toLowerCase().contains(keyword.toLowerCase())) {
                internshipsShown.add(internship);
            }
        }
        for(int i = 0; i < internshipsShown.size(); i++) {
            System.out.println(
                i + ". \n" +
                "\t" + internshipsShown.get(i).toString() + "\n"
            );
        }
        boolean exit = false;
        while(!exit) {
            System.out.println("\nWould you like to view internship details? (Y/N): ");
            input = keyboard.nextLine();
            if(input.equalsIgnoreCase("y")) {
                displayInternshipDetails(internshipsShown);
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

    public void changeInternshipSortMode() {
        String input;
        boolean exit = false;
        while(!exit) {
            System.out.println(
                "\n-------- Change Sort Mode --------\n" +
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

    public void displayInternshipDetails(ArrayList<Internship> internships) {
        boolean exit = false;
        while(!exit) {
            System.out.println("Enter the number of the internship you would like to view details of: ");
            int index = keyboard.nextInt();
            if(index < 0 || index >= internships.size()) {
                inputError();
            }
            else {
                applyToInternship(internships.get(index));
                exit = true;
            }
        }
    }

    public void applyToInternship(Internship internship) {
        String input;
        System.out.println(
            "\n-------- Details --------\n" +
            internship.details()
        );

        boolean exit = false;
        while(!exit) {
            System.out.println("\nWould you like to apply to this internship? (Y/N): ");
            input = keyboard.nextLine();
            if(input.equalsIgnoreCase("Y")) {
                ((Student)app.getUser()).apply(internship);
                exit = true;
            }
            else if(input.equalsIgnoreCase("N")) {
                exit = true;
            }
            else {
                inputError();
            }
        }
    }

    public void rateEmployer() {
        String input;
        System.out.println("\n-------- Rating an Employer --------");
        int rating = 0;
        Employer rated = null;

        boolean exit = false;
        while(!exit) {
            System.out.println("Which employer are you rating? Enter Q to cancel.");
            input = keyboard.nextLine();
            if(input.equalsIgnoreCase("q")) {
                return;
            }
            Account temp = app.searchAccount(input); //TODO this threw a null pointer i think
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

        Rating newRating = new Rating(rating, app.getUser());
        rated.addRating(newRating);
    }

    public void employerMenu() {
        String input;
        boolean exit = false;
        while (!exit) {
            System.out.println(
            "\n======== Main Menu ========\n" +
            "1. Display Applicants\n" +
            "2. Change Sort Mode\n" +
            "3. Post Internship\n" +
            "4. Rate Student\n" +
            "5. Log Out\n"
            );
            input = keyboard.nextLine();
            if(input.equals("1")) {
                displayApplicants();
            }
            else if(input.equals("2")) {
                changeStudentSortMode();
            }
            else if(input.equals("3")) {
                postInternship();
            }
            else if(input.equals("4")) {
                rateStudent();
            }
            else if(input.equals("5")) {
                exit = true;
            }
            else {
                inputError();
            }
        }
    }

    public void rateStudent() {
        String input;
        System.out.println("\n-------- Rating a Student --------");
        int rating = 0;
        Student rated = null;

        boolean exit = false;
        while(!exit) {
            System.out.println("Which student are you rating? Enter Q to cancel.");
            input = keyboard.nextLine();
            if(input.equalsIgnoreCase("q")) {
                return;
            }
            Account temp = app.searchAccount(input); //TODO this also threw one
            if(temp.getPermissions() == 0) {
                rated = (Student)temp;
                exit = true;
            }
            else {
                System.out.println("Could not find a student with that name.");
            }
        }
        while(!exit) {
            System.out.println("How would you rate this student on a scale of 1 to 5?");
            rating = keyboard.nextInt();
            keyboard.nextLine();
            if(0 < rating && rating <= 5) {
                exit = true;
            }
            else {
                inputError();
            }
        }

        Rating newRating = new Rating(rating, app.getUser());
        rated.addRating(newRating);
    }

    public void displayApplicants() {
        String input;
        
        System.out.println("-------- Applicants --------");
        ArrayList<Internship> myInternships = app.getMyInternships();
        ArrayList<Student> applicants;
        int count = 0;
        for(int i = 0; i < myInternships.size(); i++) {
            System.out.println("For internship \"" + myInternships.get(i).getName() + "\":\n");
            applicants = myInternships.get(i).getApplicants();
            for(int j = 0; j < applicants.size(); j++) {
                count++;
                System.out.println(count + ". ");
                System.out.println("\t" + applicants.get(j).toString());
            }
        }

        boolean exit = false;
        while(!exit) {
            System.out.println("Would you like to display applicant details? (Y/N): ");
            input = keyboard.nextLine();
            if(input.equals("Y")) {
                displayApplicantDetails(myInternships);
                exit = true;
            }
            else if(input.equals("N")) {
                exit = true;
            }
            else {
                inputError();
            }
        }
    }

    public void displayApplicantDetails(ArrayList<Internship> internships) {
        String input;
        
        ArrayList<Student> applicants = new ArrayList<Student>();
        for(Internship internship : internships) {
            for(Student applicant : internship.getApplicants()) {
                applicants.add(applicant);
            }
        }
        boolean exit = false;
        while(!exit) {
            System.out.println("Please enter the number of the applicant you would like to view details of: ");
            int index = keyboard.nextInt();
            if(index < 0 || index >= applicants.size()) {
                inputError();
            }
            else {
                System.out.println(
                    "-------- Details --------\n" +
                    applicants.get(index).details()
                );
                while(!exit) {
                    System.out.println("Type \"Q\" to exit");
                    input = keyboard.nextLine();
                    if(input.equalsIgnoreCase("Q")) {
                        exit = true;
                    }
                    else {
                        inputError();
                    }
                }
            }
        }
    }

    public void changeStudentSortMode() {
        String input;
        
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
        String input;

        String name = "";
        double pay = 0;
        String description = "";
        int timePeriod = 0;
        String skillRequirements = "";
        String onSiteString = "N/A";
        String startDate = "";
        boolean onSite = true;




        boolean exit = false;

        while(!exit) {
            System.out.println(
                "-------- Post an Internship --------\n" +
                "Job Title: " + name + "\n" +
                "Pay: " + pay + "\n" +
                "Description: " + description + "\n" +
                "Length (in months): " + timePeriod + "\n" +
                "Skill Requirements: " + skillRequirements + "\n" +
                "On Site: " + onSiteString + "\n" +
                "Start Date: " + startDate + "\n"
            );

            System.out.println(
                "1. Enter job title\n" +
                "2. Enter pay\n" +
                "3. Write description\n" +
                "4. Enter length\n" +
                "5. Add skill requirement\n" +
                "6. Change if internship is on site\n" +
                "7. Set start date\n" +
                "8. Quit\n" +
                "9. Save and quit\n"
            );

            input = keyboard.nextLine();
            if(input.equals("1")) {
                name = enterJobTitle();
            }
            else if(input.equals("2")) {
                pay = enterPay();
            }
            else if(input.equals("3")) {
                description = writeDescription();
            }
            else if(input.equals("4")) {
                timePeriod = enterLength();
            }
            else if(input.equals("5")) {
                skillRequirements += " " +addSkillRequirement();
            }
            else if(input.equals("6")) {
                onSite = changeOnSite();
                if(onSite) {
                    onSiteString = "Yes";
                }
                else {
                    onSiteString = "No";
                }
            }
            else if(input.equals("7")) {
                startDate = setStartDate();
            }
            else if(input.equals("8")) {
                exit = true;
            }
            else if(input.equals("9")) {
                Internship internship = new Internship((Employer)app.getUser(), name, pay, description, timePeriod, skillRequirements, onSite, startDate);
                app.addInternship(internship);
                exit = true;
            }
            else {
                inputError();
            }
        }
    }

    public String enterJobTitle() {
        String input;
        System.out.println(
            "-------- Enter a Job Title --------\n" +
            "Please enter the job title: \n"
        );
        input = keyboard.nextLine();
        return input;
    }

    public double enterPay() {
        System.out.println(
            "-------- Enter Pay --------\n" +
            "Enter how much the position pays in dollars per hour: \n"
        );
        double result = keyboard.nextDouble();
        keyboard.nextLine();
        return result;
    }

    public String writeDescription() {
        System.out.println(
            "-------- Description --------\n" +
            "Please write a brief description of the internship: "
        );
        return keyboard.nextLine();
    }

    public int enterLength() {

        System.out.println(
            "-------- Length of Internship --------\n" + 
            "Please enter the length of the internship in months: "
        );
        int result = keyboard.nextInt();
        keyboard.nextLine();
        return result;
    }

    public String addSkillRequirement() {
        String input;
        System.out.println("-------- Skill Requirement --------\n" + "Please enter a skill requirement");

        input = keyboard.nextLine();
        return input;
    }

    public boolean changeOnSite() {
        String input;
        System.out.println(
            "-------- Enter On-Site --------\n" +
            "Please enter whether or not the job is on site (Y/N): "
        );

        boolean onSite = true;
        boolean exit = false;
        while (!exit) {
            input = keyboard.nextLine();
            if (input.equalsIgnoreCase("y")) {
                onSite = true;
                exit = true;
            }
            else if (input.equalsIgnoreCase("n")) {
                onSite = false;
                exit = true;
            }
            else {
                inputError();
            }
        }
        return onSite;
    }

    public String setStartDate() {
        String input;
        System.out.println(
            "-------- Enter a Start Date --------\n" +
            "Please enter the start date in the form MM/DD/YYYY: \n"
        );
        input = keyboard.nextLine();
        return input;
    }
    
    public void adminMenu() {
        String input;
        boolean exit = false;
        while(!exit) {
            System.out.println(
                "======== Main Menu ========\n" +
                "1. Display all Accounts\n" +
                "2. Display all Internships\n" +
                "3. Filter Accounts by Keyword\n" +
                "4. Filter Internships by Keyword\n" +
                "5. Create a New Admin Account\n" +
                "6. Log Out"
            );
            input = keyboard.nextLine();
            if(input.equals("1")) {
                displayAccounts("");
            }
            else if(input.equals("2")) {
                displayInternshipsAdmin("");
            }
            else if(input.equals("3")) {
                accountKeywordSearch();
            }
            else if(input.equals("4")) {
                keywordSearchAdmin();
            }
            else if(input.equals("5")) {
                createAdminAccount();
            }
            else if(input.equals("6")) {
                exit = true;
            }
            else {
                inputError();
            }
        }
    }

    public void displayAccounts(String keyword) {
        String input;
        ArrayList<Account> accountsAll = app.getAccounts();
        ArrayList<Account> accountsShown = new ArrayList<Account>();
        for(Account account : accountsAll) {
            if(account.details().toLowerCase().contains(keyword.toLowerCase())) {
                accountsShown.add(account);
            }
        }
        for(int i = 0; i < accountsShown.size(); i++) {
            System.out.println(i + ".");
            System.out.println(accountsShown.get(i).toString());
        }
        boolean exit = false;
        while(!exit) {
            System.out.println("Would you like to inspect account details? (Y/N): ");
            input = keyboard.nextLine();
            if(input.equalsIgnoreCase("y")) {
                accountDetails(accountsShown);
            }
            else if(input.equalsIgnoreCase("n")) {
                exit = true;
            }
            else {
                inputError();
            }
        }
    }

    public void accountDetails(ArrayList<Account> accounts) {
        int index;
        boolean exit = false;
        while(!exit) {
            System.out.println("Please enter the number of the account you would like to inspect: ");
            index = keyboard.nextInt();
            keyboard.nextLine();
            if(index < 0 || index >= accounts.size()) {
                inputError();
            }
            else {
                Account account = accounts.get(index);
                System.out.println("-------- Details --------");
                System.out.println(account.details());
                System.out.println("Would you like to remove this account? (Y/N): ");
                String input = keyboard.nextLine();
                if(input.equalsIgnoreCase("y")) {
                    app.removeAccount(account);
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
    }

    public void displayInternshipsAdmin(String keyword) {
        String input;
        ArrayList<Internship> internshipsAll = app.getInternships();
        ArrayList<Internship> internshipsShown = new ArrayList<Internship>();
        for(Internship internship : internshipsAll) {
            if(internship.details().toLowerCase().contains(keyword.toLowerCase())) {
                internshipsShown.add(internship);
            }
        }
        for(int i = 0; i < internshipsShown.size(); i++) {
            System.out.println(i + ".");
            System.out.println(internshipsShown.get(i).toString());
        }
        boolean exit = false;
        while(!exit) {
            System.out.println("Would you like to inspect internship details? (Y/N): ");
            input = keyboard.nextLine();
            if(input.equalsIgnoreCase("y")) {
                internshipDetailsAdmin(internshipsShown);
            }
            else if(input.equalsIgnoreCase("n")) {
                exit = true;
            }
            else {
                inputError();
            }
        }
    }

    public void internshipDetailsAdmin(ArrayList<Internship> internships) {
        int index;
        boolean exit = false;
        while(!exit) {
            System.out.println("Please enter the number of the internship you would like to inspect: ");
            index = keyboard.nextInt();
            keyboard.nextLine();
            if(index < 0 || index >= internships.size()) {
                inputError();
            }
            else {
                Internship internship = internships.get(index);
                System.out.println("-------- Details --------");
                System.out.println(internship.details());
                System.out.println("Would you like to remove this internship? (Y/N): ");
                String input = keyboard.nextLine();
                if(input.equalsIgnoreCase("y")) {
                    app.removeInternship(internship);
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
    }

    public void accountKeywordSearch() {
        String input;
        System.out.println("-------- Keyword Filter --------\n" +
        "Please enter the keyword you would like to filter accounts by: ");
        input = keyboard.nextLine();
        displayAccounts(input);
    }

    public void keywordSearchAdmin() {
        String input;
        System.out.println("-------- Keyword Filter --------\n" +
        "Please enter the keyword you would like to filter internships by: ");
        input = keyboard.nextLine();
        displayInternshipsAdmin(input);
    }

    public void createAdminAccount() {
        String name = "";
        String email = "";
        String password = "";
        System.out.println("Please enter the new admin's name: ");
        name = keyboard.nextLine();
        System.out.println("Please enter the new admin's email: ");
        email = keyboard.nextLine();
        boolean match = false;
        while(!match) {
            System.out.println("Please enter the new admin's password: ");
            password = keyboard.nextLine();
            System.out.println("Please confirm the new admin's password: ");
            if(password.equals(keyboard.nextLine())) {
                match = true;
            }
            else {
                System.out.println("Password mismatch.");
            }
        }
        Admin admin = new Admin(name, email, password);
        app.addAccount(admin);
        System.out.println("Admin account created");
    }
    
}