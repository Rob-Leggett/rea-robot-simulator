package com.reagroup.robot.simulator.robot.model;

import com.reagroup.robot.simulator.command.model.Command;
import com.reagroup.robot.simulator.state.model.State;
import com.reagroup.robot.simulator.table.model.Table;

public interface Robot {

  State getState();

  void execute(final Table table, final Command command);
}
