package command;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
// Written By: Jaden Heinle

public class InputHandler {
private ArrayList<Commands> command = new ArrayList<Commands>();

    public InputHandler(MilitaryCadence cadence){
        command[0] = new IDontKnowCommand(cadence);
        command[1] = new InArmyCommand(cadence);
        command[2] = new EverywhereCommand(cadence);
    }

    public boolean playCadence(int num){
        if(num == 0){
            command[0].execute();
            return true;
        } else if(num == 1){
            command[1].execute();
            return true;
        }else if(num == 2){
            command[2].execute();
            return true;
        }
        return false;
    }
}