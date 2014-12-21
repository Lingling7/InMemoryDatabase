In the Simple Database problem, you'll implement an in-memory database similar to Redis.
For simplicity's sake, instead of dealing with multiple clients and communicating over the network, your program will receive commands via standard input (stdin), and should write appropriate responses to standard output (stdout).

Data Commands

Your database should accept the following commands:

SET name value – Set the variable name to the value value. Neither variable names nor values will contain spaces.

GET name – Print out the value of the variable name, or NULL if that variable is not set.

UNSET name – Unset the variable name, making it just like that variable was never set.

NUMEQUALTO value – Print out the number of variables that are currently set tovalue. If no variables equal that value, print 0.

END – Exit the program. Your program will always receive this as its last command.

Commands will be fed to your program one at a time, with each command on its own line. Any output that your program generates should end with a newline character.


