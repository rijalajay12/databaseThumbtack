# databaseThumbtack
Simple Database Challenge Thumbtack

The main file is “MyDB.java” which can be run interactively i.e my program expect input from standard input (stdin). 

For have created Command Factory class which gives me concrete implementation of ICommand . The main resource “Database.java” contains the in memory hash-maps of indexes and variables. Also, it contains the stacks of command for transactions and hash-map of variables unset during transaction, which might be required in case someone rollback. 
Apart from that the program logic and flow is obvious.

Some of the challenging parts that I tackled with while developing this programs were -

1. Designing the command so that it should be flexible enough to add new more command. 
2. Tackling with layers of transactions: Created stacks for each transaction which contains the command state and on rollback, undo will be executed for each of the commands. Specially for “SET” and “UNSET”, it was a bit tricky as we need to store the previous states of variable.
