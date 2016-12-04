package com.reagroup.robot.simulator.command.model;

import com.reagroup.robot.simulator.state.model.State;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class represents the report command, it will receive in a state and if the state is active it will execute the command
 * when invoked and return the passed in state.
 *
 * Executing this will simply log out the x,y and compass of the state passed in.
 */
public class ReportCommand implements Command {

  private static final Logger LOG = LoggerFactory.getLogger(ReportCommand.class);

  @Override
  public State execute(final State state) {

    if (state.isActive()) {
      LOG.debug("State {}", state);

      LOG.info("{},{},{}", state.getX(), state.getY(), state.getCompass().name());
    }

    return state;
  }

  @Override
  public String toString() {
    return "ReportCommand{}";
  }
}
