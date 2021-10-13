import command.MilitaryCadence;

public class InArmyCommand implements Command{
    private MilitaryCadence cadence;

    public InArmyCommand(MilitaryCadence cadence){
        this.cadence = cadence;
    }

    public void execute(){
        cadence.singInArmy();
    }
}
