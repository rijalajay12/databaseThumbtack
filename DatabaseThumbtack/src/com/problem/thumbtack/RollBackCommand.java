package com.problem.thumbtack;

public class RollBackCommand implements ICommand {

    private final Database database;

    public RollBackCommand(Database database) {
        this.database = database;
    }

    @Override
    public void execute() {
        database.rollback();
    }

    @Override
    public void undo() {

    }
}
