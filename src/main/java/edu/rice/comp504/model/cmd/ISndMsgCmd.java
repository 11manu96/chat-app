package edu.rice.comp504.model.cmd;

/**
 * A command that needs to be excuted by chat rooms and users
 */
public interface ISndMsgCmd {

    /**
     * Execute the command by the receiver (context).
     * @param context  The receiver that will execute the command.
     */
    public void execute(Object context);
}
