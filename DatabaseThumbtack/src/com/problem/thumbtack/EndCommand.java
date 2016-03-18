package com.problem.thumbtack;

public class EndCommand implements ICommand {

    @Override
    public void execute() {
        System.out.println("Terminated");
        System.exit(0);
    }

    @Override
    public void undo() {

    }
}
