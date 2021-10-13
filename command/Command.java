/**
     * The interface for the Commands.
     * @author: Cameron Delk
     */
public interface Command {
    /**
     * The method that executes the commands.
     * Will be implemented by the other three commands.
     */
    public void execute();
}