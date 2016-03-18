package com.problem.thumbtack;

public abstract class AbstractInputCommand implements ICommand {

    protected final Database database;
    protected final String[] command;

    public AbstractInputCommand(Database database, String[] command) {
        this.database = database;
        this.command = command;
    }

    @Override
    public final void execute() {
        if(null == command || command.length < 2) {
            showInvalidInputError();
        } else {
            executeCommand();
        }
    }

    public void showInvalidInputError() {
        System.out.println("Invalid Input. Please try again.");
    }
    protected abstract void executeCommand();
}
