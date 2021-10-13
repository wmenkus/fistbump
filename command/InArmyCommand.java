/**
 * @author Brian White
 */
package command;
/**
 * Contains an execute method to "sing" "In the Army"
 */
public class InArmyCommand implements Command{
    private MilitaryCadence cadence;
    /**
     * InArmyCommand constructor
     * @param cadence Initializes cadence
     */
    public InArmyCommand(MilitaryCadence cadence){
        this.cadence = cadence;
    }
    /**
     * Calls a method in MilitaryCadence to print out the lyrics to "In the Army"
     */
    public void execute(){
        cadence.singInArmy();
    }
}