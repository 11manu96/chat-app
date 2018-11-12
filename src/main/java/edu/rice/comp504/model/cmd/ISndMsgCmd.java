package edu.rice.comp504.model.cmd;

/**
 * A command interface that is executed by chat rooms and users.
 */
public interface ISndMsgCmd {

    /**
     * Execute the command by the receiver (context).
     * @param context receiver that will execute the command
     */
    public void execute(Object context);
}
