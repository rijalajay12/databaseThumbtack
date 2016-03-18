package com.problem.thumbtack;

class GetCommand extends AbstractInputCommand {

    public GetCommand(Database database, String[] command) {
        super(database, command);
    }

    @Override
    public void executeCommand() {
        database.get(command[1]);
    }

    @Override
    public void undo() {
    }
    
}
