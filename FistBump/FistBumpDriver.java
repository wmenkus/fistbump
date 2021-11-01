package FistBump;

import java.util.Scanner;

public class FistBumpDriver {
    /**
     * This implementation treats the Facade and UI as partners, not as one class
     * exclusively calling the other. Maybe bad practice?
     */
    public void run() {
        boolean exit = false;
        Scanner userInput = new Scanner(System.in);
        int input = 0;
        Facade app = new Facade();
        while(!exit) {
            UI.loginScreen();
            input = userInput.nextInt();
            userInput.nextLine();
            if(input == 1) {
                boolean match = false;
                while (!match) {

                    UI.userLogin();
                    String username = userInput.nextLine();
                    String password = userInput.nextLine();
                    if (!app.login(username, password)) {
                        UI.loginError();
                    }
                    else {
                        match = true;
                    }
                }
                if(app.getUserPermissions == 0) {
                    UI.displayStudentMenu;
                }



            }
        }
    }
}
