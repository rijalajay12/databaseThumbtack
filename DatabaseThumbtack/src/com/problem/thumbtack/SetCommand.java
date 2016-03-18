package com.problem.thumbtack;

public class SetCommand extends AbstractInputCommand {

    public SetCommand(Database database, String[] command) {
        super(database, command);
    }

    @Override
    public void executeCommand() {
        if(command.length <3) {
            showInvalidInputError();
        } else {
            database.set(this, command[1], command[2]);
        }
    }

    @Override
    public void undo() {
        database.undoSet(command[1]);
    }
    
}
