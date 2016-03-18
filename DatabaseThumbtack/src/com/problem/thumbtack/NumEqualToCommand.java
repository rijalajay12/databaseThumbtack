package com.problem.thumbtack;

class NumEqualToCommand extends AbstractInputCommand {

    public NumEqualToCommand(Database database, String[] command) {
        super(database, command);
    }

    @Override
    public void executeCommand() {
        database.numEqualTo(command[1]);
    }

    @Override
    public void undo() {
    }
    
}
