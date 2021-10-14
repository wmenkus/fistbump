/**
 * @author Walker Menkus
 */

package command;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Contains methods to print out the lyrics to military cadences.
 */
public class MilitaryCadence {

    private Scanner reader;

    /**
     * Default constructor, does not instantiate the reader as that is done in the methods.
     */
    public MilitaryCadence() {}

    /**
     * Prints out the lyrics to "I Don't Know" with a 100 ms delay.
     */
    public void singIDontKnow() {
        try{
            //If this doesn't work, remove "team-last-minute/" from the file name
            //or change working directory
            File file = new File("team-last-minute/command/idontknow.txt");
            reader = new Scanner(file);
            while (reader.hasNextLine()) {
                System.out.println(reader.nextLine());
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                }
                catch (Exception e) {
                    System.out.println("a time error occurred");
                    e.printStackTrace();
                }
            }
        }
        catch (Exception e) {
            System.out.println("a file error occurred");
            e.printStackTrace();
        }
    }

    /**
     * Prints out the lyrics to "Everywhere We Go" with a 100 ms delay.
     */
    public void singEverywhereWeGo() {
        try{
            File file = new File("team-last-minute/command/everywhere.txt");
            reader = new Scanner(file);
            while (reader.hasNextLine()) {
                System.out.println(reader.nextLine());
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                }
                catch (Exception e) {
                    System.out.println("a time error occurred");
                    e.printStackTrace();
                }
            }
        }
        catch (Exception e) {
            System.out.println("a file error occurred");
            e.printStackTrace();
        }
    }

    /**
     * Prints out the lyrics to "In the Army" with a 100 ms delay.
     */
    public void singInArmy() {
        try{
            File file = new File("team-last-minute/command/inarmy.txt");
            reader = new Scanner(file);
            while (reader.hasNextLine()) {
                System.out.println(reader.nextLine());
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                }
                catch (Exception e) {
                    System.out.println("a time error occurred");
                    e.printStackTrace();
                }
            }
        }
        catch (Exception e) {
            System.out.println("a file error occurred");
            e.printStackTrace();
        }
    }
}