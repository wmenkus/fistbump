package command;
import java.util.ArrayList;
// Written By: Jaden Heinle

public class InputHandler {
    private ArrayList<Command> commands = new ArrayList<Command>();

    /**
     * @param MilitaryCadence
     * Sets up command arraylist
     */
    public InputHandler(MilitaryCadence cadence){
        commands.add(new IDontKnowCommand(cadence));
        commands.add(new InArmyCommand(cadence));
        commands.add(new EverywhereCommand(cadence));
    }

    /**
     * @param int num
     * executes the desired 
     */
    public boolean playCadence(int num){
        if(num == 0){
            commands.get(0).execute();
            return true;
        } else if(num == 1){
            commands.get(1).execute();
            return true;
        }else if(num == 2){
            commands.get(2).execute();
            return true;
        }
        return false;
    }
}