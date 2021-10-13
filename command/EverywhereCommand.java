import command.MilitaryCadence;

public class EverywhereCommand implements Command{
    private MilitaryCadence cadence;

    public EverywhereCommand(MilitaryCadence cadence){
        this.cadence = cadence;
    }

    public void execute(){
        cadence.singEverywhereWeGo();
    }
}
