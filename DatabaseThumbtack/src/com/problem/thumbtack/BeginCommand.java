package com.problem.thumbtack;

public class BeginCommand implements ICommand {

    private final Database database;

    public BeginCommand(Database database) {
        this.database = database;
    }

    @Override
    public void execute() {
        database.begin();
    }

    @Override
    public void undo() {

    }
}
