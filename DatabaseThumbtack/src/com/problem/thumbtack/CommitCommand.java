package com.problem.thumbtack;

public class CommitCommand implements ICommand {

    private final Database database;

    public CommitCommand(Database database) {
        this.database = database;
    }

    @Override
    public void execute() {
        database.commit();
    }

    @Override
    public void undo() {

    }
}
