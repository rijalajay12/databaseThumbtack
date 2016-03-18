package com.problem.thumbtack;

public class UnsetCommand extends AbstractInputCommand {
    
    public UnsetCommand(Database database, String[] command) {
        super(database, command);
    }

    @Override
    public void executeCommand() {
        database.unset(this, command[1]);
    }

    @Override
    public void undo() {
        database.undoUnSet(command[1]);
    }
    
}
