package com.reagroup.robot.simulator.command.model;

import com.reagroup.robot.simulator.constants.CommandID;
import com.reagroup.robot.simulator.constants.Compass;
import com.reagroup.robot.simulator.state.model.State;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class represents the rotate command, it will receive in a state and if the state is active and the command passed into the
 * constructor is support it will execute the command when invoked and return a new state, otherwise the command will be
 * ignored and the passed in state will be returned.
 *
 * Supported commands for the are LEFT and RIGHT.
 */
public class RotateCommand implements Command {

  private static final Logger LOG = LoggerFactory.getLogger(RotateCommand.class);

  private CommandID commandID;

  public RotateCommand(final CommandID commandID) {
    this.commandID = commandID;
  }

  @Override
  public State execute(final State state) {

    Compass compass = state.getCompass();

    final boolean isSupportedCommand = (CommandID.LEFT.equals(commandID) || CommandID.RIGHT.equals(commandID));

    if (state.isActive() && isSupportedCommand) {
      LOG.debug("State {}", state);

      switch (compass) {
        case EAST: {
          compass = (CommandID.LEFT.equals(commandID)) ? Compass.NORTH : Compass.SOUTH;
          break;
        }
        case WEST: {
          compass = (CommandID.LEFT.equals(commandID)) ? Compass.SOUTH : Compass.NORTH;
          break;
        }
        case NORTH: {
          compass = (CommandID.LEFT.equals(commandID)) ? Compass.WEST : Compass.EAST;
          break;
        }
        case SOUTH: {
          compass = (CommandID.LEFT.equals(commandID)) ? Compass.EAST : Compass.WEST;
          break;
        }
      }
    }

    return new State(state.isActive(), state.getX(), state.getY(), compass);
  }

  @Override
  public String toString() {
    return "RotateCommand{" +
            "commandID=" + commandID +
            '}';
  }
}
