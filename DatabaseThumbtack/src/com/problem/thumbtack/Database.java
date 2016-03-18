package com.problem.thumbtack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Database {

    private final Map<String, Integer> index = new HashMap<>();
    private final Map<String, String> variable = new HashMap<>();
    private final Map<String, Stack<String>> unsetVariable = new HashMap<>();
    private Stack<ICommand> commands = null;
    private final Stack<Stack<ICommand>> commandsList = new Stack<>();

    public void set(ICommand command, String var, String value) {

        String existingValue = variable.get(var);

        if (null != commands) {
            Stack<String> pastValues = unsetVariable.get(var);
            if (null == pastValues) {
                pastValues = new Stack<>();
            }
            pastValues.push(existingValue);
            unsetVariable.put(var, pastValues);
            commands.push(command);
        }

        if (null != existingValue) {
            index.put(existingValue, index.get(existingValue) - 1);
        }
        variable.put(var, value);
        index.put(value,
                (null == index.get(value) ? 1
                        : (index.get(value) + 1)));
    }

    public void unset(ICommand command, String var) {

        String existingValue = variable.get(var);

        if (null != commands) {
            Stack<String> pastValues = unsetVariable.get(var);
            if (null == pastValues) {
                pastValues = new Stack<>();
            }
            pastValues.push(existingValue);
            unsetVariable.put(var, pastValues);
            commands.push(command);
        }

        if (null != existingValue) {
            variable.remove(var);
            index.put(existingValue, index.get(existingValue) - 1);
        }
    }

    public void undoSet(String var) {
        Stack<String> pastValues = unsetVariable.get(var);
        String existingValue = variable.get(var);
        index.put(existingValue, index.get(existingValue) - 1);
        if (pastValues.isEmpty()) {
            variable.remove(var);
        } else {
            String pastValue = pastValues.pop();
            if (null == pastValue){
                variable.remove(var);
            }
            else {
                variable.put(var, pastValue);
                index.put(pastValue, index.get(pastValue) + 1);
            }
        }
    }

    public void undoUnSet(String var) {
        Stack<String> pastValues = unsetVariable.get(var);
        if (!pastValues.isEmpty()) {
            String pastValue = pastValues.pop();
            if (null != pastValue){
                variable.put(var, pastValue);
                index.put(pastValue, index.get(pastValue) + 1);
            }
        }
    }

    public void numEqualTo(String value) {
        System.out.println((null == index.get(value))
                ? "0" : index.get(value));
    }

    public void begin() {
        commands = new Stack<>();
        commandsList.push(commands);
    }

    public void commit() {
        if (commandsList.isEmpty()) {
            System.out.println("No Transaction");
        }
        commandsList.clear();
        unsetVariable.clear();
    }

    public void get(String var) {
        System.out.println((null == variable.get(var))
                ? "NULL" : variable.get(var));
    }

    public void rollback() {
        if (commandsList.isEmpty()) {
            System.out.println("No Transaction");
        }
        else {
            Stack<ICommand> commandStack = commandsList.pop();
            if (commandStack.isEmpty()) {
                System.out.println("No Transaction");
            }
            while(!commandStack.isEmpty()){
                ICommand command = commandStack.pop();
                command.undo();
            }
        }
    }
}
