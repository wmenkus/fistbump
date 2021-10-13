/**
 * The command that sings "I Don't Know"
 * @author: Cameron Delk
 */

package command; //I added this

public class IDontKnowCommand implements Command{
    private MilitaryCadence cadence;
    
    /**
     * The parameterized constructor for IDontKnowCommand.
     * @param cadence is set equal to this.cadence.
     */
    public IDontKnowCommand(MilitaryCadence cadence) {
        this.cadence = cadence;
    }
    /**
     * An implementation of Command's execute method.
     * calls the singIDontKnow method via the cadence variable.
     */
    public void execute() {
        cadence.singIDontKnow();
    }
}
