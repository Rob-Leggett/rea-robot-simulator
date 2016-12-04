package com.reagroup.robot.simulator.robot.factory;

import com.reagroup.robot.simulator.robot.model.Robot;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RobotFactoryTest {

    private RobotFactory robotFactory;

    @Before
    public void setup() {
        robotFactory = new RobotFactory();
    }

    @Test
    public void testCreateRobot() {
        // when
        final Robot robot = robotFactory.createRobot();

        //then
        Assert.assertNotNull(robot);
    }
}
