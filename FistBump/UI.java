/**
 * @author Walker Menkus
 */

package FistBump;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * User Interface for FistBump. Also handles a lot of the program logic.
 */
public class UI {
    private Facade app;
    private Scanner keyboard;

    /**
     * In this implementation, UI is on a higher level than the Facade. Calls to the Facade
     * go through the UI, so UI must have a Facade. This method is the only constructor for the UI;
     * it gets its Facade from the parameter (passed directly from the Driver) and initializes the
     * Scanner that will be used for user input.
     * @param app
     */
    public UI(Facade app) {
        this.app = app;
        keyboard = new Scanner(System.in);
    }

    /**
     * Displays a message to the user that their input is not what the program
     * has asked of them. This is used in almost every method that calls for user
     * input.
     */
    private void inputError() {
        System.out.println("Incorrect input.");
    }

    /**
     * The main loop of FistBump. Uses the call stack to create the
     * branching paths of the UI. Displays the initial screen and asks the user
     * if they would like to log in, create an account, or exit. PROGRAM ONLY SAVES TO DATABASE ON EXIT
     * THROUGH THIS METHOD.
     */
    public void start() {
        String input;
        boolean exit = false;
        while (!exit) {
            loginScreen();
            input = keyboard.nextLine();
            if(input.equals("1")) {
                login();
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

    /**
     * Method that shorthands the visual representation of the login screen.
     */
    public void loginScreen() {
        System.out.println (
            "\n======== FistBump ========\n" + 
            "1. Log In \n" +
            "2. Create an Account\n" +
            "3. Exit\n"
        );
    }

    /**
     * Asks the user to enter their email and password, then passes that
     * information to the Facade to verify. If correct, logs the user in.
     * If incorrect, prompts them for email and password again. Once logged in,
     * directs them to the correct menu based on their account type.
     */
    public void login() {
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
        else if(app.getPermissions() == 1) {
            employerMenu();
        }
        else if(app.getPermissions() == 2) {
            adminMenu();
        }
    }

    /**
     * Asks the user what kind of account they are creating and directs them
     * to the correct account creation method. Only keeps exit false if input is
     * incorrect; this is not a screen the user should be able to get back to except through
     * the login menu.
     */
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

    /**
     * Creates a Student account by first initializing all of the variables that make up
     * a Student, then setting the values of those variables one by one. Double checks the
     * user's password. Once all variables are set, passes them to Student's parameterized
     * constructor, adds the Student to the app, and logs the Student in, taking them
     * directly to the Student main menu.
     */
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

    /**
     * Creates an Employer account by first initializing all of the variables that make up
     * an Employer, then setting the values of those variables one by one. Double checks the
     * user's password. Once all variables are set, passes them to Employer's parameterized
     * constructor, adds the Employer to the app, and logs the Employer in, taking them
     * directly to the Employer main menu.
     */
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

    /**
     * Gives the user the option to create a resume, display all internships,
     * change how internships are sorted, search internships by a keyword, rate an employer,
     * print their resume to a text file, or log out.
     */
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
                app.logout();
                exit = true;
            }
            else {
                inputError();
            }
        }
    }

    /**
     * Creates a resume in a similar way to creating an account, by initializing all variables
     * and setting them one by one. GPA is a single number, whereas skills will be concatenated
     * every time a new skill is added. When the user selects save and quit, the Resume is created
     * and then added to the user's Resume ArrayList.
     */
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
                "6. Save and Quit\n"
            );

            input = keyboard.nextLine();
            if(input.equals("1")) {
                gpa = enterGPA();
            }
            else if(input.equals("2")) {
                skills += "\n\t" + addSkill();
            }
            else if(input.equals("3")) {
                Employment fresh = addEmployment();
                pastEmployment.add(fresh);
                employmentString += fresh.toString();
            }
            else if(input.equals("4")) {
                Education fresh = addEducation();
                education.add(fresh);
                educationString += fresh.toString() + "\n";
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

    /**
     * Prompts the user to enter their GPA. Will throw an exception if the
     * user doesn't input a number. Does not error check GPA.
     * @return the GPA, to set the gpa variable in createResume().
     */
    private double enterGPA() {
        System.out.println(
            "\n-------- Entering your GPA --------\n" +
            "Please enter your GPA: "
        );
        double result = keyboard.nextDouble();
        keyboard.nextLine();
        return result;
    }

    /**
     * Prompts the user to add a skill to their list of skills.
     * @return the String to be concatenated to the end of the list of skills
     */
    private String addSkill() {
        System.out.println(
            "\n-------- Entering your Skills --------\n" +
            "Please enter a skill: "
        );
        return keyboard.nextLine();
    }

    /**
     * @return
     */
    private Employment addEmployment() {
        String jobTitle;
        String companyName;
        String jobType;
        String startDate;
        String endDate;
        ArrayList<String> descriptions = new ArrayList<String>();
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
        boolean exit1 = false;
        while(!exit1) {
            System.out.println("Enter a description of what you did: ");
            descriptions.add(keyboard.nextLine());
            boolean exit2 = false;
            while(!exit2) {
                System.out.println("Would you like to add another description? (Y/N): ");
                String input = keyboard.nextLine();
                if(input.equalsIgnoreCase("y")) {
                    exit2 = true;
                }
                else if(input.equalsIgnoreCase("N")) {
                    exit1 = true;
                    exit2 = true;
                }
                else {
                    inputError();
                }
            }
        }
        return new Employment(jobTitle, companyName, jobType, startDate, endDate, descriptions);
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
            if(internship.isAvailable() && internship.details().toLowerCase().contains(keyword.toLowerCase())) {
                internshipsShown.add(internship);
            }
        }
        for(int i = 0; i < internshipsShown.size(); i++) {
            System.out.println(
                (i + 1) + ". \n" +
                internshipsShown.get(i).toString() + "\n"
            );
        }
        boolean exit = false;
        while(!exit) {
            System.out.println("Would you like to view internship details? (Y/N): ");
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
            int index = keyboard.nextInt() - 1;
            keyboard.nextLine();
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
            Account temp = app.searchAccount(input);
            if(temp != null && temp.getPermissions() == 1) {
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
            Account temp = app.searchAccount(input);
            if(temp != null && temp.getPermissions() == 0) {
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
        
        System.out.println("\n-------- Applicants --------");
        ArrayList<Internship> myInternships = app.getMyInternships();
        ArrayList<Student> applicants;
        int count = 0;
        for(int i = 0; i < myInternships.size(); i++) {
            System.out.println("For internship \"" + myInternships.get(i).getName() + "\":");
            applicants = myInternships.get(i).getApplicants();
            for(int j = 0; j < applicants.size(); j++) {
                count++;
                System.out.println(count + ". ");
                System.out.println(applicants.get(j).toString());
            }
        }

        boolean exit = false;
        while(!exit) {
            System.out.println("Would you like to display applicant details? (Y/N): ");
            input = keyboard.nextLine();
            if(input.equalsIgnoreCase("Y")) {
                displayApplicantDetails(myInternships);
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
            int index = keyboard.nextInt() - 1;
            keyboard.nextLine();
            if(index < 0 || index >= applicants.size()) {
                inputError();
            }
            else {
                System.out.println(
                    "\n-------- Details --------\n" +
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
                "\n-------- Change Sort Mode --------\n" +
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
                "\n-------- Post an Internship --------\n" +
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

    private String enterJobTitle() {
        String input;
        System.out.println(
            "\n-------- Enter a Job Title --------\n" +
            "Please enter the job title: \n"
        );
        input = keyboard.nextLine();
        return input;
    }

    private double enterPay() {
        System.out.println(
            "\n-------- Enter Pay --------\n" +
            "Enter how much the position pays in dollars per hour: \n"
        );
        double result = keyboard.nextDouble();
        keyboard.nextLine();
        return result;
    }

    private String writeDescription() {
        System.out.println(
            "\n-------- Description --------\n" +
            "Please write a brief description of the internship: "
        );
        return keyboard.nextLine();
    }

    private int enterLength() {

        System.out.println(
            "\n-------- Length of Internship --------\n" + 
            "Please enter the length of the internship in months: "
        );
        int result = keyboard.nextInt();
        keyboard.nextLine();
        return result;
    }

    private String addSkillRequirement() {
        String input;
        System.out.println("\n-------- Skill Requirements --------\n" + "Please enter a skill requirement");

        input = keyboard.nextLine();
        return input;
    }

    private boolean changeOnSite() {
        String input;
        System.out.println(
            "\n-------- Enter On-Site --------\n" +
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

    private String setStartDate() {
        String input;
        System.out.println(
            "\n-------- Enter a Start Date --------\n" +
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
                "\n======== Main Menu ========\n" +
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
                System.out.println("\n-------- Details --------");
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
                System.out.println("\n-------- Details --------");
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
        System.out.println("\n-------- Keyword Filter --------\n" +
        "Please enter the keyword you would like to filter accounts by: ");
        input = keyboard.nextLine();
        displayAccounts(input);
    }

    public void keywordSearchAdmin() {
        String input;
        System.out.println("\n-------- Keyword Filter --------\n" +
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