package com.reagroup.robot.simulator.command.factory;

import com.reagroup.robot.simulator.command.model.Command;
import com.reagroup.robot.simulator.command.model.MoveCommand;
import com.reagroup.robot.simulator.command.model.PlaceCommand;
import com.reagroup.robot.simulator.command.model.ReportCommand;
import com.reagroup.robot.simulator.command.model.RotateCommand;
import com.reagroup.robot.simulator.constants.CommandID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class is a factory to create a command.
 *
 * Based on the input received as a String representation, output a valid Command object.
 *
 * If the command received in not a recognised command, then the command returned will be null and an error logged.
 */
public class CommandFactory {

  private static final Logger LOG = LoggerFactory.getLogger(CommandFactory.class);

  private static final String SPACE_SEPARATOR = " ";

  private static final String COMMA_SEPARATOR = ",";

  public Command createCommand(final String line) {
    Command command = null;

    final String[] tokens = line.split(SPACE_SEPARATOR);

    LOG.debug("Command {}", tokens[0]);

    try {
      final CommandID commandID = CommandID.valueOf(tokens[0]);

      switch (commandID) {
        case PLACE: {
          command = new PlaceCommand(tokens[1].split(COMMA_SEPARATOR));
          break;
        }
        case MOVE: {
          command = new MoveCommand();
          break;
        }
        case LEFT:
        case RIGHT: {
          command = new RotateCommand(commandID);
          break;
        }
        case REPORT: {
          command = new ReportCommand();
          break;
        }
      }
    } catch (Exception e) {
      LOG.error("Unsupported Command");
    }

    return command;
  }
}
