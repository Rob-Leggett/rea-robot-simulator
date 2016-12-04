package com.reagroup.robot.simulator.command.model;

import com.reagroup.robot.simulator.state.model.State;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class represents the move command, it will receive in a state and if the state is active it will execute the command
 * when invoked and return a new state, otherwise the command will be ignored and the passed in state will be returned.
 */
public class MoveCommand implements Command {

  private static final Logger LOG = LoggerFactory.getLogger(MoveCommand.class);

  @Override
  public State execute(final State state) {
    int x = state.getX();
    int y = state.getY();

    if (state.isActive()) {
      LOG.debug("State {}", state);

      switch (state.getCompass()) {
        case EAST: {
          x++;
          break;
        }
        case WEST: {
          x--;
          break;
        }
        case NORTH: {
          y++;
          break;
        }
        case SOUTH: {
          y--;
          break;
        }
      }
    }

    return new State(state.isActive(), x, y, state.getCompass());
  }

  @Override
  public String toString() {
    return "MoveCommand{}";
  }
}
