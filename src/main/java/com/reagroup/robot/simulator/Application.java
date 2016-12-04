package com.reagroup.robot.simulator;

import com.reagroup.robot.simulator.command.factory.CommandFactory;
import com.reagroup.robot.simulator.command.model.Command;
import com.reagroup.robot.simulator.command.services.CommandFileServiceImpl;
import com.reagroup.robot.simulator.common.services.ConfigServiceImpl;
import com.reagroup.robot.simulator.common.services.FileService;
import com.reagroup.robot.simulator.common.utils.ConfigUtils;
import com.reagroup.robot.simulator.robot.factory.RobotFactory;
import com.reagroup.robot.simulator.robot.model.Robot;
import com.reagroup.robot.simulator.state.model.State;
import com.reagroup.robot.simulator.table.factory.TableFactory;
import com.reagroup.robot.simulator.table.model.Table;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * This is the main class for the application, this has the method to run the simulation.
 */
public class Application {

  private static final Logger LOG = LoggerFactory.getLogger(Application.class);

  private TableFactory tableFactory;
  private RobotFactory robotFactory;
  private FileService<Command> commandFileService;

  public Application(final TableFactory tableFactory, final RobotFactory robotFactory, final FileService<Command> commandFileService) {
    this.tableFactory = tableFactory;
    this.robotFactory = robotFactory;
    this.commandFileService = commandFileService;
  }

  public static void main(String[] args) {
    final TableFactory tableFactory = new TableFactory(new ConfigServiceImpl(new ConfigUtils()));
    final RobotFactory robotFactory = new RobotFactory();
    final FileService<Command> commandFileService = new CommandFileServiceImpl(new CommandFactory());

    new Application(tableFactory, robotFactory, commandFileService).simulate(args);
  }

  public State simulate(String[] args) {
    LOG.debug("Beginning simulation");

    // due to having all failures ignored and output logged out, state is being returned to ensure effective testing.
    State state = null;

    if (null != args && args.length > 0) {

      final Table table = tableFactory.createTable();

      final Robot robot = robotFactory.createRobot();

      final List<Command> commands = commandFileService.process(args[0]);

      if (null != commands) {
        // simulate
        commands.forEach(command -> {
          robot.execute(table, command);
        });
      }

      return robot.getState();
    }

    LOG.debug("Completed simulation");

    return state;
  }
}
