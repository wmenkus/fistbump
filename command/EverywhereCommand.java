/**
 * @author Brian White
 */
package command;
/**
 * Contains an execute method to "sing" "Everywhere We Go"
 */
public class EverywhereCommand implements Command{
    private MilitaryCadence cadence;
    /**
     * EverywhereCommand constructor
     * @param cadence Initializes cadence
     */
    public EverywhereCommand(MilitaryCadence cadence){
        this.cadence = cadence;
    }
    /**
     * Calls a  method in MilitaryCadence to print out the lyrics to "Everywhere We Go"
     */
    public void execute(){
        cadence.singEverywhereWeGo();
    }
}