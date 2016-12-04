package com.reagroup.robot.simulator.command.model;

import com.reagroup.robot.simulator.state.model.State;

public interface Command {
  State execute(State state);
}
