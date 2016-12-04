package com.reagroup.robot.simulator.robot.model;

import com.reagroup.robot.simulator.command.model.Command;
import com.reagroup.robot.simulator.command.model.PlaceCommand;
import com.reagroup.robot.simulator.constants.Compass;
import com.reagroup.robot.simulator.state.model.State;
import com.reagroup.robot.simulator.table.model.StandardTable;
import com.reagroup.robot.simulator.table.model.Table;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class BasicRobotTest {

    private Robot robot;

    @Before
    public void setup() {
        robot = new BasicRobot();
    }

    @Test
    public void testInitialState() {
        // when
        final State state = robot.getState();

        // then
        Assert.assertNotNull(state);
        Assert.assertFalse(state.isActive());
        Assert.assertEquals(0, state.getX());
        Assert.assertEquals(0, state.getY());
        Assert.assertNull(state.getCompass());
    }

    @Test
    public void testExecuteCommandPlacingRobotOnTheTable() {
        // given
        final Table table = new StandardTable(5, 5);
        final Command command = new PlaceCommand(new String[]{"2", "2", "NORTH"});

        // when
        robot.execute(table, command);

        // then
        final State state = robot.getState();

        Assert.assertNotNull(state);
        Assert.assertTrue(state.isActive());
        Assert.assertEquals(2, state.getX());
        Assert.assertEquals(2, state.getY());
        Assert.assertEquals(Compass.NORTH, state.getCompass());
    }

    @Test
    public void testExecuteCommandPlacingRobotOffTheTable() {
        // given
        final Table table = new StandardTable(5, 5);
        final Command command = new PlaceCommand(new String[]{"6,2,NORTH"});

        // when
        robot.execute(table, command);

        // then
        final State state = robot.getState();

        Assert.assertNotNull(state);
        Assert.assertFalse(state.isActive());
        Assert.assertEquals(0, state.getX());
        Assert.assertEquals(0, state.getY());
        Assert.assertNull(state.getCompass());
    }

    @Test
    public void testIsOnTableCalled() {
        // given
        final Table table = Mockito.mock(StandardTable.class);
        final Command command = new PlaceCommand(new String[] {"2","2","NORTH"});

        // when
        robot.execute(table, command);

        // then
        Mockito.verify(table).isOn(2,2);
    }
}
