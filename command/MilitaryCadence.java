package command;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class MilitaryCadence {

    private Scanner reader;

    public MilitaryCadence() {}
    public void singIDontKnow() {
        try{
            File file = new File("command/idontknow.txt");
            reader = new Scanner(file);
            while (reader.hasNextLine()) {
                System.out.println(reader.nextLine());
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
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
    public void singEverywhereWeGo() {
        try{
            File file = new File("command/everywhere.txt");
            reader = new Scanner(file);
            while (reader.hasNextLine()) {
                System.out.println(reader.nextLine());
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
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
    public void singInArmy() {
        try{
            File file = new File("command/inarmy.txt");
            reader = new Scanner(file);
            while (reader.hasNextLine()) {
                System.out.println(reader.nextLine());
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
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