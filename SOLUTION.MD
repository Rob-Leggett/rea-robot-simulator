Solution
==========

When tackling this problem statement, I wanted to ensure that I was able to deliver a robust solution, that solves the current problem but allows for enhancements.
 
I ensured that all classes developed were completely testable, and to ensure quality developed tests that covered all complexities in the code.  I have added unit and integration tests to ensure that the individual aspects of the code are high quality as well as various scenarios to ensure that the code will work as expected even with invalid inputs (edge cases).

The key aspect to this solution is the State that is used through the solution.

***State***

The state has the following information:
1. is it active - used to determine which commands to ignore and which to execute.
2. x position - used to track where the robot is along the width of the table.
3. y position - used to track where the robot is along the height of the table.
4. compass - used to track which direction the robot is facing.

There are 3 main packages in this solution:

- Table

The table is oblivious to the state, all the table knows about is its height and width as well as being able to determine based on a position provided if it will be on the table or not.

- Robot

The robot has a state, and is also aware of the table and command it is required to execute against.  The robot receives the table which it will perform the command against, the state is passed into each command that it executes against and in-turn a new state is returned after execution.  Only if the state is active and the command executed is determined to ensure the robot remains on the table is the robot state updated.  Upon creation of the robot it creates an initial state which is passed into each command until updated with a new valid state.  

I believe it the responsibility of the robot to know its current state as well as which commands it can execute and which it cannot, and if to ignore the move if the command will place the robot in danger, this solution has been designed around that believe.

The initial state of the robot is inactive.

- Command

The command knows about the state and after execution of the command returns a new state.

There are a total of 4 valid commands:

1. Place Command - This command will always be executed.  It the data received for this command is invalid the state will be inactive and returned, otherwise the state will be set to active and returned.  This command is responsible for setting the state to active initially as well as setting the initial position and direction.
2. Move Command - This command will be ignored until that state received is active.
3. Rotate Command - This command is created when the input LEFT or RIGHT is received.  It will be ignored until the state received is active.  
4. Report Command - This command will be ignored until the state received is active.  The state returned will match the state received.

***Configuration***

Configuration was added to this solution to data that we do not want hard coded into the application, in our case this was the table height and width.  The configuration has been setup to all retrieval of all configuration or partial configuration based on a selector base.

***Logging***

- Error - This logging is used when an error occurs

- Info - This logging occurs for producing the expected output via the Report Command

- Debug - This exists through the code to give required output in varies important parts of the code, it is only displayed when running tests of if logback is configured to have the log level to DEBUG

***Error Handling***

All errors are logged with error and ignored, for instance if a command provided has an error, it will not be executed and but logged and then next command will be processed until all commands have been processed.

The streams that read in the data do not validate the data, data validation is performed when used and ignored appropriately.

***Assumptions***

1. The place command can be issued more then 1 time in a set of commands, doing this will move to the new location or reset the robot state if the place command puts the robot off the table.
2. While this solution does not have dependency injection it does have for each class requiring other classes, them passed in via the constructor, this allows for a robust solution and well as easy testing allowing mock classes to be passed in.