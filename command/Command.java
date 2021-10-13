/**
     * The interface for the Commands.
     * @author: Cameron Delk
     */

package command; //I added this, I'm not sure if it's necessary but the code won't
//run on my machine or Brian's without a package declaration -Menkus

public interface Command {
    /**
     * The method that executes the commands.
     * Will be implemented by the other three commands.
     */
    public void execute();
}