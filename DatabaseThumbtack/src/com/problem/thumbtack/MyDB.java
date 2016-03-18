package com.problem.thumbtack;

import java.util.Scanner;

public class MyDB {

    public static void main(String[] args) {

        Database database = new Database();

        while (true) {

            Scanner in = new Scanner(System.in);
            String inLine = in.nextLine().trim();

            ICommand command = CommandFactory.getCommand(database, inLine);
            if(null != command) {
                command.execute();
            }
            else {
                System.out.println("Illegal Command input... \n"
                        + "Please try again or input 'end' to end the program");
            }
        }
    }
}
