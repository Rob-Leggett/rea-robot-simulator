package com.reagroup.robot.simulator.robot.factory;

import com.reagroup.robot.simulator.robot.model.BasicRobot;
import com.reagroup.robot.simulator.robot.model.Robot;

/**
 * This class is a factory to create a robot.
 */
public class RobotFactory {

  public Robot createRobot() {
    return new BasicRobot();
  }
}
