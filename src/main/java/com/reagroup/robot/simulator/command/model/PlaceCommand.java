package com.reagroup.robot.simulator.command.model;

import com.reagroup.robot.simulator.constants.Compass;
import com.reagroup.robot.simulator.state.model.State;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class represents the place command, when constructed this will create a state and store it internally, if the params
 * passed in are valid the params will be used to construct the state which is store internally and the state will be set to active,
 * otherwise the state will be set to inactive and the error will be logged.
 *
 * When invoked the state passed in is ignored and the internal state is returned.
 */
public class PlaceCommand implements Command {

  private static final Logger LOG = LoggerFactory.getLogger(PlaceCommand.class);

  private State state;

  public PlaceCommand(final String[] params) {
    try {
      this.state = new State(true, Integer.parseInt(params[0]), Integer.parseInt(params[1]), Compass.valueOf(params[2]));
    } catch (Exception e) {
      this.state = new State(false);

      LOG.error("Invalid Place Command");
    }
  }

  @Override
  public State execute(final State state) {
    // ignore current/previous state and return a new one
    LOG.debug("State(Current / Previous) {}", state);
    return new State(this.state.isActive(), this.state.getX(), this.state.getY(), this.state.getCompass());
  }

  @Override
  public String toString() {
    return "PlaceCommand{" +
            "state=" + state +
            '}';
  }
}
