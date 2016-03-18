package com.problem.thumbtack;

public class CommandFactory {

    public static ICommand getCommand(Database database, String input) {
        String[] command = input.split("\\s+");
        if(command.length < 1) {
            return null;
        }
        switch (command[0].toUpperCase()) {
            case "SET":
                return new SetCommand(database, command);

            case "GET":
                return new GetCommand(database, command);

            case "UNSET":
                return new UnsetCommand(database, command);

            case "NUMEQUALTO":
                return new NumEqualToCommand(database, command);

            case "BEGIN":
                return new BeginCommand(database);

            case "COMMIT":
                return new CommitCommand(database);

            case "ROLLBACK":
                return new RollBackCommand(database);

            case "END":
                return new EndCommand();
        }
        return null;
    }

}
