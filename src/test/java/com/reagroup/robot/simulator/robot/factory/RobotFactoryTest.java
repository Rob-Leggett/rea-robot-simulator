package com.reagroup.robot.simulator.robot.factory;

import com.reagroup.robot.simulator.robot.model.Robot;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RobotFactoryTest {

    private RobotFactory robotFactory;

    @BeforeEach
    public void setup() {
        robotFactory = new RobotFactory();
    }

    @Test
    public void testCreateRobot() {
        // when
        final Robot robot = robotFactory.createRobot();

        //then
        Assertions.assertNotNull(robot);
    }
}
